/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.CustomerDTO;
import dto.ItemDTO;
import entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Item;

/**
 *
 * @author Sahan
 */
public class ItemBOimpl implements ItemBO {

    ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO itm) throws ClassNotFoundException, SQLException {
        Item i = new Item(itm.getItemCode(), itm.getDesc(), itm.getQty(), itm.getPrice());
        return dao.add(i);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException {
        ArrayList<Item> i = dao.getAll();
        ArrayList<ItemDTO> itm = new ArrayList<>();

        for (Item im : i) {
            itm.add(new ItemDTO(im.getItemCode(), im.getDesc(), im.getQty(), im.getPrice()));
        }
        return itm;
    }

    @Override
    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException {
        Item i = dao.search(code);
        ItemDTO c = new ItemDTO(i.getItemCode(), i.getDesc(), i.getQty(), i.getPrice());
        return c;
    }

    @Override
    public boolean updateItem(ItemDTO itm) throws ClassNotFoundException, SQLException {
        Item i = new Item(itm.getItemCode(), itm.getDesc(), itm.getQty(), itm.getPrice());
        return dao.update(i);
    }

    @Override
    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException {
        return dao.delete(code);
    }
}
