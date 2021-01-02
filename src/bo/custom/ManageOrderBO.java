/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dao.DAOFactory;
import dao.custom.ManageOrderDAO;
import dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Order;

/**
 *
 * @author Sahan
 */
public interface ManageOrderBO extends SuperBO{

    public ArrayList<OrderDTO> getAllOders() throws ClassNotFoundException, SQLException;

    public boolean cancelOrder(String oId) throws ClassNotFoundException, SQLException;

    public boolean payOrder(String oId) throws SQLException, ClassNotFoundException;
}
