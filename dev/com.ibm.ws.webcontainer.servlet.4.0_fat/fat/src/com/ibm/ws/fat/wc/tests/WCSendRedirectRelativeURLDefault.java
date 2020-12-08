/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.fat.wc.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.ws.fat.util.LoggingTest;
import com.ibm.ws.fat.util.SharedServer;
import com.ibm.ws.fat.wc.WCApplicationHelper;

import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;

@RunWith(FATRunner.class)
public class WCSendRedirectRelativeURLDefault extends LoggingTest {

    private static final Logger LOG = Logger.getLogger(WCAddJspFileTest.class.getName());

    @ClassRule
    public static SharedServer SHARED_SERVER = new SharedServer("servlet40_sendRedirectURL_Default");

    @Override
    protected SharedServer getSharedServer() {
        return SHARED_SERVER;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        LOG.info("Setup : add TestAddJspFile to the server if not already present.");

        WCApplicationHelper.addEarToServerDropins(SHARED_SERVER.getLibertyServer(), "TestAddJspFile.ear", false,
                                                  "TestAddJspFile.war", true, null, false, "testaddjspfile.war.listeners");

        SHARED_SERVER.startIfNotStarted();
        WCApplicationHelper.waitForAppStart("TestAddJspFile", WCAddJspFileTest.class.getName(), SHARED_SERVER.getLibertyServer());
        LOG.info("Setup : complete, ready for Tests");
    }

    @AfterClass
    public static void testCleanup() throws Exception {
        SHARED_SERVER.getLibertyServer().stopServer();
    }

    /**
     * Test default sendRedirect
     * Request to a JSP which generate sendRedirect(RelativeURL). //NOTE that this target RelativeURL does not actually exist.
     * Use the HttpURLConnection() with conn.setInstanceFollowRedirects(false) to stop following the redirect.
     * The test only interest in the 302 with Location header being set to absolute URL (i.e http://host:port/ portion)
     */
    @Test
    @Mode(TestMode.FULL)
    public void testResponseSendRedirectToRelativeURL_Default() throws Exception {
        String expectedRedirectString = "/TestAddJspFile/targetNoneExistRedirect.jsp";

        LOG.info("\n /************************************************************************************/");
        LOG.info("\n [testResponseSendRedirectToRelativeURL_Default]: Redirect to absolute URL location");
        LOG.info("\n /************************************************************************************/");

        try {
            String URLString = SHARED_SERVER.getServerUrl(true, "/TestAddJspFile/sendRedirect.jsp");
            URL url = new URL(URLString);
            HttpURLConnection con = null;
            int responseCode = 0;
            String locationHeader = "";

            con = (HttpURLConnection) url.openConnection();
            con.setInstanceFollowRedirects(false); //Stop following the REDIRECT; true will follow with redirect
            con.setRequestMethod("GET");
            con.connect();
            responseCode = con.getResponseCode();
            locationHeader = con.getHeaderField("Location");

            LOG.info("\n Actual Response code : [" + responseCode + "] , Expected : 302");
            LOG.info("\n Actual Location header: [" + locationHeader + "] , Expected a Location header that starts with [http*] AND end with [" + expectedRedirectString + "]");

            con.disconnect();

            assertEquals(URLString + " Expecting Response Code 302 ", 302, responseCode);

            //Absolute URL usually starts with either http or https.  Test framework can use different scheme, host and port so can't really check for the exact location.
            // Instead just check for scheme [http] and the "/TestAddJspFile/targetNoneExistRedirect.jsp"

            boolean startsWithHttp = locationHeader.startsWith("http");
            boolean containsExpectedRedirectString = locationHeader.contains(expectedRedirectString);

            assertTrue("Response Location header does not contain the expect absolute URL ", startsWithHttp && containsExpectedRedirectString);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception from request: " + e.getMessage());
        }
        LOG.info("\n /************************************************************************************/");
        LOG.info("\n testResponseSendRedirectToRelativeURL_Default]:  Finish!!!!!!!!!");
        LOG.info("\n /************************************************************************************/");

    }
}