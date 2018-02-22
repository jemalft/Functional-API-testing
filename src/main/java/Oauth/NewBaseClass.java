package Oauth;

import com.jayway.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;

/*
OAuth 2.0 allows users to share specific data with an application while keeping their usernames, passwords,
and other information private. For example, an application can use OAuth 2.0 to obtain permission from users
to store files in their Google Drives.
 */

public class NewBaseClass {

    private String adminUser = "admin";
    private String SupervisorUser = "supervisor";
    private String password = "Z00mda1a!";
    private String groupUser = "demo";

    //private   String uri = "http://localhost:8080/zoomdata/api/oauth2";
    protected String setGroupUser() {return groupUser;}

    protected String setAdminUser() {return adminUser;}

    protected  String setSupervisorUser() { return SupervisorUser;}

    protected String setPassword() { return password;}
    //public String setUri() { return uri;}

    public void assertThat(String str, Matcher<Iterable<? extends String>> contains) {
    }

    @BeforeClass
    public void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/login/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }





}
