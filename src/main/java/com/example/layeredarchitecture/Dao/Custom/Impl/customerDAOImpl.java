package com.example.layeredarchitecture.Dao.Custom.Impl;

import com.example.layeredarchitecture.Dao.Custom.CustomerDAO;
import com.example.layeredarchitecture.Dao.QueryDAO;
import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class customerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        /*stm.executeQuery("SELECT * FROM Customer");*/
        ResultSet rst = SQLUtil.test("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomer=new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDto=new CustomerDTO(rst.getString("id"),rst.getString("name"),rst.getString("address"));
            getAllCustomer.add(customerDto);
        }
        return getAllCustomer;
    }@Override
    public boolean Save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

       return SQLUtil.test("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

@Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

   return SQLUtil.test("UPDATE Customer SET name=?, address=? WHERE id=?" ,customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
    }
@Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
 /*       Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1,id);
        return pstm.executeQuery().next();*/
   ResultSet resultSet =SQLUtil.test("SELECT id FROM Customer WHERE id=?",id);
   return resultSet.next();
    }
@Override
    public boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1,customerDTO.getId() );
        return pstm.executeUpdate()>0;*/
    return SQLUtil.test("DELETE FROM Customer WHERE id=?",customerDTO.getId());
    }
@Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
      */
    ResultSet rst=SQLUtil.test("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
    if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public String Search(String newValue) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, newValue + "");*/
        ResultSet rst = SQLUtil.test("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
        return customerDTO.getName();
    }
  /*  public  void query() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.test("SELECT * FROM Customer c JOIN Orders o ON c.id = o.customerID;");

        while (resultSet.next()) {
            // Retrieve data from the result set
            String customerId = resultSet.getString("id"); // Replace with the actual column name
            String customerName = resultSet.getString("name"); // Replace with the actual column name
            String customerAddress = resultSet.getString("address"); // Replace with the actual column name

            String orderId = resultSet.getString("oid"); // Replace with the actual column name
            String orderDate = resultSet.getString("date"); // Replace with the actual column name

            // Print or process the retrieved data as needed
            System.out.println("Customer ID: " + customerId);
            System.out.println("Customer Name: " + customerName);
            System.out.println("Customer Address: " + customerAddress);

            System.out.println("Order ID: " + orderId);
            System.out.println("Order Date: " + orderDate);

            System.out.println(); // Print an empty line between records
        }

    }*/


}
