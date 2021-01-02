/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.SuperBO;
import bo.custom.CustomerBO;
import dao.CRUDDao;
import dao.DAOFactory;
import dao.custom.impl.CustomerDAOimpl;
import dao.custom.CustomerDAO;
import db.DBConnect;
import dto.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Customer;

/**
 *
 * @author Sahan
 */
public class CustomerController {

    CustomerBO dao = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    public boolean addCustomer(CustomerDTO cus) throws ClassNotFoundException, SQLException {
        return dao.addCustomer(cus);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws ClassNotFoundException, SQLException {
        return dao.getAllCustomer();
    }

    public CustomerDTO searchCustomer(String no) throws ClassNotFoundException, SQLException {
        return dao.searchCustomer(no);
    }

    public boolean updateCustomer(CustomerDTO cus) throws ClassNotFoundException, SQLException {
        return dao.updateCustomer(cus);
    }

    public boolean deleteCustomer(String no) throws ClassNotFoundException, SQLException {
        return dao.deleteCustomer(no);
    }
}
