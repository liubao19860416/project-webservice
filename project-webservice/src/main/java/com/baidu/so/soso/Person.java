
package com.baidu.so.soso;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="momo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weibo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weixin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
    "id",
    "momo",
    "username",
    "weibo",
    "weixin"
})
public class Person {

    protected int id;
    protected String momo;
    protected String username;
    protected String weibo;
    protected String weixin;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the momo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMomo() {
        return momo;
    }

    /**
     * Sets the value of the momo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMomo(String value) {
        this.momo = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the weibo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeibo() {
        return weibo;
    }

    /**
     * Sets the value of the weibo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeibo(String value) {
        this.weibo = value;
    }

    /**
     * Gets the value of the weixin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * Sets the value of the weixin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeixin(String value) {
        this.weixin = value;
    }

}
