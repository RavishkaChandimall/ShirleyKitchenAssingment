/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.custom.ItemDAO;
import controller.CustomerController;
import dao.CRUDUtil;
import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Customer;
import entity.Item;

/**
 *
 * @author Sahan
 */
public class ItemDAOimpl implements ItemDAO {

    Connection conn;

    @Override
    public boolean add(Item itm) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO item VALUES(?,?,?,?)";
        return CRUDUtil.executeUpdate(sql, itm.getItemCode(), itm.getDesc(), itm.getQty(), itm.getPrice());
    }

    @Override
    public ArrayList<Item> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM item";
        ResultSet rs = CRUDUtil.executeQuery(sql);

        ArrayList<Item> itmList = new ArrayList<>();
        while (rs.next()) {
            itmList.add(new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
        }
        return itmList;
    }

    @Override
    public Item search(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM item WHERE itemcode=?";
        ResultSet rs = CRUDUtil.executeQuery(sql, id);

        if (rs.next()) {
            return new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
        }
        return null;
    }

    @Override
    public boolean update(Item itm) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE item SET des=?, qtyonhand=?, unitprice=? WHERE itemcode=?";
        return CRUDUtil.executeUpdate(sql, itm.getDesc(), itm.getQty(), itm.getPrice(), itm.getItemCode());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM item WHERE itemcode=?";
        return CRUDUtil.executeUpdate(sql, id);
    }

}
