
package org.zjw.blog.core.permission.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UploadImageService", targetNamespace = "http://service.java.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UploadImageService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUploadAuth", targetNamespace = "http://service.java.org/", className = "GetUploadAuth")
    @ResponseWrapper(localName = "getUploadAuthResponse", targetNamespace = "http://service.java.org/", className = "GetUploadAuthResponse")
    public String getUploadAuth(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0);

}