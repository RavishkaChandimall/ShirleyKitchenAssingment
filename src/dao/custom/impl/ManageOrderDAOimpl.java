/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CRUDUtil;
import dao.custom.ManageOrderDAO;
import db.DBConnect;
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
public class ManageOrderDAOimpl implements ManageOrderDAO {

    Connection conn;

//    @Override
//    public ArrayList<Order> getAllOders() throws ClassNotFoundException, SQLException {
//        conn = DBConnect.getInstance().getConnection();
//        
//        PreparedStatement pst = conn.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//
//        ArrayList<Order> oList = new ArrayList<>();
//
//        while (rs.next()) {
//            oList.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
//        }
//        return oList;
//    }
//
//    @Override
//    public boolean cancelOrder(String oId) throws ClassNotFoundException, SQLException {
//        conn = DBConnect.getInstance().getConnection();
//        
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, oId);
//        return pst.executeUpdate() > 0;
//    }
//
//    @Override
//    public boolean payOrder(String oId) throws SQLException, ClassNotFoundException {
//        conn = DBConnect.getInstance().getConnection();
//        
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, "ok");
//        pst.setString(2, oId);
//        return pst.executeUpdate() > 0;
//    }
    @Override
    public boolean add(Order obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Order> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM oder WHERE payment='false' AND status='none' ORDER BY orderdate ASC";
        ResultSet rs = CRUDUtil.executeQuery(sql);

        ArrayList<Order> oList = new ArrayList<>();

        while (rs.next()) {
            oList.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
        }
        return oList;
    }

    @Override
    public Order search(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String odr) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE oder SET status='canceled' WHERE orderid=?";
        return CRUDUtil.executeUpdate(sql, odr);
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE oder SET payment='ok' WHERE orderid=?";
        return CRUDUtil.executeUpdate(sql, id);
    }

    @Override
    public boolean update(Order obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
