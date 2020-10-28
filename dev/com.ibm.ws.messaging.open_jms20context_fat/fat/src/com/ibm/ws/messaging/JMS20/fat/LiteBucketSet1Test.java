/*******************************************************************************
 * Copyright (c) 2016,2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.messaging.JMS20.fat;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import componenttest.topology.impl.LibertyServer;
import componenttest.topology.impl.LibertyServerFactory;
import com.ibm.websphere.simplicity.ShrinkHelper;

public class LiteBucketSet1Test {
    private static LibertyServer engineServer =
        LibertyServerFactory.getLibertyServer("JMSContextEngine");

    private static LibertyServer clientServer =
        LibertyServerFactory.getLibertyServer("JMSContextClient");
    private static final int clientPort = clientServer.getHttpDefaultPort();
    private static final String clientHost = clientServer.getHostname();

    private boolean runInServlet(String test, String contextRoot) throws IOException {
        return TestUtils.runInServlet(clientHost, clientPort, contextRoot, test); // throws IOException
    }

    @BeforeClass
    public static void testConfigFileChange() throws Exception {
        engineServer.copyFileToLibertyInstallRoot(
            "lib/features",
            "features/testjmsinternals-1.0.mf");
        engineServer.setServerConfigurationFile("JMSContextEngine.xml");

        clientServer.copyFileToLibertyInstallRoot(
            "lib/features",
            "features/testjmsinternals-1.0.mf");
        clientServer.setServerConfigurationFile("JMSContextClient.xml");

        engineServer.startServer("LiteBucketSet1Test_Engine.log");
        clientServer.startServer("LiteBucketSet1Test_Client.log");
    }

    @AfterClass
    public static void tearDown() {
        try {
            clientServer.stopServer();
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        try {
            engineServer.stopServer();
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        ShrinkHelper.cleanAllExportedArchives();
    }

    // Tests from JMSContectTest_118058
    // 118058_1_1: Creation of JMSContext from Connection factory.

    @Test
    public void testCreateContext_B_SecOff() throws Exception {
        boolean testResult = runInServlet("testCreateContext_B_SecOff", "JMSContext");
        assertTrue("Test testCreateContext_B_SecOff failed", testResult);
    }

    @Test
    public void testCreateContext_TCP_SecOff() throws Exception {
        boolean testResult = runInServlet("testCreateContext_TCP_SecOff", "JMSContext");
        assertTrue("Test testCreateContext_TCP_SecOff failed", testResult);
    }

    // 118058_1_4: Verify default autostart value

    @Test
    public void testautoStart_B_SecOff() throws Exception {
        boolean testResult = runInServlet("testautoStart_B_SecOff", "JMSContext");
        assertTrue("Test testautoStart_B_SecOff failed", testResult);
    }

    @Test
    public void testautoStart_TCP_SecOff() throws Exception {
        boolean testResult = runInServlet("testautoStart_TCP_SecOff", "JMSContext");
        assertTrue("Test testautoStart_TCP_SecOff failed", testResult);
    }

    // JMSContextTest_118061
    // 118061_1 : Verify creation of message from JMSContext. createMessage().

    @Test
    public void testCreateMessage_B_SecOff() throws Exception {
        boolean testResult = runInServlet("testCreateMessage_B_SecOff", "JMSContext");
        assertTrue("Test testCreateMessage_B_SecOff failed", testResult);
    }

    @Test
    public void testCreateMessage_TCP_SecOff() throws Exception {
        boolean testResult = runInServlet("testCreateMessage_TCP_SecOff", "JMSContext");
        assertTrue("Test testCreateMessage_TCP_SecOff failed", testResult);
    }

    @Test
    public void testTextMessageGetBody_B_SecOff() throws Exception {
        boolean testResult = runInServlet("testTextMessageGetBody_B_SecOff", "JMSContext");
        assertTrue("Test testTextMessageGetBody_B_SecOff failed", testResult);
    }

    @Test
    public void testJMSReplyTo() throws Exception {
        boolean testResult = runInServlet("testJMSReplyTo", "JMSContext");
        assertTrue("Test testJMSReplyTo failed", testResult);
    }

    // JMSContextTest_118062

    // 118062_1 Test with createBrowser(Queue queue)
    // 118062_1_1 Creates a QueueBrowser object to peek at the messages on the
    // specified queue.

    @Test
    public void testcreateBrowser_B_SecOff() throws Exception {
        boolean testResult = runInServlet("testcreateBrowser_B_SecOff", "JMSContext");
        assertTrue("Test testcreateBrowser_B_SecOff failed", testResult);
    }

    @Test
    public void testcreateBrowser_TCP_SecOff() throws Exception {
        boolean testResult = runInServlet("testcreateBrowser_TCP_SecOff", "JMSContext");
        assertTrue("Test testcreateBrowser_TCP_SecOff failed", testResult);
    }
}
