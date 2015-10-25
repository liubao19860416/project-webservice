
package com.baidu.so.soso;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.baidu.so.soso package. 
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

    private final static QName _FindPersonById_QNAME = new QName("http://service.itcast.cn/", "findPersonById");
    private final static QName _FindPersonByIdResponse_QNAME = new QName("http://service.itcast.cn/", "findPersonByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.baidu.so.soso
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindPersonByIdResponse }
     * 
     */
    public FindPersonByIdResponse createFindPersonByIdResponse() {
        return new FindPersonByIdResponse();
    }

    /**
     * Create an instance of {@link FindPersonById }
     * 
     */
    public FindPersonById createFindPersonById() {
        return new FindPersonById();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPersonById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.itcast.cn/", name = "findPersonById")
    public JAXBElement<FindPersonById> createFindPersonById(FindPersonById value) {
        return new JAXBElement<FindPersonById>(_FindPersonById_QNAME, FindPersonById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPersonByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.itcast.cn/", name = "findPersonByIdResponse")
    public JAXBElement<FindPersonByIdResponse> createFindPersonByIdResponse(FindPersonByIdResponse value) {
        return new JAXBElement<FindPersonByIdResponse>(_FindPersonByIdResponse_QNAME, FindPersonByIdResponse.class, null, value);
    }

}
