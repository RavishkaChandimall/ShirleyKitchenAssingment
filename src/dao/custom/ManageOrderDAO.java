/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom;

import dao.CRUDDao;
import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Order;

/**
 *
 * @author Sahan
 */
public interface ManageOrderDAO extends CRUDDao<Order,String>{

   public boolean update(String odr) throws ClassNotFoundException, SQLException;
}
