//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.16 at 08:20:52 PM CET 
//


package com.techprimers.spring_boot_soap_example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="creditscore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loanamount" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "creditscore",
    "loanamount"
})
@XmlRootElement(name = "loanRequest")
public class LoanRequest {

    protected int creditscore;
    protected double loanamount;

    /**
     * Gets the value of the creditscore property.
     * 
     */
    public int getCreditscore() {
        return creditscore;
    }

    /**
     * Sets the value of the creditscore property.
     * 
     */
    public void setCreditscore(int value) {
        this.creditscore = value;
    }

    /**
     * Gets the value of the loanamount property.
     * 
     */
    public double getLoanamount() {
        return loanamount;
    }

    /**
     * Sets the value of the loanamount property.
     * 
     */
    public void setLoanamount(double value) {
        this.loanamount = value;
    }

}
