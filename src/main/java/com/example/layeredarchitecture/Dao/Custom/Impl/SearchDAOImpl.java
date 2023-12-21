package com.example.layeredarchitecture.Dao.Custom.Impl;

import com.example.layeredarchitecture.Dao.Custom.SearchDAO;
import com.example.layeredarchitecture.Dao.QueryDAO;
import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchDAOImpl implements SearchDAO, QueryDAO {
    @Override
    public ArrayList<SearchDTO> loadAllData() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test(query());
        ArrayList<SearchDTO> getAll=new ArrayList<>();
        while (rst.next()) {
            SearchDTO searchDTO=new SearchDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            getAll.add(searchDTO);
        }
        return getAll;
    }

    @Override
    public String query() throws SQLException, ClassNotFoundException {
       String sql="SELECT * FROM Customer c JOIN Orders o ON c.id = o.customerID;";
       return sql;
    }
}
