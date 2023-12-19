package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T test(String sql, Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject((i+1),params[i]);
        }
        if (sql.startsWith("SELECT")||sql.startsWith("select")){
            return (T) statement.executeQuery();
        }else{
            return ((T)(Boolean)(statement.executeUpdate()>0));
        }
    }

}
