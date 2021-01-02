/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.ReportBO;
import dao.custom.impl.ReportDAOimpl;
import dao.custom.ReportDAO;
import db.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import entity.Order;

/**
 *
 * @author Sahan
 */
public class ReportController {

    ReportBO bo = (ReportBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REPORT);

    public int getTotal() throws ClassNotFoundException, SQLException {
        return bo.getTotal();
    }

    public int getCanceled() throws ClassNotFoundException, SQLException {
        return bo.getCanceled();
    }
}
