package com.KingdomNet.entity.Class;

import com.KingdomNet.DAO.imp.CustomerImp;

import java.io.Serializable;
import java.util.ArrayList;

public class Cyber implements Serializable {
    private int cyberID;
    private String cyberAddress;
    public CustomerImp customerImp=new CustomerImp();

    public Cyber(int cyberID, String cyberAddress) {
        this.cyberID = cyberID;
        this.cyberAddress = cyberAddress;
    }

    public Cyber() {
    }

    public int getCyberID() {
        return cyberID;
    }

    public String getCyberAddress() {
        return cyberAddress;
    }

    public void setCyberAddress(String cyberAddress) {
        this.cyberAddress = cyberAddress;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerImp.customerList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerImp.customerList = customerArrayList;
    }
}
