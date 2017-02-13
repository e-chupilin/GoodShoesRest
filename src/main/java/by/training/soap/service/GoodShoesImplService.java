
package by.training.soap.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GoodShoesImplService", targetNamespace = "http://service.soap.training.by/", wsdlLocation = "http://localhost:8080/goodshoesservice/service?wsdl")
public class GoodShoesImplService
    extends Service
{

    private final static URL GOODSHOESIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException GOODSHOESIMPLSERVICE_EXCEPTION;
    private final static QName GOODSHOESIMPLSERVICE_QNAME = new QName("http://service.soap.training.by/", "GoodShoesImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/goodshoesservice/service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GOODSHOESIMPLSERVICE_WSDL_LOCATION = url;
        GOODSHOESIMPLSERVICE_EXCEPTION = e;
    }

    public GoodShoesImplService() {
        super(__getWsdlLocation(), GOODSHOESIMPLSERVICE_QNAME);
    }

    public GoodShoesImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GOODSHOESIMPLSERVICE_QNAME, features);
    }

    public GoodShoesImplService(URL wsdlLocation) {
        super(wsdlLocation, GOODSHOESIMPLSERVICE_QNAME);
    }

    public GoodShoesImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GOODSHOESIMPLSERVICE_QNAME, features);
    }

    public GoodShoesImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GoodShoesImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GoodShoes
     */
    @WebEndpoint(name = "GoodShoesImplPort")
    public GoodShoes getGoodShoesImplPort() {
        return super.getPort(new QName("http://service.soap.training.by/", "GoodShoesImplPort"), GoodShoes.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GoodShoes
     */
    @WebEndpoint(name = "GoodShoesImplPort")
    public GoodShoes getGoodShoesImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.soap.training.by/", "GoodShoesImplPort"), GoodShoes.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GOODSHOESIMPLSERVICE_EXCEPTION!= null) {
            throw GOODSHOESIMPLSERVICE_EXCEPTION;
        }
        return GOODSHOESIMPLSERVICE_WSDL_LOCATION;
    }

}
