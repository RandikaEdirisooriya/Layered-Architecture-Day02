package com.example.layeredarchitecture.Dao;

import java.sql.SQLException;

public interface QueryDAO {
     String query() throws SQLException, ClassNotFoundException;

}
