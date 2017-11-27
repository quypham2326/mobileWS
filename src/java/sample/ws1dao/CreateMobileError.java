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
public class CreateMobileError implements Serializable{
    private String mobileIdErrLength;
    private String descriptErrLength;
    private String priceErr;
    private String mobileNameErrLength;
    private String quantityErr;
    private  String yearofProductionErr;
    private  String mobileIDisExist;
    private String addItemstoCartErr;
    

    public CreateMobileError() {
    }

    public CreateMobileError(String mobileIdErrLength, String descriptErrLength, String priceErr, String mobileNameErrLength, String quantityErr, String yearofProductionErr, String mobileIDisExist) {
        this.mobileIdErrLength = mobileIdErrLength;
        this.descriptErrLength = descriptErrLength;
        this.priceErr = priceErr;
        this.mobileNameErrLength = mobileNameErrLength;
        this.quantityErr = quantityErr;
        this.yearofProductionErr = yearofProductionErr;
        this.mobileIDisExist = mobileIDisExist;
    }

   

    /**
     * @return the mobileIdErrLength
     */
    public String getMobileIdErrLength() {
        return mobileIdErrLength;
    }

    /**
     * @param mobileIdErrLength the mobileIdErrLength to set
     */
    public void setMobileIdErrLength(String mobileIdErrLength) {
        this.mobileIdErrLength = mobileIdErrLength;
    }

   
    /**
     * @return the mobileNameErrLength
     */
    public String getMobileNameErrLength() {
        return mobileNameErrLength;
    }

    /**
     * @param mobileNameErrLength the mobileNameErrLength to set
     */
    public void setMobileNameErrLength(String mobileNameErrLength) {
        this.mobileNameErrLength = mobileNameErrLength;
    }

    /**
     * @return the quantityErr
     */
    public String getQuantityErr() {
        return quantityErr;
    }

    /**
     * @param quantityErr the quantityErr to set
     */
    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    /**
     * @return the yearofProductionErr
     */
    public String getYearofProductionErr() {
        return yearofProductionErr;
    }

    /**
     * @param yearofProductionErr the yearofProductionErr to set
     */
    public void setYearofProductionErr(String yearofProductionErr) {
        this.yearofProductionErr = yearofProductionErr;
    }

    /**
     * @return the mobileIDisExist
     */
    public String getMobileIDisExist() {
        return mobileIDisExist;
    }

    /**
     * @param mobileIDisExist the mobileIDisExist to set
     */
    public void setMobileIDisExist(String mobileIDisExist) {
        this.mobileIDisExist = mobileIDisExist;
    }

    /**
     * @return the descriptErrLength
     */
    public String getDescriptErrLength() {
        return descriptErrLength;
    }

    /**
     * @param descriptErrLength the descriptErrLength to set
     */
    public void setDescriptErrLength(String descriptErrLength) {
        this.descriptErrLength = descriptErrLength;
    }

    /**
     * @return the priceErr
     */
    public String getPriceErr() {
        return priceErr;
    }

    /**
     * @param priceErr the priceErr to set
     */
    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    /**
     * @return the addItemstoCartErr
     */
    public String getAddItemstoCartErr() {
        return addItemstoCartErr;
    }

    /**
     * @param addItemstoCartErr the addItemstoCartErr to set
     */
    public void setAddItemstoCartErr(String addItemstoCartErr) {
        this.addItemstoCartErr = addItemstoCartErr;
    }
   
    
}
