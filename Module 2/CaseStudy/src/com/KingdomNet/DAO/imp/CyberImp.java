package com.KingdomNet.DAO.imp;

import com.KingdomNet.DAO.CyberDAO;
import com.KingdomNet.entity.Class.Customer;
import com.KingdomNet.entity.Class.Cyber;
import com.KingdomNet.entity.File.FileEntity;

import java.util.ArrayList;
import java.util.Scanner;

public class CyberImp extends Cyber implements CyberDAO {
    private static final Scanner sc = new Scanner(System.in);
    FileEntity file = new FileEntity();
    ArrayList<Cyber> cyberArrayList = file.read();

    public void showAllCyber() {
        System.out.printf("%-10s%-10s\n", "Cyber ID", "Cyber Address");
        for (Cyber cyber : cyberArrayList) {
            System.out.printf("%-10d%-10s\n", cyber.getCyberID(), cyber.getCyberAddress());
        }
    }

    public ArrayList<Cyber> getCyberArrayList() {
        return cyberArrayList;
    }

    @Override
    public void addCyber() {
        int id = (cyberArrayList.size() != 0) ? (cyberArrayList.size() + 1) : 1;

        String address = inputAddress();

        Cyber cyber = new Cyber(id, address);

        cyberArrayList.add(cyber);

        file.write(cyberArrayList);

        System.out.println("Add cyber success.");

    }

    @Override
    public void addCustomer(int cyberID, ArrayList<Cyber> cyberArrayList) {
        Cyber cyber = getCyber(cyberID);
        cyber.customerImp.add(cyberID, cyberArrayList);

        file.write(cyberArrayList);
        System.out.println("Add customer success.");
    }

    private String inputAddress() {
        System.out.println("Enter Cyber's address:");
        return sc.nextLine();
    }

    @Override
    public void edit(int cyberID) {
        showAllCyber();
        Cyber cyber = getCyber(cyberID);
        if (cyber != null) {
            System.out.println("Enter new Cyber's address: ");
            String newAdd = sc.nextLine();
            cyber.setCyberAddress(newAdd);
            file.write(cyberArrayList);

            System.out.println("Update Cyber imformation success.");

        } else System.out.println("Cyber ID " + cyberID + " is not exist.");

    }

    @Override
    public void delete(int cyberID) {
        showAllCyber();
        Cyber cyber = getCyber(cyberID);

        if (cyberArrayList != null) {
            cyberArrayList.remove(cyber);
            file.write(cyberArrayList);

            System.out.println("Delete Cyber success.");
        } else
            System.out.println("Cyber ID " + cyberID + " is not exist.");

    }

    @Override
    public Cyber getCyber(int cyberID) {
        Cyber cyber = null;

        for (Cyber cyb : cyberArrayList) {
            if (cyb.getCyberID() == cyberID) {
                cyber = cyb;
                break;
            }
        }
        return cyber;
    }

    public void findCustomerByFullName(int cyberID) {
        Cyber cyber = getCyber(cyberID);
        ArrayList<Customer> customerList;

        System.out.println("Enter Customer's fullname:");
        String name = sc.nextLine();

        customerList = cyber.customerImp.getCustomer(name);

        if (customerList.size() == 0) System.out.println("Not found.");
        else displayListCustomer(customerList);
    }

    private void displayListCustomer(ArrayList<Customer> customerList) {
        int serial;
        serial = 0;
        System.out.printf("%10s%5s%20s%15s%30s%10s%20s%10s\n", "Serial", "ID", "Fullname", "Phone number",
                "Email", "Age", "Address", "Cyber ID");
        for (Customer customer : customerList) {
            serial++;
            System.out.printf("%10d%5d%20s%15s%30s%10d%20s%10d\n",
                    serial, customer.getId(), customer.getFullname(), customer.getPhoneNumber(), customer.getEmail(),
                    customer.getAge(), customer.getAddress(), customer.getCyberID());
        }
    }

    public void findCustomersByID(int customerID) {
        boolean isExist = false;
        for (Cyber cyber : cyberArrayList) {
            Customer cus = cyber.customerImp.getCustomer(customerID);
            if (cus != null) {
                isExist = true;
                displayOneCustomer(cus);
                break;
            }
        }

        if (!isExist) System.out.println("Not found.");
    }

    private void displayOneCustomer(Customer cus) {
        System.out.printf("%5s%20s%15s%30s%10s%20s%10s\n", "ID", "Full Name", "Phone number", "Email",
                "Age", "Address", "Cyber ID");
        System.out.printf("%5d%20s%15s%30s%10d%20s%10d\n", cus.getId(), cus.getFullname(),
                cus.getPhoneNumber(), cus.getEmail(), cus.getAge(), cus.getAddress(), cus.getCyberID());
    }


    public void editCustomer(int cyberID) {
        showAllCustomersInCyber(cyberID);
        Cyber cyber = getCyber(cyberID);
        System.out.println("Enter Customer's ID:");
        int id = checkNum();

        cyber.customerImp.edit(id);
        file.write(cyberArrayList);

    }

    public void deleteCustomer(int cyberID) {
        showAllCustomersInCyber(cyberID);
        Cyber cyber = getCyber(cyberID);
        System.out.println("Enter Customer's ID:");
        int id = checkNum();

        cyber.customerImp.delete(id);
        file.write(cyberArrayList);
    }

    public void showAllCustomersInCyber(int cyberID) {
        Cyber cyber = getCyber(cyberID);
        ArrayList<Customer> customerArrayList = cyber.customerImp.getAllCustomers();
        displayListCustomer(customerArrayList);
    }

    public void displayAllCustomers() {
        int serial = 0;
        System.out.printf("%10s%5s%20s%15s%30s%10s%20s%10s\n", "Serial", "ID", "Fullname",
                "Phone number", "Email", "Age", "Address", "Cyber ID");
        for (Cyber cyber : cyberArrayList) {
            serial = displayCustomersInCyber(cyber, serial);
        }
    }

    public int displayCustomersInCyber(Cyber cyber, int serial) {
        ArrayList<Customer> customerArrayList = cyber.customerImp.getAllCustomers();
        for (Customer cus : customerArrayList) {
            serial++;
            System.out.printf("%10d%5d%20s%15s%30s%10d%20s%10d\n", serial, cus.getId(), cus.getFullname(),
                    cus.getPhoneNumber(), cus.getEmail(), cus.getAge(), cus.getAddress(), cus.getCyberID());
        }
        return serial;
    }

    public int inputCyberID() {
        System.out.print("Enter Cyber's ID: ");
        return checkNum();
    }

    public int inputCustomerID() {
        System.out.print("Enter Customer's ID: ");
        return checkNum();
    }

    private int checkNum() {
        int num;
        String str;
        while (true) {
            try {
                str = sc.nextLine();
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number format. Input again:");
            }
        }
        return num;
    }


}
