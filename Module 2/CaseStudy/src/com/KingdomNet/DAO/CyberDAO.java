package com.KingdomNet.DAO;

import com.KingdomNet.entity.Class.Cyber;

import java.util.ArrayList;

public interface CyberDAO {
    void addCyber();
    void addCustomer(int cyberID,ArrayList<Cyber> cyberArrayList);
    void edit(int cyberID);
    void delete(int cyberID);
    Cyber getCyber(int cyberID);
}
