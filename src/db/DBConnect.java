/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sahan
 */
public class DBConnect {
    private Connection conn;
    private static DBConnect dBConnect;

    private DBConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/layerdassignment","root","root");
    }
    
    public static DBConnect getInstance() throws ClassNotFoundException, SQLException{
        if (dBConnect==null) {
            dBConnect=new DBConnect();
        }
        return dBConnect;
    }
    
    public Connection getConnection(){
        return conn;
    }
}
