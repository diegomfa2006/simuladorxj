
package com.dmfa.simuladorxj.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para searchType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="searchType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="string"/&gt;
 *     &lt;enumeration value="regex"/&gt;
 *     &lt;enumeration value="xpath"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "searchType")
@XmlEnum
public enum SearchType {

    @XmlEnumValue("string")
    STRING("string"),
    @XmlEnumValue("regex")
    REGEX("regex"),
    @XmlEnumValue("xpath")
    XPATH("xpath");
    private final String value;

    SearchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchType fromValue(String v) {
        for (SearchType c: SearchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
