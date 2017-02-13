
package by.training.soap.service.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.training.soap.service.interfaces package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetShoesPrice_QNAME = new QName("http://interfaces.service.soap.training.by/", "getShoesPrice");
    private final static QName _GetAllPricesResponse_QNAME = new QName("http://interfaces.service.soap.training.by/", "getAllPricesResponse");
    private final static QName _SetShoesPrice_QNAME = new QName("http://interfaces.service.soap.training.by/", "setShoesPrice");
    private final static QName _GetAllPrices_QNAME = new QName("http://interfaces.service.soap.training.by/", "getAllPrices");
    private final static QName _GetShoesPriceResponse_QNAME = new QName("http://interfaces.service.soap.training.by/", "getShoesPriceResponse");
    private final static QName _SetShoesPriceResponse_QNAME = new QName("http://interfaces.service.soap.training.by/", "setShoesPriceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.training.soap.service.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetShoesPrice }
     * 
     */
    public SetShoesPrice createSetShoesPrice() {
        return new SetShoesPrice();
    }

    /**
     * Create an instance of {@link GetAllPrices }
     * 
     */
    public GetAllPrices createGetAllPrices() {
        return new GetAllPrices();
    }

    /**
     * Create an instance of {@link GetShoesPriceResponse }
     * 
     */
    public GetShoesPriceResponse createGetShoesPriceResponse() {
        return new GetShoesPriceResponse();
    }

    /**
     * Create an instance of {@link SetShoesPriceResponse }
     * 
     */
    public SetShoesPriceResponse createSetShoesPriceResponse() {
        return new SetShoesPriceResponse();
    }

    /**
     * Create an instance of {@link GetShoesPrice }
     * 
     */
    public GetShoesPrice createGetShoesPrice() {
        return new GetShoesPrice();
    }

    /**
     * Create an instance of {@link GetAllPricesResponse }
     * 
     */
    public GetAllPricesResponse createGetAllPricesResponse() {
        return new GetAllPricesResponse();
    }

    /**
     * Create an instance of {@link ShoesCost }
     * 
     */
    public ShoesCost createShoesCost() {
        return new ShoesCost();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShoesPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.service.soap.training.by/", name = "getShoesPrice")
    public JAXBElement<GetShoesPrice> createGetShoesPrice(GetShoesPrice value) {
        return new JAXBElement<GetShoesPrice>(_GetShoesPrice_QNAME, GetShoesPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPricesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.service.soap.training.by/", name = "getAllPricesResponse")
    public JAXBElement<GetAllPricesResponse> createGetAllPricesResponse(GetAllPricesResponse value) {
        return new JAXBElement<GetAllPricesResponse>(_GetAllPricesResponse_QNAME, GetAllPricesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetShoesPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.service.soap.training.by/", name = "setShoesPrice")
    public JAXBElement<SetShoesPrice> createSetShoesPrice(SetShoesPrice value) {
        return new JAXBElement<SetShoesPrice>(_SetShoesPrice_QNAME, SetShoesPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPrices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.service.soap.training.by/", name = "getAllPrices")
    public JAXBElement<GetAllPrices> createGetAllPrices(GetAllPrices value) {
        return new JAXBElement<GetAllPrices>(_GetAllPrices_QNAME, GetAllPrices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShoesPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.service.soap.training.by/", name = "getShoesPriceResponse")
    public JAXBElement<GetShoesPriceResponse> createGetShoesPriceResponse(GetShoesPriceResponse value) {
        return new JAXBElement<GetShoesPriceResponse>(_GetShoesPriceResponse_QNAME, GetShoesPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetShoesPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.service.soap.training.by/", name = "setShoesPriceResponse")
    public JAXBElement<SetShoesPriceResponse> createSetShoesPriceResponse(SetShoesPriceResponse value) {
        return new JAXBElement<SetShoesPriceResponse>(_SetShoesPriceResponse_QNAME, SetShoesPriceResponse.class, null, value);
    }

}
