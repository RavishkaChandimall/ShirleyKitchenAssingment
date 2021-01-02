/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dao.custom.ReportDAO;
import dao.custom.impl.ReportDAOimpl;
import java.sql.SQLException;

/**
 *
 * @author Sahan
 */
public interface ReportBO extends SuperBO{
    ReportDAO dao = new ReportDAOimpl();

    public int getTotal() throws ClassNotFoundException, SQLException;
    
    public int getCanceled() throws ClassNotFoundException, SQLException;
}
