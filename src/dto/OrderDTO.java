/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author Sahan
 */
public class OrderDTO {
    private String oId;

    public OrderDTO(String oId) {
        this.oId = oId;
    }
    private String oDate;
    private String cusId;
    private double total;
    private ArrayList<OrderDetailDTO> odetail = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(String oId, String oDate, String cusId, double total) {
        this.oId = oId;
        this.oDate = oDate;
        this.cusId = cusId;
        this.total = total;
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
     * @return the oDate
     */
    public String getoDate() {
        return oDate;
    }

    /**
     * @param oDate the oDate to set
     */
    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    /**
     * @return the cusId
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * @param cusId the cusId to set
     */
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the odetail
     */
    public ArrayList<OrderDetailDTO> getOdetail() {
        return odetail;
    }

    /**
     * @param odetail the odetail to set
     */
    public void setOdetail(ArrayList<OrderDetailDTO> odetail) {
        this.odetail = odetail;
    }

}
