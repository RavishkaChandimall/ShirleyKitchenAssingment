/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderDetail;

/**
 *
 * @author Sahan
 */
public interface OrderBO extends SuperBO{

    public ArrayList<OrderDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;

    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException;

    public boolean placeOrder(OrderDTO o) throws ClassNotFoundException, SQLException;

    public CustomerDTO searchCustomer(String cusno) throws ClassNotFoundException, SQLException;

    public ItemDTO searchItem(String g) throws ClassNotFoundException, SQLException;
}
