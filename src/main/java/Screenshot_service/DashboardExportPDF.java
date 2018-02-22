package Screenshot_service;

import Oauth.NewBaseClass;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.contains;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsEqual.equalTo;

public class DashboardExportPDF extends NewBaseClass{

   public String boomarkID = "/5a86ff2ee4b0ba49b99b6ac5";

    //@Test
    public Response basicDashboardScreenshotPDFFormatTest(String bookmarkID) {
    return
        given().auth(). preemptive().basic(setAdminUser(), setPassword())
                .header("Content-Type", "application/json")
                .when ().put(bookmarkID );
    }
    @Test
    public void basicDashboardScreenshotPNGFormatTest() {

        given().auth(). preemptive().basic(setAdminUser(), setPassword())
                .header("Content-Type", "image/PNG")
                .expect().statusCode(200)
                .when ().put(boomarkID)
                //.then().contentType("test",equalTo())
            ;

    }

@Test
    public void validateResponseHeader()
    {
        Response response = basicDashboardScreenshotPDFFormatTest(boomarkID+"?format=PDF");
        Assert.assertEquals(200,response.statusCode(),"status code validated");

        Headers allHeaders = response.headers();

        // Iterate over all the Headers
        for(Header header : allHeaders)
        {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/pdf");

    }

}
