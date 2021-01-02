/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sahan
 */
public class CRUDUtil {
    private static PreparedStatement getPreparedStatment(String sql, Object...param) throws ClassNotFoundException, SQLException{
    Connection conn = DBConnect.getInstance().getConnection();
    PreparedStatement pst = conn.prepareStatement(sql);
    
        for (int i = 0; i < param.length; i++) {
            pst.setObject((i+1), param[i]);
        }
        return pst;
    }
    
    public static boolean executeUpdate(String sql, Object...param) throws ClassNotFoundException, SQLException{
        return getPreparedStatment(sql, param).executeUpdate()>0;
    }
    
    public static ResultSet executeQuery(String sql, Object...param) throws ClassNotFoundException, SQLException{
    return getPreparedStatment(sql, param).executeQuery();
    }
}
