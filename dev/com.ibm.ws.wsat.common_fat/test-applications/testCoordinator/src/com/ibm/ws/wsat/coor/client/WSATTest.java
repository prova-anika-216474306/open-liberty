//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:52 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:54 PM(foreman)-)
//


package com.ibm.ws.wsat.coor.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "WSATTest", targetNamespace = "http://service.part.wsat.ws.ibm.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSATTest {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://service.part.wsat.ws.ibm.com/", className = "com.ibm.ws.wsat.test.client.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://service.part.wsat.ws.ibm.com/", className = "com.ibm.ws.wsat.test.client.InitResponse")
    public void init();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "query", targetNamespace = "http://service.part.wsat.ws.ibm.com/", className = "com.ibm.ws.wsat.test.client.Query")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://service.part.wsat.ws.ibm.com/", className = "com.ibm.ws.wsat.test.client.QueryResponse")
    public String query();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "set", targetNamespace = "http://service.part.wsat.ws.ibm.com/", className = "com.ibm.ws.wsat.test.client.Set")
    @ResponseWrapper(localName = "setResponse", targetNamespace = "http://service.part.wsat.ws.ibm.com/", className = "com.ibm.ws.wsat.test.client.SetResponse")
    public void set(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}