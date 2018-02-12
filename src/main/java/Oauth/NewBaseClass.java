package Oauth;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public class NewBaseClass {

    private String adminUser = "admin";
    private String SupervisorUser = "supervisor";
    private String password = "Z00mda1a!";

    //private   String uri = "http://localhost:8080/zoomdata/api/oauth2";

    protected String setAdminUser() {return adminUser;}

    protected  String setSupervisorUser() { return SupervisorUser;}

    protected String setPassword() { return password;}
    //public String setUri() { return uri;}



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
