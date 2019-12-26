//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.18 at 06:59:08 PM MSK 
//


package by.victor.greenhouse.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Flower complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flower">
 *   &lt;complexContent>
 *     &lt;extension base="{http://by.victor.epam}Plant">
 *       &lt;sequence>
 *         &lt;element name="flowering-time">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="start-month" type="{http://www.w3.org/2001/XMLSchema}gMonth"/>
 *                   &lt;element name="end-month" type="{http://www.w3.org/2001/XMLSchema}gMonth"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="possible-inflorescence-color">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="color" type="{http://by.victor.epam}Color" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flower", propOrder = {
    "floweringTime",
    "possibleInflorescenceColor"
})
public class Flower
    extends Plant
{

    @XmlElement(name = "flowering-time", required = true)
    protected Flower.FloweringTime floweringTime;
    @XmlElement(name = "possible-inflorescence-color", required = true)
    protected Flower.PossibleInflorescenceColor possibleInflorescenceColor;

    /**
     * Gets the value of the floweringTime property.
     * 
     * @return
     *     possible object is
     *     {@link Flower.FloweringTime }
     *     
     */
    public Flower.FloweringTime getFloweringTime() {
        return floweringTime;
    }

    /**
     * Sets the value of the floweringTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flower.FloweringTime }
     *     
     */
    public void setFloweringTime(Flower.FloweringTime value) {
        this.floweringTime = value;
    }

    /**
     * Gets the value of the possibleInflorescenceColor property.
     * 
     * @return
     *     possible object is
     *     {@link Flower.PossibleInflorescenceColor }
     *     
     */
    public Flower.PossibleInflorescenceColor getPossibleInflorescenceColor() {
        return possibleInflorescenceColor;
    }

    /**
     * Sets the value of the possibleInflorescenceColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flower.PossibleInflorescenceColor }
     *     
     */
    public void setPossibleInflorescenceColor(Flower.PossibleInflorescenceColor value) {
        this.possibleInflorescenceColor = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="start-month" type="{http://www.w3.org/2001/XMLSchema}gMonth"/>
     *         &lt;element name="end-month" type="{http://www.w3.org/2001/XMLSchema}gMonth"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "startMonth",
        "endMonth"
    })
    public static class FloweringTime {

        @XmlElement(name = "start-month", required = true)
        @XmlSchemaType(name = "gMonth")
        protected XMLGregorianCalendar startMonth;
        @XmlElement(name = "end-month", required = true)
        @XmlSchemaType(name = "gMonth")
        protected XMLGregorianCalendar endMonth;

        /**
         * Gets the value of the startMonth property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartMonth() {
            return startMonth;
        }

        /**
         * Sets the value of the startMonth property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartMonth(XMLGregorianCalendar value) {
            this.startMonth = value;
        }

        /**
         * Gets the value of the endMonth property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndMonth() {
            return endMonth;
        }

        /**
         * Sets the value of the endMonth property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndMonth(XMLGregorianCalendar value) {
            this.endMonth = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="color" type="{http://by.victor.epam}Color" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "color"
    })
    public static class PossibleInflorescenceColor {

        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<Color> color;

        /**
         * Gets the value of the color property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the color property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Color }
         * 
         * 
         */
        public List<Color> getColor() {
            if (color == null) {
                color = new ArrayList<Color>();
            }
            return this.color;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(floweringTime, flower.floweringTime) &&
                Objects.equals(possibleInflorescenceColor, flower.possibleInflorescenceColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floweringTime, possibleInflorescenceColor);
    }
}