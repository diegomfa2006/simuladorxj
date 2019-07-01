
package com.dmfa.simuladorxj.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para sourceContentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="sourceContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="body"/&gt;
 *     &lt;enumeration value="path"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "sourceContentType")
@XmlEnum
public enum SourceContentType {

    @XmlEnumValue("body")
    BODY("body"),
    @XmlEnumValue("path")
    PATH("path");
    private final String value;

    SourceContentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceContentType fromValue(String v) {
        for (SourceContentType c: SourceContentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
