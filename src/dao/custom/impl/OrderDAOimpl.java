/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CRUDUtil;
import dao.custom.OrderDAO;
import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderDetail;

/**
 *
 * @author Sahan
 */
public class OrderDAOimpl implements OrderDAO {

    Connection conn;

//    @Override
//    public ArrayList<Customer> loadAllCustomers() throws SQLException, ClassNotFoundException {
//        conn = DBConnect.getInstance().getConnection();
//        
//        PreparedStatement pst = conn.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//
//        ArrayList<Customer> cusList = new ArrayList<>();
//
//        while (rs.next()) {
//            cusList.add(new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
//        }
//        return cusList;
//    }
//
//    @Override
//    public ArrayList<Item> loadAllItems() throws SQLException, ClassNotFoundException {
//        conn = DBConnect.getInstance().getConnection();
//        String sql = "SELECT * FROM item";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//
//        ArrayList<Item> itmList = new ArrayList<>();
//
//        while (rs.next()) {
//            itmList.add(new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
//        }
//        return itmList;
//    }
//
//    @Override
//    public Customer searchCustomer(int no) throws ClassNotFoundException, SQLException {
//        conn = DBConnect.getInstance().getConnection();
//        String sql = "SELECT * FROM customer WHERE contactnumber=?";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setInt(1, no);
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            Customer customer = new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
//            return customer;
//        }
//        return null;
//    }
//
//    @Override
//    public Item searchItem(String code) throws ClassNotFoundException, SQLException {
//        conn = DBConnect.getInstance().getConnection();
//        String sql = "SELECT * FROM item WHERE itemcode=?";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, code);
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            Item itm = new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
//            return itm;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean placeOrder(Order o) throws SQLException, ClassNotFoundException {
//        conn = DBConnect.getInstance().getConnection();
//        try {
//            conn.setAutoCommit(false);
//            if (addOrder(o)) {
//                if (addOrderDetail(o)) {
//                    conn.commit();
//                    return true;
//                }
//            }
//            conn.rollback();
//            return false;
//        } finally {
//            conn.setAutoCommit(true);
//        }
//    }
//
//    @Override
//    public boolean addOrder(Order o) throws SQLException, ClassNotFoundException {
//        conn = DBConnect.getInstance().getConnection();
//        
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, o.getoId());
//        pst.setString(2, o.getoDate());
//        pst.setString(3, o.getCusId());
//        pst.setDouble(4, o.getTotal());
//        return pst.executeUpdate() > 0;
//    }
//
//    @Override
//    public boolean addOrderDetail(Order o) throws SQLException {
//        for (OrderDetail od : o.getoDetail()) {
//            boolean added = addItems(od);
//            if (!added) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public boolean addItems(OrderDetail o) throws SQLException {
//        
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, o.getoId());
//        pst.setString(2, o.getiCode());
//        pst.setInt(3, o.getQty());
//        pst.setDouble(4, o.getuPrice());
//        return pst.executeUpdate() > 0;
//    }
    @Override
    public boolean add(Order odr) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO oder (orderid,orderdate,contactnumber,total) VALUES(?,?,?,?)";
        return CRUDUtil.executeUpdate(sql, odr.getoId(), odr.getoDate(), odr.getCusId(), odr.getTotal());
    }

    @Override
    public ArrayList<Order> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer";
        ResultSet rs = CRUDUtil.executeQuery(sql);

        ArrayList<Order> oList = new ArrayList<>();
        while (rs.next()) {
            oList.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
        }
        return oList;
    }

    @Override
    public Order search(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer WHERE contactnumber=?";
        ResultSet rs = CRUDUtil.executeQuery(sql, id);

        //return new Customer(sql, contactNumber, sql, id);
        return null;
    }

    @Override
    public boolean update(Order obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
