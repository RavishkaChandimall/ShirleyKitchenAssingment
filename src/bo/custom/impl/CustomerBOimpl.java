/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Customer;

/**
 *
 * @author Sahan
 */
public class CustomerBOimpl implements CustomerBO{
    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO cus) throws ClassNotFoundException, SQLException {
        Customer c = new Customer(cus.getCusId(), cus.getContactNumber(), cus.getName(), cus.getAddress());
        return dao.add(c);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws ClassNotFoundException, SQLException {
        ArrayList<Customer> c = dao.getAll();
        ArrayList<CustomerDTO> cus = new ArrayList<>();
        
        //advance one
//        c.stream().forEach(e->{
//            cus.add(new CustomerDTO(e.getCusId(), e.getContactNumber(), e.getName(), e.getAddress()));
//        });
        
        
        for (Customer cu : c) {
            cus.add(new CustomerDTO(cu.getCusId(), cu.getContactNumber(), cu.getName(), cu.getAddress()));
        }
        return cus;
    }

    @Override
    public CustomerDTO searchCustomer(String no) throws ClassNotFoundException, SQLException {
        Customer cus = dao.search(no);
        CustomerDTO c = new CustomerDTO(cus.getCusId(), cus.getContactNumber(), cus.getName(), cus.getAddress());
        return c;
    }

    @Override
    public boolean updateCustomer(CustomerDTO cus) throws ClassNotFoundException, SQLException {
        Customer c = new Customer(cus.getCusId(), cus.getContactNumber(), cus.getName(), cus.getAddress());
        return dao.update(c);
    }

    @Override
    public boolean deleteCustomer(String no) throws ClassNotFoundException, SQLException {
        return dao.delete(no);
    }
}
