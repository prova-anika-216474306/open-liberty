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

package test.wssecfvt.wss11sig;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-01-13T17:16:55.101-06:00
 * Generated source version: 2.6.2
 *
 */
@WebServiceClient(name = "WSS11SigService4",
                  wsdlLocation = "../../wss11sig/resources/WEB-INF/WSS11Signature.wsdl",
                  targetNamespace = "http://wss11sig.wssecfvt.test")
public class WSS11SigService4 extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://wss11sig.wssecfvt.test", "WSS11SigService4");
    public final static QName WSS11Sig4 = new QName("http://wss11sig.wssecfvt.test", "WSS11Sig4");
    static {
        URL url = WSS11SigService4.class.getResource("../../wss11sig/resources/WEB-INF/WSS11Signature.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(WSS11SigService4.class.getName()).log(java.util.logging.Level.INFO,
                                                                                     "Can not initialize the default wsdl from {0}",
                                                                                     "../../wss11sig/resources/WEB-INF/WSS11Signature.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WSS11SigService4(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WSS11SigService4(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSS11SigService4() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     *
     * @return
     *         returns WSS11Sig
     */
    @WebEndpoint(name = "WSS11Sig4")
    public WSS11Sig getWSS11Sig4() {
        return super.getPort(WSS11Sig4, WSS11Sig.class);
    }

    /**
     *
     * @param features
     *                     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter will have their
     *                     default values.
     * @return
     *         returns WSS11Sig
     */
    @WebEndpoint(name = "WSS11Sig4")
    public WSS11Sig getWSS11Sig4(WebServiceFeature... features) {
        return super.getPort(WSS11Sig4, WSS11Sig.class, features);
    }

}