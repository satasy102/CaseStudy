package com.KingdomNet.DAO.imp;

import com.KingdomNet.DAO.CustomerDAO;
import com.KingdomNet.entity.Class.Customer;
import com.KingdomNet.entity.Class.Cyber;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerImp extends Customer implements CustomerDAO {
    private static final Scanner sc = new Scanner(System.in);
    static int id = 0;
    public ArrayList<Customer> customerList = new ArrayList<>();

    @Override
    public void add(int cyberID, ArrayList<Cyber> cyberList) {

        String name = inputFullName();
        String phone = inputPhone();
        String email = inputEmail();
        int age = inputAge();
        String gender = inputGender();
        String address = inputAddress();

        boolean isExist = checkDuplication(name, phone, email, age, gender, address, cyberList);
        if (isExist) {
            System.out.println("This Customer is Existed in this Cyber. System is auto Updated");

        } else {
            getIDFromFile(cyberList);

            Customer customer = new Customer(id, name, phone, email, age, gender, address, cyberID);

            customerList.add(customer);
        }
    }

    private void getIDFromFile(ArrayList<Cyber> cyberList) {
        id = 0;
        for (Cyber cyber : cyberList) {
            ArrayList<Customer> customerArrayList = cyber.customerImp.customerList;
            for (Customer cus : customerArrayList) {
                if (id < cus.getId()) id = cus.getId();
            }
        }
        id++;
    }

    private boolean checkDuplication(String name, String phone, String email, int age, String gender,
                                     String address, ArrayList<Cyber> cyberList) {

        for (Cyber cyber : cyberList) {
            ArrayList<Customer> customerArrayList = cyber.getCustomerArrayList();
            for (Customer cus : customerArrayList) {
                if (cus.getFullname().equalsIgnoreCase(name) && cus.getPhoneNumber().equalsIgnoreCase(phone)) {
                    updateCustomer(email, age, gender, address, cus);
                    return true;
                }
            }
        }
        return false;
    }

    private void updateCustomer(String email, int age, String gender, String address, Customer cus) {
        cus.setEmail(email);
        cus.setAge(age);
        cus.setGender(gender);
        cus.setAddress(address);
    }

    private String inputAddress() {
        System.out.println("Enter Customer's address :");
        return sc.nextLine();
    }

    private String inputGender() {
        System.out.println("Enter Customer's gender : Male/Female");
        String gender = sc.nextLine();
        return checkGender(gender);

    }

    private String checkGender(String sex) {
        while (!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female")) {
            System.out.println("Gender is only Male or Female. Input again:");
            sex = sc.nextLine();
        }
        return sex;
    }

    private int inputAge() {
        System.out.println("Enter Customer's age :");
        return checkNum();
    }

    private String checkPhone(String phone) {
        String PHONE_REGEX = "^0[9873]+\\d{8}$";
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) return phone;
        else {
            System.out.println("Invalid Email format. Input Again:");
            phone = sc.nextLine();
            return checkPhone(phone);
        }
    }

    private String inputPhone() {
        System.out.println("Enter Customer's phone :");
        String phone = sc.nextLine();
        return checkPhone(phone);
    }

    private String checkEmail(String email) {
        String EMAIL_REGEX = "^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) return email;
        else {
            System.out.println("Invalid Email format. Input Again:");
            email = sc.nextLine();
            return checkEmail(email);
        }
    }

    private String inputEmail() {
        System.out.println("Enter Customer's Email :");
        String email = sc.nextLine();
        return checkEmail(email);
    }

    private String inputFullName() {
        System.out.println("Enter Customer's name :");
        String name = sc.nextLine();
        return checkFullName(name);
    }

    private String checkFullName(String name) {
        String NAME_REGEX = "^[A-Za-z ]{5,30}$";
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) return name;
        else {
            System.out.println("Invalid name format. Input Again:");
            name = sc.nextLine();
            return checkFullName(name);
        }
    }

    @Override
    public void edit(int id) {
        Customer cus = getCustomer(id);

        if (cus != null) {
            boolean check = true;
            while (check) {
                menuEdit();
                System.out.println("Enter your choose:");
                int choose = checkNum();
                switch (choose) {
                    case 1 -> editFullName(cus);

                    case 2 -> editPhoneNumber(cus);

                    case 3 -> editEmail(cus);

                    case 4 -> editAge(cus);

                    case 5 -> editGender(cus);

                    case 6 -> editAddress(cus);

                    case 0 -> {
                        System.out.println("Exit Edit");
                        check = false;
                    }

                    default -> System.out.println("Invilid data.");
                }
            }

        } else System.out.println("ID " + id + " is not exist.");
    }

    private void editAddress(Customer cus) {
        System.out.println("Enter new Customer's Address:");
        String newAdd = sc.nextLine();
        cus.setAddress(newAdd);
        System.out.println("Success");
    }

    private void editGender(Customer cus) {
        System.out.println("Enter new Customer's Gender:");
        String newGender = sc.nextLine();
        newGender = checkGender(newGender);
        cus.setGender(newGender);
        System.out.println("Success");
    }

    private void editAge(Customer cus) {
        System.out.println("Enter new Customer's Age:");
        int newAge = checkNum();
        cus.setAge(newAge);
        System.out.println("Success");
    }

    private void editEmail(Customer cus) {
        System.out.println("Enter new Customer's Email:");
        String newEmail = sc.nextLine();
        newEmail = checkEmail(newEmail);
        cus.setEmail(newEmail);
        System.out.println("Success");
    }

    private void editPhoneNumber(Customer cus) {
        System.out.println("Enter new  Customer's Phone Number:");
        String newPhone = sc.nextLine();
        newPhone = checkPhone(newPhone);
        cus.setPhoneNumber(newPhone);
        System.out.println("Success");
    }

    private void editFullName(Customer cus) {
        System.out.println("Enter new Customer's fullname: ");
        String newName = sc.nextLine();
        newName = checkFullName(newName);
        cus.setFullname(newName);
        System.out.println("Success");
    }


    private void menuEdit() {
        System.out.println("What's thing do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email");
        System.out.println("4. Age");
        System.out.println("5. Gender");
        System.out.println("6. Address");
        System.out.println("0. Exit");
    }

    @Override
    public void delete(int id) {
        Customer cus = getCustomer(id);

        if (cus != null) {
            customerList.remove(cus);
            System.out.println("Delete ID " + id + " success.");
        } else System.out.println("ID " + id + " is not exist.");

    }

    @Override
    public Customer getCustomer(int id) {

        for (Customer cus : customerList) {
            if (cus.getId() == id) {
                return cus;
            }
        }
        return null;
    }


    @Override
    public ArrayList<Customer> getCustomer(String name) {

        ArrayList<Customer> listResult = new ArrayList<>();

        for (Customer cus : customerList) {
            if (cus.getFullname().equalsIgnoreCase(name)) {
                listResult.add(cus);
            }
        }
        return listResult;
    }


    @Override
    public ArrayList<Customer> getAllCustomers() {
        return customerList;
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
