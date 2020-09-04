package com.CodeGym.entity.File;

import com.CodeGym.entity.Class.Student;

import java.io.*;
import java.util.HashMap;

public class FileEntity {
    public final String SOURCE_CUSTOMER = "studentManager.dat";

    public void write(HashMap<Integer, Student> studentHashMap) {
        File fileSource = null;
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fileSource = new File(SOURCE_CUSTOMER);
            fout = new FileOutputStream(fileSource);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(studentHashMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(fout);
            closeStream(oos);
        }

    }

    public HashMap<Integer, Student> read() {
        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        File fileSource = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            fileSource = new File(SOURCE_CUSTOMER);
            fin = new FileInputStream(fileSource);
            ois = new ObjectInputStream(fin);
            studentHashMap = (HashMap<Integer, Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File has not been created. " +
                    "The system will create the file as soon as the program ends.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(fin);
            closeStream(ois);
        }
        return studentHashMap;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


