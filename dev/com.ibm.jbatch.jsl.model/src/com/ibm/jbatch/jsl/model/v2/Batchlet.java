//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vIBM 2.2.3-11/28/2011 06:21 AM(foreman)-
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.06.11 at 05:49:00 PM EDT
//

package com.ibm.jbatch.jsl.model.v2;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Batchlet complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Batchlet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="properties" type="{https://jakarta.ee/xml/ns/jakartaee}Properties" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ref" use="required" type="{https://jakarta.ee/xml/ns/jakartaee}artifactRef" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Batchlet", propOrder = {
                                          "properties"
})
@Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
public class Batchlet extends com.ibm.jbatch.jsl.model.Batchlet {

    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected JSLProperties properties;
    @XmlAttribute(name = "ref", required = true)
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    protected String ref;

    /** {@inheritDoc} */
    @Override
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public JSLProperties getProperties() {
        return properties;
    }

    /** {@inheritDoc} */
    @Override
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setProperties(com.ibm.jbatch.jsl.model.JSLProperties value) {
        this.properties = (JSLProperties) value;
    }

    /** {@inheritDoc} */
    @Override
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public String getRef() {
        return ref;
    }

    /** {@inheritDoc} */
    @Override
    @Generated(value = "com.ibm.jtc.jax.tools.xjc.Driver", date = "2014-06-11T05:49:00-04:00", comments = "JAXB RI v2.2.3-11/28/2011 06:21 AM(foreman)-")
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Copyright 2013 International Business Machines Corp.
     *
     * See the NOTICE file distributed with this work for additional information
     * regarding copyright ownership. Licensed under the Apache License,
     * Version 2.0 (the "License"); you may not use this file except in compliance
     * with the License. You may obtain a copy of the License at
     *
     * http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
    /*
     * Appended by build tooling.
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(100);
        buf.append("Batchlet: ref=" + ref);
        buf.append("\n");
        buf.append("Properties = " + com.ibm.jbatch.jsl.model.helper.PropertiesToStringHelper.getString(properties));
        return buf.toString();
    }

}