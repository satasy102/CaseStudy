package com.KingdomNet.DAO;

import com.KingdomNet.entity.Class.Customer;
import com.KingdomNet.entity.Class.Cyber;

import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<Customer> getAllCustomers();
    void add(int cyberID,ArrayList<Cyber> cyberList);
    void edit(int id);
    void delete(int id);
    Customer getCustomer(int id);
    ArrayList<Customer> getCustomer(String name);
}
