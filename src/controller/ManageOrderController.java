/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import bo.custom.ManageOrderBO;
import dao.DAOFactory;
import dao.custom.impl.ManageOrderDAOimpl;
import dao.custom.ManageOrderDAO;
import db.DBConnect;
import dto.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Customer;
import entity.Order;

/**
 *
 * @author Sahan
 */
public class ManageOrderController {

    ManageOrderBO bo = (ManageOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGEORDER);

    public ArrayList<OrderDTO> getAllOders() throws ClassNotFoundException, SQLException {
        return bo.getAllOders();
    }

    public boolean cancelOrder(String oId) throws ClassNotFoundException, SQLException {
        return bo.cancelOrder(oId);
    }

    public boolean payOrder(String oId) throws SQLException, ClassNotFoundException {
        return bo.payOrder(oId);
    }
}
