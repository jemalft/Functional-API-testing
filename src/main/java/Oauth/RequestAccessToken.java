package Oauth;

import Oauth.RegisterClient;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static Oauth.HTTPendPoints.setAccessTokenEndpoint;
import static com.jayway.restassured.RestAssured.given;


public class RequestAccessToken extends RegisterClient {
    private Response getResponseJson (String endpoint) {

        RestAssured.defaultParser = Parser.JSON;

        Map<String,String> clientID = new HashMap();
        clientID.put("clientId", getClientIdFromResponseJSON());



        //PayloadVariable var = new PayloadVariable();
       // var.setClientId(getClientIdFromResponseJSON());  //get clientId from register client HTTP call response

        return

                given().body (clientID)
                        .auth(). preemptive().basic(setAdminUser(), setPassword())
                        .header("Content-Type", "application/vnd.zoomdata.v1+json")
                        .expect()
                        .statusCode(200)
                        .when ()
                        .post (endpoint)
                        .then().contentType(ContentType.JSON).extract().response();
    }



    protected String getAccessTokenFromResponseJSON(){

        Response response = getResponseJson(setAccessTokenEndpoint());
        Map<String, String> jsonResponse = response.jsonPath().getMap("$");

        String accessToken= jsonResponse.get("tokenValue");

        System.out.println("Access Token is " + accessToken);

        return accessToken;
    }
}
