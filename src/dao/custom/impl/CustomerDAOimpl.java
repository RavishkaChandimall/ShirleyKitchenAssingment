/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CRUDUtil;
import dao.custom.CustomerDAO;
import controller.CustomerController;
import db.DBConnect;
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
public class CustomerDAOimpl implements CustomerDAO {

    Connection conn;

    @Override
    public boolean add(Customer cus) throws ClassNotFoundException, SQLException {
        try {
            String sql = "INSERT INTO customer VALUES(?,?,?,?)";
            return CRUDUtil.executeUpdate(sql, cus.getCusId(), cus.getContactNumber(), cus.getName(), cus.getAddress());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer";
        ResultSet rs = CRUDUtil.executeQuery(sql);

        ArrayList<Customer> cusList = new ArrayList<>();

        while (rs.next()) {
            cusList.add(new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
        }
        return cusList;
    }

    @Override
    public Customer search(String id) throws ClassNotFoundException, SQLException {
        try {
            String sql = "SELECT * FROM customer WHERE contactnumber=?";
            ResultSet rs = CRUDUtil.executeQuery(sql, id);

            if (rs.next()) {
                return new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Customer cus) throws ClassNotFoundException, SQLException {
        try {

            String sql = "UPDATE customer SET contactnumber=?, name=?, address=? WHERE cusid=?";
            return CRUDUtil.executeUpdate(sql, cus.getContactNumber(), cus.getName(), cus.getAddress(), cus.getCusId());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        try {

            String sql = "DELETE FROM customer WHERE contactnumber=?";
            return CRUDUtil.executeUpdate(sql, id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
