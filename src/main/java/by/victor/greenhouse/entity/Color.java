//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.18 at 06:59:08 PM MSK 
//


package by.victor.greenhouse.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Color.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Color">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="white"/>
 *     &lt;enumeration value="red"/>
 *     &lt;enumeration value="orange"/>
 *     &lt;enumeration value="green"/>
 *     &lt;enumeration value="yellow"/>
 *     &lt;enumeration value="blue"/>
 *     &lt;enumeration value="light-green"/>
 *     &lt;enumeration value="dark-green"/>
 *     &lt;enumeration value="green"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Color")
@XmlEnum
public enum Color {

    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("red")
    RED("red"),
    @XmlEnumValue("orange")
    ORANGE("orange"),
    @XmlEnumValue("green")
    GREEN("green"),
    @XmlEnumValue("yellow")
    YELLOW("yellow"),
    @XmlEnumValue("blue")
    BLUE("blue"),
    @XmlEnumValue("light-green")
    LIGHT_GREEN("light-green"),
    @XmlEnumValue("dark-green")
    DARK_GREEN("dark-green");
    private final String value;

    Color(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Color fromValue(String v) {
        for (Color c: Color.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
