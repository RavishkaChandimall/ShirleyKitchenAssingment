/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Item;

/**
 *
 * @author Sahan
 */
public interface ItemBO extends SuperBO{

    public boolean addItem(ItemDTO itm) throws ClassNotFoundException, SQLException;

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException;

    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException;

    public boolean updateItem(ItemDTO itm) throws ClassNotFoundException, SQLException;

    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException;
}
