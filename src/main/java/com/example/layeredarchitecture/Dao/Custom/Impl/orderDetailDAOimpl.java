package com.example.layeredarchitecture.Dao.Custom.Impl;

import com.example.layeredarchitecture.Dao.Custom.orderDetailsDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class orderDetailDAOimpl implements orderDetailsDAO {
    @Override
    public boolean saveOrderDetails(List<OrderDetailDTO> orderDetails,String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm= connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        for (OrderDetailDTO detail : orderDetails) {
            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());
        }

        if (stm.executeUpdate() >0) {
            return true;
        }
        return false;
    }
}