package com.example.layeredarchitecture.Dao.Custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;

public interface ItemDAO extends CrudDAO<ItemDTO> {
 /*ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;
   boolean deleteItem(ItemDTO c) throws SQLException, ClassNotFoundException ;

   boolean saveItem(ItemDTO dt) throws SQLException, ClassNotFoundException ;
   boolean existItem(String code) throws SQLException, ClassNotFoundException ;
    String genereteId() throws SQLException, ClassNotFoundException;

 */
 boolean updateItem(String code, String description, int qtyOnHand, BigDecimal unitPrice) throws SQLException, ClassNotFoundException;

    String genarateId() throws SQLException, ClassNotFoundException;

    ItemDTO findItems(String itemCode) throws SQLException, ClassNotFoundException;
}
