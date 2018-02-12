/**
 * Copyright (C) Zoomdata, Inc. 2012-2018. All rights reserved.*/

package OauthTests;

import Oauth.RequestAccessToken;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.testng.annotations.Test;


public class OauthWorkFlowTest extends RequestAccessToken {

    private WebDriver driver = new ChromeDriver();

  @Test
    public void makeSureUserAuthenticatedViaAccessToken(){


       String url = "http://localhost:8080/zoomdata/visualization/5a7b85f7e4b0ba49ab94a266+5a7bce0ae4b0ba4972a95cc3?access_token=" + getAccessTokenFromResponseJSON();

        driver.get(url);


        assertThat(url, is(equalTo(driver.getCurrentUrl())));

    }


    }


