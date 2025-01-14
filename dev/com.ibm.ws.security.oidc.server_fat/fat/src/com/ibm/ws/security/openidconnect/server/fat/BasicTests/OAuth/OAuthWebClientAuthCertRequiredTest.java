/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.security.openidconnect.server.fat.BasicTests.OAuth;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Assume;

import com.ibm.websphere.simplicity.log.Log;
import com.ibm.ws.security.oauth_oidc.fat.commonTest.Constants;
import com.ibm.ws.security.oauth_oidc.fat.commonTest.TestServer;
import com.ibm.ws.security.oauth_oidc.fat.commonTest.TestSettings;
import com.ibm.ws.security.openidconnect.server.fat.BasicTests.CommonTests.genericWebClientAuthCertTest;

import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.topology.impl.LibertyServerWrapper;
import componenttest.topology.utils.LDAPUtils;

@LibertyServerWrapper
@Mode(TestMode.FULL)
@RunWith(FATRunner.class)
public class OAuthWebClientAuthCertRequiredTest extends genericWebClientAuthCertTest {

    private static final Class<?> thisClass = OAuthWebClientAuthCertRequiredTest.class;

    @BeforeClass
    public static void setupBeforeTest() throws Exception {
    	/*
    	 * These tests have not been configured to run with the local LDAP server.
    	 */
    	Assume.assumeTrue(!LDAPUtils.USE_LOCAL_LDAP_SERVER);
        msgUtils.printClassName(thisClass.toString());
        Log.info(thisClass, "setupBeforeTest", "Prep for test");
        // add any additional messages that you want the "start" to wait for 
        // we should wait for any providers that this test requires
        List<String> extraMsgs = new ArrayList<String>();
        extraMsgs.add("CWWKS1600I.*" + Constants.OIDCCONFIGSAMPLE_APP);
        extraMsgs.add("CWWKS1631I.*");

        List<String> extraApps = new ArrayList<String>();
        TestServer.addTestApp(null, extraMsgs, Constants.OP_SAMPLE_APP, Constants.OAUTH_OP);
        TestServer.addTestApp(extraApps, null, Constants.OP_CLIENT_APP, Constants.OAUTH_OP);

        testSettings = new TestSettings();
        testSettings.setProviderType(Constants.OAUTH_OP);
        setupSSLClientKeyStore("./securitykeys/commonLDAPUser1.jks", "security", "jks");
        testOPServer = commonSetUp("com.ibm.ws.security.openidconnect.server-1.0_fat.cert_required", "server_no_cert_required.xml", Constants.OAUTH_OP, extraApps, Constants.DO_NOT_USE_DERBY, extraMsgs);
        testSettings.setAdminUser("LDAPUser1");
        testSettings.setAdminPswd("LDAPUser1pwd");
        server_cert_config = "server_cert_required.xml";
        server_allow_cert_config = "server_allow_cert.xml";
        server_do_not_allow_cert_config = "server_do_not_allow_cert.xml";
        server_cert_no_user_config = "server_cert_no_user1_required.xml";
        server_cert_user_not_in_trust_config = "server_cert_user1_not_in_trust_required.xml";
    }

}
