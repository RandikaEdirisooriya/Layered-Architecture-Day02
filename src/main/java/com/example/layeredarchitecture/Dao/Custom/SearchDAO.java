package com.example.layeredarchitecture.Dao.Custom;

import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchDAO {
    ArrayList<SearchDTO> loadAllData() throws SQLException, ClassNotFoundException;
}
