
package com.dmfa.simuladorxj.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para applicationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="applicationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="searchCriteria" type="{}searchCriteriaType"/&gt;
 *         &lt;element name="request" type="{}requestConfigType" minOccurs="0"/&gt;
 *         &lt;element name="response" type="{}responseConfigType" minOccurs="0"/&gt;
 *         &lt;element name="basePath" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="message" type="{}messageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicationType", propOrder = {
    "name",
    "searchCriteria",
    "request",
    "response",
    "basePath",
    "messages"
})
public class ApplicationType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected SearchCriteriaType searchCriteria;
    protected RequestConfigType request;
    protected ResponseConfigType response;
    @XmlElement(required = true)
    protected String basePath;
    @XmlElement(name = "message")
    protected List<MessageType> messages;

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad searchCriteria.
     * 
     * @return
     *     possible object is
     *     {@link SearchCriteriaType }
     *     
     */
    public SearchCriteriaType getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Define el valor de la propiedad searchCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCriteriaType }
     *     
     */
    public void setSearchCriteria(SearchCriteriaType value) {
        this.searchCriteria = value;
    }

    /**
     * Obtiene el valor de la propiedad request.
     * 
     * @return
     *     possible object is
     *     {@link RequestConfigType }
     *     
     */
    public RequestConfigType getRequest() {
        return request;
    }

    /**
     * Define el valor de la propiedad request.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestConfigType }
     *     
     */
    public void setRequest(RequestConfigType value) {
        this.request = value;
    }

    /**
     * Obtiene el valor de la propiedad response.
     * 
     * @return
     *     possible object is
     *     {@link ResponseConfigType }
     *     
     */
    public ResponseConfigType getResponse() {
        return response;
    }

    /**
     * Define el valor de la propiedad response.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseConfigType }
     *     
     */
    public void setResponse(ResponseConfigType value) {
        this.response = value;
    }

    /**
     * Obtiene el valor de la propiedad basePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * Define el valor de la propiedad basePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasePath(String value) {
        this.basePath = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageType }
     * 
     * 
     */
    public List<MessageType> getMessages() {
        if (messages == null) {
            messages = new ArrayList<MessageType>();
        }
        return this.messages;
    }

}
