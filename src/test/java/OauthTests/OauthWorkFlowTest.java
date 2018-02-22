/**
 * Copyright (C) Zoomdata, Inc. 2012-2018. All rights reserved.*/

package OauthTests;

import Oauth.RequestAccessToken;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.testng.annotations.Test;

import java.util.Set;


public class OauthWorkFlowTest extends RequestAccessToken {

     WebDriver driver = new ChromeDriver();


  @Test(priority = 1)
    public void ClientMakesCallsViaAccessToken() throws InterruptedException {


       String url = "http://localhost:8080/zoomdata/visualization/5a7b85f7e4b0ba49ab94a266+5a86ff2ee4b0ba49b99b6ac5?access_token=" + getAccessTokenFromResponseJSON();

        driver.get(url);


        assertThat(url, contains(driver.getCurrentUrl()));

       // String str = driver.findElement(By.id("status")).getText();

      //  assertThat(str,contains("Ajax call #2 completed"));

      //  System.out.println("Client page title i s ="+ str);

    }

   // @Test(priority = 2)
    public void renderDashboardHoneredByGroupOnlyUser(){

        String url = "http://localhost:8080/zoomdata/visualization/5a7b86cce4b0ba49ab94a309-5a7b85f7e4b0ba49ab94a27a?access_token=" + getAccessTokenFromResponseJSON();
        driver.get(url);

    }




}


