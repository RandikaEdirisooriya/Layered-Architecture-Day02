package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
 ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;
   int deleteItem(ItemDTO c) throws SQLException, ClassNotFoundException ;

   int saveItem(ItemDTO dt) throws SQLException, ClassNotFoundException ;
   boolean existItem(String code) throws SQLException, ClassNotFoundException ;
    String genereteId() throws SQLException, ClassNotFoundException;
    void updateItem(ItemDTO dt) throws SQLException, ClassNotFoundException ;
}
