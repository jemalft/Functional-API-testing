/**
 * Copyright (C) Zoomdata, Inc. 2012-2018. All rights reserved.
 */
package Oauth;

public class PayloadVariable {

    public String clientId;
    public static String clientName = "google";
    public static boolean autoApprove = false;

    public static String getClientName() {
        return clientName;
    }

    public static boolean isAutoApprove() {
        return autoApprove;
    }

    public static String getRegisteredRedirectURIs() {
        return registeredRedirectURIs;
    }

    public static String registeredRedirectURIs = "http://localhost:3000/callback.html";

    public void setClientId(String clientId) {this.clientId = clientId;
    }



}
