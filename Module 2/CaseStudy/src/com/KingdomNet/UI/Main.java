package com.KingdomNet.UI;

import com.KingdomNet.DAO.imp.CyberImp;
import com.KingdomNet.entity.Class.Cyber;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        CyberImp cyberImp = new CyberImp();
        ArrayList<Cyber> cyberArrayList=cyberImp.getCyberArrayList();

        int cyberID;

        menuCyber();
        System.out.println("Enter you choose:");
        int choose = checkNum();
        while (true) {
            switch (choose) {
                case 1 -> {
                    System.out.println("ADD A CYBER");
                    cyberImp.addCyber();
                }
                case 2 -> {
                    System.out.println("EDIT A CYBER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.edit(cyberID);
                }
                case 3 -> {
                    System.out.println("DELETE A CYBER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.delete(cyberID);
                }
                case 4 -> {
                    System.out.println("SHOW ALL CYBERS");
                    cyberImp.showAllCyber();
                }
                case 5 -> {
                    System.out.println("ADD A CUSTOMER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.addCustomer(cyberID,cyberArrayList);
                }
                case 6 -> {
                    System.out.println("FIND CUSTOMERS IN A CYBER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.findCustomerByFullName(cyberID);
                }
                case 7 -> {
                    System.out.println("FIND CUSTOMERS IN SYSTEM");
                    int customerID=cyberImp.inputCustomerID();
                    cyberImp.findCustomersByID(customerID);
                }
                case 8 -> {
                    System.out.println("EDIT A CUSTOMER IN A CYBER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.editCustomer(cyberID);
                }
                case 9 -> {
                    System.out.println("DELETE A CUSTOMER IN A CYBER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.deleteCustomer(cyberID);
                }
                case 10 -> {
                    System.out.println("SHOW ALL CUSTOMERS IN A CYBER");
                    cyberID = cyberImp.inputCyberID();
                    cyberImp.showAllCustomersInCyber(cyberID);
                }
                case 11 -> {
                    System.out.println("SHOW ALL CUSTOMERS");
                    cyberImp.displayAllCustomers();
                }
                case 0 -> System.exit(0);
            }
            menuCyber();
            System.out.println("Enter you choose:");
            choose = checkNum();
        }

    }

    public static void menuCyber() {
        System.out.println("1. Add Cyber");
        System.out.println("2. Update Cyber");
        System.out.println("3. Delete Cyber");
        System.out.println("4. Show all Cyber");
        System.out.println("5. Add a customer");
        System.out.println("6. Search a customer in a Cyber");
        System.out.println("7. Search a customer in System");
        System.out.println("8. Edit Customer");
        System.out.println("9. Delete Customer");
        System.out.println("10. Show all Customer in a Cyber");
        System.out.println("11. Show all Customer in System");
    }

    private static int checkNum() {
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
