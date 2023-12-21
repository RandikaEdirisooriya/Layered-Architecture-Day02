package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.Dao.Custom.Impl.SearchDAOImpl;
import com.example.layeredarchitecture.Dao.Custom.Impl.customerDAOImpl;
import com.example.layeredarchitecture.Dao.Custom.SearchDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.SearchDTO;
import com.example.layeredarchitecture.view.tdm.CustomerTM;
import com.example.layeredarchitecture.view.tdm.SearchTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchFormController {

    @FXML
    private TableColumn<?, ?> CustomerAddress;

    @FXML
    private TableColumn<?, ?> CustomerId;

    @FXML
    private TableColumn<?, ?> CustomerName;

    @FXML
    private TableColumn<?, ?> OrderDate;

    @FXML
    private TableColumn<?, ?> OrderId;

    @FXML
    private TableView<SearchTM> tblSearch;
    public void initialize() throws SQLException, ClassNotFoundException {
        CustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        CustomerAddress.setCellValueFactory(new PropertyValueFactory<>("CustomerAddress"));
        CustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        OrderDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
        OrderId.setCellValueFactory(new PropertyValueFactory<>("OrderID"));

        loadAllData();

    }

    private void loadAllData() {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        String sql = "SELECT * FROM Customer c JOIN Orders o ON c.id = o.customerID;";
        try (PreparedStatement stm = connection.prepareStatement(sql);
             ResultSet res = stm.executeQuery()) {
            ObservableList<SearchTM> obList = FXCollections.observableArrayList();
            while (res.next()) {
                obList.add(new SearchTM(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)



                ));
            }
            tblSearch.setItems(obList);
        }*/
        tblSearch.getItems().clear();
        /*Get all customers*/
        try {

            SearchDAOImpl searchDAO=new SearchDAOImpl();
            ArrayList<SearchDTO> allData=searchDAO.loadAllData();


            for (SearchDTO cu:allData
            ) {
                tblSearch.getItems().add(new SearchTM(cu.getCustomerId(), cu.getCustomerName(), cu.getCustomerAddress(), cu.getOrderID(), cu.getOrderDate()));
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }




    }
}
