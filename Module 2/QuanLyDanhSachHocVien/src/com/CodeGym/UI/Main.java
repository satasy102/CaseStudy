package com.CodeGym.UI;

import com.CodeGym.DAO.implement.ManagerImp;

public class Main {

    public static void main(String[] args) {
        ManagerImp managerImp= new ManagerImp();
        menu();
        System.out.println("Enter your choose:");
        int choose= (int) managerImp.checkNum();
        while (true){
            switch (choose){
                case 1 -> {
                    System.out.println("SHOW ALL STUDENT");
                    managerImp.showAllStudent();
                }
                case 2 -> {
                    System.out.println("ADD STUDENT");
                    managerImp.add();
                }
                case 3 -> {
                    System.out.println("EDIT STUDENT INFORMATION");
                    managerImp.edit();
                }
                case 4 -> {
                    System.out.println("DELETE STUDENT");
                    managerImp.delete();
                }
                case 5 -> {
                    System.out.println("INPUT/EDIT SCORE");
                    managerImp.inputScore();
                }
                case 6 -> {
                    System.out.println("RANKING");
                    managerImp.rank();
                }
                case 0 -> {
                    System.out.println("System is exiting.");
                    System.exit(0);
                }
            }
            menu();
            System.out.println("Enter your choose:");
            choose= (int) managerImp.checkNum();
        }
    }

    public static void menu(){
        System.out.println("\n1. Show All Student");
        System.out.println("2. Add Student");
        System.out.println("3. Edit Student Information");
        System.out.println("4. Delete Student");
        System.out.println("5. Input/Edit Score");
        System.out.println("6. Ranking");
        System.out.println("0. Exit");
    }
}
