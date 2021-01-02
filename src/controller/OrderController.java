/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import bo.custom.OrderBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sahan
 */
public class OrderController {

    OrderBO bo = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

    public ArrayList<OrderDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
        return bo.loadAllCustomers();
    }

    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
        return bo.loadAllItems();
    }

    public boolean placeOrder(OrderDTO o) throws ClassNotFoundException, SQLException {
        return bo.placeOrder(o);
    }

    public CustomerDTO searchCustomer(String cusno) throws ClassNotFoundException, SQLException {
        return bo.searchCustomer(cusno);
    }

    public ItemDTO searchItem(String g) throws ClassNotFoundException, SQLException {
        return bo.searchItem(g);
    }

}
