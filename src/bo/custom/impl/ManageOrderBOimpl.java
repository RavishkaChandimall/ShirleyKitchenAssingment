/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.ManageOrderBO;
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
public class ManageOrderBOimpl implements ManageOrderBO {

    ManageOrderDAO dao = (ManageOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MANAGEORDER);

    @Override
    public ArrayList<OrderDTO> getAllOders() throws ClassNotFoundException, SQLException {
        ArrayList<Order> o = dao.getAll();
        ArrayList<OrderDTO> allOders = new ArrayList<>();

        for (Order odr : o) {
            allOders.add(new OrderDTO(odr.getoId(), odr.getoDate(), odr.getCusId(), odr.getTotal()));
        }
        return allOders;
    }

    @Override
    public boolean cancelOrder(String oId) throws ClassNotFoundException, SQLException {
        return dao.update(oId);
    }

    @Override
    public boolean payOrder(String oId) throws SQLException, ClassNotFoundException {
        return dao.update(oId);
    }

}
