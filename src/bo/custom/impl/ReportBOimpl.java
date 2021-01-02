/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.ReportBO;
import dao.custom.ReportDAO;
import dao.custom.impl.ReportDAOimpl;
import java.sql.SQLException;

/**
 *
 * @author Sahan
 */
public class ReportBOimpl implements ReportBO{
    ReportDAO dao = new ReportDAOimpl();

    public int getTotal() throws ClassNotFoundException, SQLException{
        return dao.getTotal();
    }
    
    public int getCanceled() throws ClassNotFoundException, SQLException{
        return dao.getCanceled();
    }
}
