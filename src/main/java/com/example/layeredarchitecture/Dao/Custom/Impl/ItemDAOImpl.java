package com.example.layeredarchitecture.Dao.Custom.Impl;

import com.example.layeredarchitecture.Dao.Custom.ItemDAO;
import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst= SQLUtil.test("SELECT * FROM Item");
        ArrayList<ItemDTO> getAlllItem = new ArrayList<>();

        while (rst.next()) {
            // Fix the constructor call
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );

            getAlllItem.add(itemDTO);
        }

        return getAlllItem;
    }@Override
    public boolean delete(ItemDTO c) throws SQLException, ClassNotFoundException {

       return SQLUtil.test("DELETE FROM Item WHERE code=?",c.getCode());

    }
@Override
    public boolean Save(ItemDTO dt) throws SQLException, ClassNotFoundException {

    return SQLUtil.test("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dt.getCode(),dt.getDescription(),dt.getUnitPrice(),dt.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {

        ResultSet resultSet =SQLUtil.test("SELECT code FROM Item WHERE code=?",code);
        return resultSet.next();
    }@Override
    public String generateNewId() throws SQLException, ClassNotFoundException {


        ResultSet rst = SQLUtil.test("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        String code=null;
        if (rst.next()) {
            code = rst.getString("code");
            return code;
        }
        return code;
    }

    @Override
    public String Search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override

    public boolean updateItem(String code, String description, int qtyOnHand, BigDecimal unitPrice) throws SQLException, ClassNotFoundException {

        return SQLUtil.test("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",description,unitPrice,qtyOnHand,code);
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {

        ResultSet rst=SQLUtil.test("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO findItems(String itemCode) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.test("SELECT * FROM Item WHERE code=?",itemCode);
        rst.next();
        ItemDTO item = new ItemDTO(itemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }



}
