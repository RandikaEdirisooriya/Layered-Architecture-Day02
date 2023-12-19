package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean Save(T dto) throws SQLException, ClassNotFoundException;


    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(String customerDTO) throws SQLException, ClassNotFoundException;

    boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    String Search(String newValue) throws SQLException, ClassNotFoundException;
}
