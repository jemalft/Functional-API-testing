/**
 * Copyright (C) Zoomdata, Inc. 2012-2018. All rights reserved.
 */
package Oauth;

import Oauth.NewBaseClass;
import Oauth.PayloadVariable;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


import static Oauth.HTTPendPoints.setClientAppEndpoint;

import static com.jayway.restassured.RestAssured.given;



public class RegisterClient extends NewBaseClass{

    public Response sendRequestToRegisterClient(String endpoint) {

        RestAssured.defaultParser = Parser.JSON;



      return
        given().body ("{\n    \"clientName\": \"Google\",\n    \"registeredRedirectURIs\": [\"http://localhost:8088\"],\n    \"autoApprove\" : false\n}\n\n\n")
                .auth(). preemptive().basic(setSupervisorUser(), setPassword())
                .header("Content-Type", "application/vnd.zoomdata.v1+json")
                .expect().statusCode(200)
                .when ().post(endpoint)
                .then().contentType(ContentType.JSON).extract().response();
    }


   protected String getClientIdFromResponseJSON() {

       Response response = sendRequestToRegisterClient(setClientAppEndpoint());

       Map<String, String> jsonResponse = response.jsonPath().getMap("$");

       String clientId = jsonResponse.get("clientId");

       System.out.println("Your client ID is = " + clientId);

      return clientId;

   }






}
