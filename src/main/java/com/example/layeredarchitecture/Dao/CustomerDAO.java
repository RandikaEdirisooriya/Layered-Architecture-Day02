package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
   /* ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean customerSave(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;


    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String customerDTO) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    String SearchCustomer(String newValue) throws SQLException, ClassNotFoundException;*/
}
