package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface orderDetailsDAO {
    boolean saveOrderDetails(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException;
}
