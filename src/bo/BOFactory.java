/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import bo.custom.impl.CustomerBOimpl;
import bo.custom.impl.ItemBOimpl;
import bo.custom.impl.ManageOrderBOimpl;
import bo.custom.impl.OrderBOimpl;
import bo.custom.impl.ReportBOimpl;

/**
 *
 * @author Sahan
 */
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {

        CUSTOMER, ITEM, MANAGEORDER, REPORT, ORDER;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOimpl();
            case ITEM:
                return new ItemBOimpl();
            case MANAGEORDER:
                return new ManageOrderBOimpl();
            case ORDER:
                return new OrderBOimpl();
            case REPORT:
                return new ReportBOimpl();
            default:
                return null;
        }
    }
}
