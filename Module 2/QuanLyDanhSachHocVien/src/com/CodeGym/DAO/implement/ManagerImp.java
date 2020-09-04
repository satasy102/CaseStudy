package com.CodeGym.DAO.implement;

import com.CodeGym.DAO.StudentManager;
import com.CodeGym.entity.Class.Student;
import com.CodeGym.entity.File.FileEntity;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerImp extends Student implements StudentManager {
    public static final int MARGIN_RIGHT = 3;
    public static final int MARGIN_LEFT = -2;
    public static final int AMOUNT_VERTICAL_MARK = 14;
    private static final Scanner sc = new Scanner(System.in);
    static int id = 0;
    FileEntity file = new FileEntity();
    HashMap<Integer, Student> studentHashMap = file.read();
    private final int size = studentHashMap.size();
    private int maxSerial;
    private int maxID;
    private int maxName;
    private int maxPhone;
    private int maxEmail;
    private int maxBirthday;
    private int maxGender;
    private int maxAddress;
    private int maxFirstScore;
    private int maxSecondScore;
    private int maxThirdScore;
    private int maxFourthScore;
    private int maxAverageScore;
    private int lineBreak;

    @Override
    public Student getStudent() {
        System.out.println("Enter Student's ID:");
        int id = (int) checkNum();
        if (studentHashMap.containsKey(id))
            return studentHashMap.get(id);
        return null;
    }

    @Override
    public void showAllStudent() {
        if (studentHashMap.isEmpty()) System.out.println("Nothing to show.");
        else {
            average();
            calculatorMaxFields();
            headTable();
            bodyTable();
        }
    }

    @Override
    public void add() {
        String name = inputFullName();
        String phone = inputPhone();
        String email = inputEmail();
        String birthday = inputBirthday();
        String gender = inputGender();
        String address = inputAddress();

        boolean isExist = checkDuplication(name, phone, email, birthday, gender, address);
        if (isExist) {
            System.out.println("This Student is Existed. System is auto Updated");

        } else {
            getIDFromFile(studentHashMap);

            Student student = new Student(id, name, phone, email, birthday, gender, address);

            studentHashMap.put(id, student);
            file.write(studentHashMap);
            System.out.println("Add Student success.");
        }
    }

    private void getIDFromFile(HashMap<Integer, Student> studentHashMap) {
        id = 0;
        for (int key : studentHashMap.keySet()) {
            if (id < studentHashMap.get(key).getId()) id = studentHashMap.get(key).getId();
        }

        id++;
    }

    private boolean checkDuplication(String name, String phone, String email, String birthday, String gender,
                                     String address) {
        for (int key : studentHashMap.keySet()) {

            if (studentHashMap.get(key).getFullName().equalsIgnoreCase(name) &&
                    studentHashMap.get(key).getPhoneNumber().equalsIgnoreCase(phone)) {
                updateStudent(email, birthday, gender, address, key);
                return true;
            }
        }


        return false;
    }

    private void updateStudent(String email, String birthday, String gender, String address, int key) {
        studentHashMap.get(key).setBirthday(birthday);
        studentHashMap.get(key).setEmail(email);
        studentHashMap.get(key).setGender(gender);
        studentHashMap.get(key).setAddress(address);
    }

    private String inputAddress() {
        System.out.println("Enter Student's address :");
        return sc.nextLine();
    }

    private String inputGender() {
        System.out.println("Enter Student's gender : Male/Female");
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

    private String inputBirthday() {
        System.out.println("Enter Student's birthday :");
        String birthday = sc.nextLine();
        return checkBirthday(birthday);
    }

    private String checkBirthday(String birthday) {
        String BIRTHDAY_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[/-](0?[1-9]|1[012])[/-]\\d{4}$";
        Pattern pattern = Pattern.compile(BIRTHDAY_REGEX);
        Matcher matcher = pattern.matcher(birthday);
        if (matcher.matches()) return birthday;
        else {
            System.out.println("Invalid Birthday format. Input Again:");
            birthday = sc.nextLine();
            return checkBirthday(birthday);
        }
    }

    private String checkPhone(String phone) {
        String PHONE_REGEX = "^0[9873]+\\d{8}$";
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) return phone;
        else {
            System.out.println("Invalid Phone format. Input Again:");
            phone = sc.nextLine();
            return checkPhone(phone);
        }
    }

    private String inputPhone() {
        System.out.println("Enter Student's phone :");
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
        System.out.println("Enter Student's Email :");
        String email = sc.nextLine();
        return checkEmail(email);
    }

    private String inputFullName() {
        System.out.println("Enter Student's name :");
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
    public void edit() {
        Student student = getStudent();

        if (student == null) System.out.println("Not found Student with that ID");
        else {
            boolean check = true;
            while (check) {
                menuEdit();
                System.out.println("Enter your choose:");
                int choose = (int) checkNum();
                switch (choose) {
                    case 1 -> editFullName(student);

                    case 2 -> editPhoneNumber(student);

                    case 3 -> editEmail(student);

                    case 4 -> editBirthday(student);

                    case 5 -> editGender(student);

                    case 6 -> editAddress(student);

                    case 0 -> {
                        System.out.println("Exit Edit");
                        check = false;
                    }

                    default -> System.out.println("Invilid data.");
                }
            }
        }

    }

    private void menuEdit() {
        System.out.println("What's thing do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email");
        System.out.println("4. Birthday");
        System.out.println("5. Gender");
        System.out.println("6. Address");
        System.out.println("0. Exit");
    }

    private void editAddress(Student student) {
        System.out.println("Enter new Student's Address:");
        String newAdd = sc.nextLine();
        student.setAddress(newAdd);
        file.write(studentHashMap);
        System.out.println("Success");
    }

    private void editGender(Student student) {
        System.out.println("Enter new Student's Gender:");
        String newGender = sc.nextLine();
        newGender = checkGender(newGender);
        student.setGender(newGender);
        file.write(studentHashMap);
        System.out.println("Success");
    }

    private void editBirthday(Student student) {
        System.out.println("Enter new Student's Birthday:");
        String newBirhday = sc.nextLine();
        newBirhday = checkBirthday(newBirhday);
        student.setBirthday(newBirhday);
        file.write(studentHashMap);
        System.out.println("Success");
    }

    private void editEmail(Student student) {
        System.out.println("Enter new Student's Email:");
        String newEmail = sc.nextLine();
        newEmail = checkEmail(newEmail);
        student.setEmail(newEmail);
        file.write(studentHashMap);
        System.out.println("Success");
    }

    private void editPhoneNumber(Student student) {
        System.out.println("Enter new  Student's Phone Number:");
        String newPhone = sc.nextLine();
        newPhone = checkPhone(newPhone);
        student.setPhoneNumber(newPhone);
        file.write(studentHashMap);
        System.out.println("Success");
    }

    private void editFullName(Student student) {
        System.out.println("Enter new Student's Full Name: ");
        String newName = sc.nextLine();
        newName = checkFullName(newName);
        student.setFullName(newName);
        file.write(studentHashMap);
        System.out.println("Success");
    }

    @Override
    public void delete() {
        Student student = getStudent();

        if (student == null) System.out.println("Not found Student with that ID");
        else {
            studentHashMap.remove(student.getId());
            file.write(studentHashMap);
            System.out.println("Delete success.");
        }
    }

    @Override
    public void inputScore() {

        showAllStudent();

        menuScore();
        boolean check = true;
        while (check) {

            System.out.println("Enter your choose:");
            int choose = (int) checkNum();

            switch (choose) {
                case 1 -> inputFistScore(choose);

                case 2 -> inputSecondScore(choose);

                case 3 -> inputThirdScore(choose);

                case 4 -> inputFourthScore(choose);

                case 0 -> check = false;
            }
            showAllStudent();
            menuScore();
        }
    }

    private void menuScore() {
        System.out.println("\n1. Fist Score");
        System.out.println("2. Second Score");
        System.out.println("3. Third Score");
        System.out.println("4. Fourth Score");
        System.out.println("0. Exit");
    }

    private void inputFourthScore(int choose) {
        while (choose != 0) {
            System.out.println("FOURTH SCORE");
            Student student = getStudent();
            if (student == null) {
                System.out.println("Not found Student with that ID");
            } else {
                System.out.println("Input score:");
                float fourthScore = checkNum();

                student.setFourthScore(fourthScore);
                file.write(studentHashMap);
            }
            System.out.println("Enter 0 to exit. Any Number to continue:");
            choose = (int) checkNum();
        }

        System.out.println("Input Fourth Score finished.");
    }

    private void inputThirdScore(int choose) {
        while (choose != 0) {
            System.out.println("THIRD SCORE");
            Student student = getStudent();
            if (student == null) {
                System.out.println("Not found Student with that ID");
            } else {
                System.out.println("Input score:");
                float thirdScore = checkNum();

                student.setThirdScore(thirdScore);
                file.write(studentHashMap);
            }
            System.out.println("Enter 0 to exit. Any Number to continue:");
            choose = (int) checkNum();
        }
        System.out.println("Input Third Score finished.");
    }

    private void inputSecondScore(int choose) {
        while (choose != 0) {
            System.out.println("SECOND SCORE");
            Student student = getStudent();
            if (student == null) System.out.println("Not found Student with that ID");
            else {
                System.out.println("Input score:");
                float secondScore = checkNum();

                student.setSecondScore(secondScore);
                file.write(studentHashMap);
            }
            System.out.println("Enter 0 to exit. Any Number to continue:");
            choose = (int) checkNum();

        }
        System.out.println("Input Second Score finished.");
    }

    private void inputFistScore(int choose) {
        while (choose != 0) {
            System.out.println("FIST SCORE");
            Student student = getStudent();

            if (student == null) System.out.println("Not found Student with that ID");
            else {
                System.out.println("Input score:");
                float fistScore = checkNum();

                student.setFistScore(fistScore);
                file.write(studentHashMap);
            }
            System.out.println("Enter 0 to exit. Any Number to continue:");
            choose = (int) checkNum();

        }
        System.out.println("Input Fist Score finished.");
    }

    public void average() {
        for (int key : studentHashMap.keySet()) {
                Student student = studentHashMap.get(key);
            float fistScore = student.getFistScore();
            float secondScore = student.getSecondScore();
            float thirdScore = student.getThirdScore();
            float fourthScore = student.getFourthScore();
            float average = (fistScore + secondScore +
                    thirdScore * 2 + fourthScore * 3) / 7;
            student.setAverage(average);
        }

    }

    @Override
    public void rank() {
        average();
        List<Student> studentList = new ArrayList<>(studentHashMap.values());
        Collections.sort(studentList);
        calculatorMaxFields();

        headTable();
        bodyTable();
    }

    private void lineBreak() {
        for (int i = 1; i <= lineBreak; i++) System.out.print("_");
    }

    public float checkNum() {
        float num;
        String str;
        while (true) {
            try {
                str = sc.nextLine();
                num = Float.parseFloat(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number format. Input again:");
            }
        }
        return num;
    }

    public int lengthField(String str) {
        return str.length();
    }

    public int maxSerial() {

        int maxSerial = lengthField("Serial");

        for (int i = 1; i <= size; i++) {
            int length = lengthField(String.valueOf(i));
            if (length > maxSerial) maxSerial = length;
        }
        return maxSerial;
    }

    public int maxID() {
        int maxID = lengthField("ID");

        for (int key : studentHashMap.keySet()) {
            int id = studentHashMap.get(key).getId();
            int length = lengthField(String.valueOf(id));
            if (length > maxID) maxID = length;
        }

        return maxID;
    }

    public int maxName() {
        int maxName = lengthField("Full Name");

        for (int key : studentHashMap.keySet()) {
            String name = studentHashMap.get(key).getFullName();
            int length = lengthField(name);
            if (length > maxName) maxName = length;
        }

        return maxName;
    }

    public int maxPhoneNumber() {
        int maxPhone = lengthField("Phone Number");

        for (int key : studentHashMap.keySet()) {
            String phone = studentHashMap.get(key).getPhoneNumber();
            int length = lengthField(phone);
            if (length > maxPhone) maxPhone = length;
        }

        return maxPhone;
    }

    public int maxEmail() {
        int maxEmail = lengthField("Email");

        for (int key : studentHashMap.keySet()) {

            String email = studentHashMap.get(key).getEmail();
            int length = lengthField(email);
            if (length > maxEmail) maxEmail = length;
        }

        return maxEmail;
    }

    public int maxBirthday() {
        int maxBirthday = lengthField("Birthday");

        for (int key : studentHashMap.keySet()) {

            String birthday = studentHashMap.get(key).getBirthday();
            int length = lengthField(birthday);
            if (length > maxBirthday) maxBirthday = length;
        }

        return maxBirthday;
    }

    public int maxGender() {
        int maxGender = lengthField("Gender");

        for (int key : studentHashMap.keySet()) {

            String Gender = studentHashMap.get(key).getGender();
            int length = lengthField(Gender);
            if (length > maxGender) maxGender = length;
        }

        return maxGender;
    }

    public int maxAddress() {
        int maxAddress = lengthField("Address");

        for (int key : studentHashMap.keySet()) {

            String address = studentHashMap.get(key).getAddress();
            int length = lengthField(address);
            if (length > maxAddress) maxAddress = length;
        }

        return maxAddress;
    }

    public void calculatorMaxFields() {
        maxSerial = -(maxSerial() + MARGIN_RIGHT);
        maxID = -(maxID() + MARGIN_RIGHT);
        maxName = -(maxName() + MARGIN_RIGHT);
        maxPhone = -(maxPhoneNumber() + MARGIN_RIGHT);
        maxEmail = -(maxEmail() + MARGIN_RIGHT);
        maxBirthday = -(maxBirthday() + MARGIN_RIGHT);
        maxGender = -(maxGender() + MARGIN_RIGHT);
        maxAddress = -(maxAddress() + MARGIN_RIGHT);
        maxFirstScore = -(lengthField("First Score") + MARGIN_RIGHT);
        maxSecondScore = -(lengthField("Second Score") + MARGIN_RIGHT);
        maxThirdScore = -(lengthField("Third Score") + MARGIN_RIGHT);
        maxFourthScore = -(lengthField("Fourth Score") + MARGIN_RIGHT);
        maxAverageScore = -(lengthField("Average Score") + MARGIN_RIGHT);

        lineBreak = -(maxSerial + maxID + maxName + maxPhone + maxEmail + maxBirthday + maxGender + maxAddress +
                maxFirstScore + maxSecondScore + maxThirdScore + maxFourthScore + maxAverageScore) +
                -MARGIN_LEFT * AMOUNT_VERTICAL_MARK;

    }

    private void headTable() {
        lineBreak();

        System.out.printf("\n%" + MARGIN_LEFT + "s%" + maxSerial + "s%" + MARGIN_LEFT + "s%" + maxID + "s%" +
                        MARGIN_LEFT + "s%" + maxName + "s%" + MARGIN_LEFT + "s%" + maxPhone + "s%" +
                        MARGIN_LEFT + "s%" + maxEmail + "s%" + MARGIN_LEFT + "s%" + maxBirthday + "s%" +
                        MARGIN_LEFT + "s%" + maxGender + "s%" + MARGIN_LEFT + "s%" + maxAddress + "s%" +
                        MARGIN_LEFT + "s%" + maxFirstScore + "s%" + MARGIN_LEFT + "s%" + maxSecondScore + "s%" +
                        MARGIN_LEFT + "s%" + maxThirdScore + "s%" + MARGIN_LEFT + "s%" + maxFourthScore + "s%" +
                        MARGIN_LEFT + "s%" + maxAverageScore + "s%" + MARGIN_LEFT + "s\n",
                "|", "SERIAL", "|", "ID", "|", "FULL NAME", "|", "PHONE NUMBER", "|", "EMAIL", "|", "BIRTHDAY",
                "|", "GENDER", "|", "ADDRESS", "|", "FIST SCORE", "|", "SECOND SCORE", "|", "THIRD SCORE",
                "|", "FOURTH SCORE", "|", "AVERAGE SCORE", "|");
        lineBreak();
    }

    private void bodyTable() {
        int serial = 0;
        for (int key : studentHashMap.keySet()) {
            Student student = studentHashMap.get(key);
            serial++;
            System.out.printf("\n%" + MARGIN_LEFT + "s%" + maxSerial + "d%" + MARGIN_LEFT + "s%" + maxID + "d%" +
                            MARGIN_LEFT + "s%" + maxName + "s%" + MARGIN_LEFT + "s%" + maxPhone + "s%" +
                            MARGIN_LEFT + "s%" + maxEmail + "s%" + MARGIN_LEFT + "s%" + maxBirthday + "s%" +
                            MARGIN_LEFT + "s%" + maxGender + "s%" + MARGIN_LEFT + "s%" + maxAddress + "s%" +
                            MARGIN_LEFT + "s%" + maxFirstScore + ".1f%" + MARGIN_LEFT + "s%" + maxSecondScore + ".1f%" +
                            MARGIN_LEFT + "s%" + maxThirdScore + ".1f%" + MARGIN_LEFT + "s%" + maxFourthScore + ".1f%" +
                            MARGIN_LEFT + "s%" + maxAverageScore + ".1f%" + MARGIN_LEFT + "s\n",
                    "|", serial, "|", student.getId(), "|", student.getFullName(), "|", student.getPhoneNumber(),
                    "|", student.getEmail(), "|", student.getBirthday(), "|", student.getGender(),
                    "|", student.getAddress(), "|", student.getFistScore(), "|", student.getSecondScore(),
                    "|", student.getThirdScore(), "|", student.getFourthScore(),
                    "|", student.getAverage(), "|");
            lineBreak();
        }
    }
}
