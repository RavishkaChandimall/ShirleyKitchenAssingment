/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Sahan
 */
public class OrderDetailDTO {
        private String oId;
    private String iCode;
    private int qty;
    private double uPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String oId, String iCode, int qty, double uPrice) {
        this.oId = oId;
        this.iCode = iCode;
        this.qty = qty;
        this.uPrice = uPrice;
    }

    /**
     * @return the oId
     */
    public String getoId() {
        return oId;
    }

    /**
     * @param oId the oId to set
     */
    public void setoId(String oId) {
        this.oId = oId;
    }

    /**
     * @return the iCode
     */
    public String getiCode() {
        return iCode;
    }

    /**
     * @param iCode the iCode to set
     */
    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the uPrice
     */
    public double getuPrice() {
        return uPrice;
    }

    /**
     * @param uPrice the uPrice to set
     */
    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }
}
