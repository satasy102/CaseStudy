package com.KingdomNet.entity.File;

import com.KingdomNet.entity.Class.Cyber;

import java.io.*;
import java.util.ArrayList;

public class FileEntity {
    public final String SOURCE_CUSTOMER="custommer.dat";

    public void write(ArrayList<Cyber> nameList){
        File fileSource=null;
        FileOutputStream fout=null;
        ObjectOutputStream oos=null;

        try{
            fileSource=new File(SOURCE_CUSTOMER);
            fout=new FileOutputStream(fileSource);
            oos=new ObjectOutputStream(fout);
            oos.writeObject(nameList);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeStream(fout);
            closeStream(oos);
        }

    }

    public ArrayList<Cyber> read(){
        ArrayList<Cyber> nameList=new ArrayList();
        File fileSource=null;
        FileInputStream fin=null;
        ObjectInputStream ois=null;

        try{
            fileSource=new File(SOURCE_CUSTOMER);
            fin=new FileInputStream(fileSource);
            ois=new ObjectInputStream(fin);
            nameList=(ArrayList<Cyber>) ois.readObject();
        } catch (FileNotFoundException e){
            System.out.println("File has not been created. " +
                    "The system will create the file as soon as the program ends.");
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeStream(fin);
            closeStream(ois);
        }
        return nameList;
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
