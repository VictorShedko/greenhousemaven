//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.18 at 06:59:08 PM MSK 
//


package by.victor.greenhouse.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


/**
 * <p>Java class for Growing-tips complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Growing-tips">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="heliophilous" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="watering">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *               &lt;maxExclusive value="10000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="min-temperature" type="{http://by.victor.epam}Temperature"/>
 *         &lt;element name="max-temperature" type="{http://by.victor.epam}Temperature"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Growing-tips", propOrder = {
    "heliophilous",
    "watering",
    "minTemperature",
    "maxTemperature"
})
public class GrowingTips {

    protected Boolean heliophilous;
    protected Integer watering;
    @XmlElement(name = "min-temperature")
    @XmlSchemaType(name = "positiveInteger")
    protected Integer minTemperature;
    @XmlElement(name = "max-temperature")
    @XmlSchemaType(name = "positiveInteger")
    protected Integer maxTemperature;

    /**
     * Gets the value of the heliophilous property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHeliophilous() {
        return heliophilous;
    }

    /**
     * Sets the value of the heliophilous property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHeliophilous(Boolean value) {
        this.heliophilous = value;
    }

    /**
     * Gets the value of the watering property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWatering() {
        return watering;
    }

    /**
     * Sets the value of the watering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWatering(Integer value) {
        this.watering = value;
    }

    /**
     * Gets the value of the minTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinTemperature() {
        return minTemperature;
    }

    /**
     * Sets the value of the minTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinTemperature(Integer value) {
        this.minTemperature = value;
    }

    /**
     * Gets the value of the maxTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * Sets the value of the maxTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxTemperature(Integer value) {
        this.maxTemperature = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowingTips that = (GrowingTips) o;
        return Objects.equals(heliophilous, that.heliophilous) &&
                Objects.equals(watering, that.watering) &&
                Objects.equals(minTemperature, that.minTemperature) &&
                Objects.equals(maxTemperature, that.maxTemperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heliophilous, watering, minTemperature, maxTemperature);
    }
}