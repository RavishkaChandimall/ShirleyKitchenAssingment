/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailsDAO;
import db.DBConnect;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import java.sql.Connection;
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
public class OrderBOimpl implements OrderBO{

    OrderDAO dao = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    CustomerDAO daoCus = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO daoItm = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDetailsDAO daood = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public ArrayList<OrderDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Order> o = dao.getAll();
        ArrayList<OrderDTO> odr = new ArrayList<>();
        
        for (Order od : o) {
            odr.add(new OrderDTO(od.getoId(), od.getoDate(), od.getCusId(), od.getTotal()));
        }
        return odr;
    }

    @Override
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> i = daoItm.getAll();
        ArrayList<ItemDTO> itm = new ArrayList<>();
        
        for (Item it : i) {
            itm.add(new ItemDTO(it.getItemCode(), it.getDesc(), it.getQty(), it.getPrice()));
        }
        return itm;
    }

    @Override
    public boolean placeOrder(OrderDTO o) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnect.getInstance().getConnection();
        conn.setAutoCommit(false);

        Order odr = new Order(o.getoId(), o.getoDate(), o.getCusId(), o.getTotal());
        if (dao.add(odr)) {
            for (OrderDetailDTO odl : o.getOdetail()) {
                OrderDetail od = new OrderDetail(odl.getoId(), odl.getiCode(), odl.getQty(), odl.getuPrice());
                boolean added = daood.add(od);
                if (!added) {
                    conn.rollback();
                    conn.setAutoCommit(true);
                    return false;
                }
            }
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        }
        conn.setAutoCommit(true);
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(String cusno) throws ClassNotFoundException, SQLException {
        Customer c = daoCus.search(cusno);
        CustomerDTO cus = new CustomerDTO(c.getCusId(), c.getContactNumber(), c.getName(), c.getAddress());
        return cus;
    }

    @Override
    public ItemDTO searchItem(String g) throws ClassNotFoundException, SQLException {
        Item i = daoItm.search(g);
        ItemDTO itm = new ItemDTO(i.getItemCode(), i.getDesc(), i.getQty(), i.getPrice());
        return itm;
    }

}
