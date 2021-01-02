/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.impl.ItemDAOimpl;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Item;

/**
 *
 * @author Sahan
 */
public class ItemController {

    ItemBO bo = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    public boolean addItem(ItemDTO itm) throws ClassNotFoundException, SQLException {
        return bo.addItem(itm);
    }

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException {
        return bo.getAllItem();
    }

    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException {
        return bo.searchItem(code);
    }

    public boolean updateItem(ItemDTO itm) throws ClassNotFoundException, SQLException {
        return bo.updateItem(itm);
    }

    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException {
        return bo.deleteItem(code);
    }
}
