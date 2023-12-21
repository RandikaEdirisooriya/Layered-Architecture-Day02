package com.example.layeredarchitecture.model;

public class SearchDTO {
    private String CustomerId;
    private String CustomerName;
    private String CustomerAddress;
    private String OrderID;
    private String OrderDate;

    public SearchDTO() {
    }

    public SearchDTO(String customerId, String customerName, String customerAddress, String orderID, String orderDate) {
        CustomerId = customerId;
        CustomerName = customerName;
        CustomerAddress = customerAddress;
        OrderID = orderID;
        OrderDate = orderDate;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    @Override
    public String toString() {
        return "SearchTm{" +
                "CustomerId='" + CustomerId + '\'' +
                ", CustomerDate='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", OrderID='" + OrderID + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                '}';
    }
}
