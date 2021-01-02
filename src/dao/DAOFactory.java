/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOimpl;
import dao.custom.impl.ItemDAOimpl;
import dao.custom.impl.ManageOrderDAOimpl;
import dao.custom.impl.OrderDAOimpl;
import dao.custom.impl.OrderDetailsDAOimpl;
import dao.custom.impl.ReportDAOimpl;

/**
 *
 * @author Sahan
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {

        CUSTOMER, ITEM, ORDERS, ORDERDETAILS, REPORT, MANAGEORDER;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOimpl();
            case ITEM:
                return new ItemDAOimpl();
            case ORDERS:
                return new OrderDAOimpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOimpl();
            case REPORT:
                return new ReportDAOimpl();
            case MANAGEORDER:
                return new ManageOrderDAOimpl();
            default:
                return null;
        }
    }
}
