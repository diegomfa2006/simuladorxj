//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.07.01 a las 11:21:02 AM ECT 
//


package com.dmfa.simuladorxj.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para searchCriteriaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="searchCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sourceContent" type="{}sourceContentType"/&gt;
 *         &lt;element name="searchType" type="{}searchType"/&gt;
 *         &lt;element name="criteria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="evalValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchCriteriaType", propOrder = {
    "sourceContent",
    "searchType",
    "criteria",
    "evalValue"
})
public class SearchCriteriaType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true, defaultValue = "body")
    @XmlSchemaType(name = "string")
    protected SourceContentType sourceContent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SearchType searchType;
    @XmlElement(required = true)
    protected String criteria;
    @XmlElement(required = true)
    protected String evalValue;

    /**
     * Obtiene el valor de la propiedad sourceContent.
     * 
     * @return
     *     possible object is
     *     {@link SourceContentType }
     *     
     */
    public SourceContentType getSourceContent() {
        return sourceContent;
    }

    /**
     * Define el valor de la propiedad sourceContent.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceContentType }
     *     
     */
    public void setSourceContent(SourceContentType value) {
        this.sourceContent = value;
    }

    /**
     * Obtiene el valor de la propiedad searchType.
     * 
     * @return
     *     possible object is
     *     {@link SearchType }
     *     
     */
    public SearchType getSearchType() {
        return searchType;
    }

    /**
     * Define el valor de la propiedad searchType.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchType }
     *     
     */
    public void setSearchType(SearchType value) {
        this.searchType = value;
    }

    /**
     * Obtiene el valor de la propiedad criteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteria() {
        return criteria;
    }

    /**
     * Define el valor de la propiedad criteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteria(String value) {
        this.criteria = value;
    }

    /**
     * Obtiene el valor de la propiedad evalValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvalValue() {
        return evalValue;
    }

    /**
     * Define el valor de la propiedad evalValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvalValue(String value) {
        this.evalValue = value;
    }

}
