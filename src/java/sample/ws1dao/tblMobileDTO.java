/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.ws1dao;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class tblMobileDTO implements Serializable {

    private String mobileid;
    private String descript;
    private float price;
    private String mobilename;
    private int yop;
    private int quantity;
    private boolean notSale;

    public tblMobileDTO() {
    }

    public tblMobileDTO(String mobileid, String descript, float price, String mobilename, int yop, int quantity, boolean notSale) {
        this.mobileid = mobileid;
        this.descript = descript;
        this.price = price;
        this.mobilename = mobilename;
        this.yop = yop;
        this.quantity = quantity;
        this.notSale = notSale;
    }

    /**
     * @return the mobileid
     */
    public String getMobileid() {
        return mobileid;
    }

    /**
     * @param mobileid the mobileid to set
     */
    public void setMobileid(String mobileid) {
        this.mobileid = mobileid;
    }

    /**
     * @return the descript
     */
    public String getDescript() {
        return descript;
    }

    /**
     * @param descript the descript to set
     */
    public void setDescript(String descript) {
        this.descript = descript;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    /**
     * @return the mobilename
     */
    public String getMobilename() {
        return mobilename;
    }

    /**
     * @param mobilename the mobilename to set
     */
    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }

    /**
     * @return the yop
     */
    public int getYop() {
        return yop;
    }

    /**
     * @param yop the yop to set
     */
    public void setYop(int yop) {
        this.yop = yop;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the notSale
     */
    public boolean isNotSale() {
        return notSale;
    }

    /**
     * @param notSale the notSale to set
     */
    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
