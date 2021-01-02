/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CRUDUtil;
import dao.custom.OrderDetailsDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.OrderDetail;

/**
 *
 * @author Sahan
 */
public class OrderDetailsDAOimpl implements OrderDetailsDAO {

    @Override
    public boolean add(OrderDetail obj) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO orderdetails VALUES(?,?,?,?)";
        return CRUDUtil.executeUpdate(sql, obj.getoId(), obj.getiCode(), obj.getQty(), obj.getuPrice());
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM orderdetails";
        ResultSet rs = CRUDUtil.executeQuery(sql);

        ArrayList<OrderDetail> odList = new ArrayList<>();
        while (rs.next()) {
            odList.add(new OrderDetail(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
        }
        return odList;
    }

    @Override
    public OrderDetail search(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetail obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
