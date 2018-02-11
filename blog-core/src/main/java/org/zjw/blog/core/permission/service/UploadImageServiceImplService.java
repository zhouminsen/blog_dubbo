
package org.zjw.blog.core.permission.service;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UploadImageServiceImplService", targetNamespace = "http://impl.service.java.org/", wsdlLocation = "http://localhost:8080/imageServer/webservice/uploadImageService?wsdl")
public class UploadImageServiceImplService
    extends Service
{

    private final static URL UPLOADIMAGESERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException UPLOADIMAGESERVICEIMPLSERVICE_EXCEPTION;
    private final static QName UPLOADIMAGESERVICEIMPLSERVICE_QNAME = new QName("http://impl.service.java.org/", "UploadImageServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/imageServer/webservice/uploadImageService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        UPLOADIMAGESERVICEIMPLSERVICE_WSDL_LOCATION = url;
        UPLOADIMAGESERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public UploadImageServiceImplService() {
        super(__getWsdlLocation(), UPLOADIMAGESERVICEIMPLSERVICE_QNAME);
    }

    public UploadImageServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), UPLOADIMAGESERVICEIMPLSERVICE_QNAME, features);
    }

    public UploadImageServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, UPLOADIMAGESERVICEIMPLSERVICE_QNAME);
    }

    public UploadImageServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, UPLOADIMAGESERVICEIMPLSERVICE_QNAME, features);
    }

    public UploadImageServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UploadImageServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UploadImageService
     */
    @WebEndpoint(name = "UploadImageServiceImplPort")
    public UploadImageService getUploadImageServiceImplPort() {
        return super.getPort(new QName("http://impl.service.java.org/", "UploadImageServiceImplPort"), UploadImageService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UploadImageService
     */
    @WebEndpoint(name = "UploadImageServiceImplPort")
    public UploadImageService getUploadImageServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.java.org/", "UploadImageServiceImplPort"), UploadImageService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (UPLOADIMAGESERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw UPLOADIMAGESERVICEIMPLSERVICE_EXCEPTION;
        }
        return UPLOADIMAGESERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}