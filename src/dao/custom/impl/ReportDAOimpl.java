/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CRUDUtil;
import dao.custom.ReportDAO;
import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import entity.Customer;
import entity.Order;

/**
 *
 * @author Sahan
 */
public class ReportDAOimpl implements ReportDAO{
    Connection conn;

//    @Override
//    public int getAllOders() throws ClassNotFoundException, SQLException {
//        String date = LocalDate.now().toString();
//
//        conn = DBConnect.getInstance().getConnection();
//        String sql = "SELECT COUNT(orderid) FROM oder WHERE orderdate=?";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, date);
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            return rs.getInt(1);
//        }
//        return 0;
//    }
//    
//    @Override
//    public int getAllCanceled() throws ClassNotFoundException, SQLException {
//        String date = LocalDate.now().toString();
//
//        conn = DBConnect.getInstance().getConnection();
//        String sql = "SELECT COUNT(orderid) FROM oder WHERE orderdate=? AND status=?";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, date);
//        pst.setString(2, "canceled");
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            return rs.getInt(1);
//        }
//        return 0;
//    }

    @Override
    public boolean add(Order obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Order> getAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order search(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Order obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCanceled() throws ClassNotFoundException, SQLException {
        String date = LocalDate.now().toString();
        String sql = "SELECT COUNT(*) FROM oder WHERE orderdate=? AND status='canceled'";
        ResultSet rs = CRUDUtil.executeQuery(sql, date);
        
        int can=0;
        if (rs.next()) {
            can = rs.getInt(1);
        }
        return can;
    }

    @Override
    public int getTotal() throws ClassNotFoundException, SQLException {
        String date = LocalDate.now().toString();
        String sql = "SELECT COUNT(*) FROM oder WHERE orderdate=?";
        ResultSet rs = CRUDUtil.executeQuery(sql, date);
        
        int can=0;
        if (rs.next()) {
            can = rs.getInt(1);
        }
        return can;
    }

  
}
