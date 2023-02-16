package model;

import java.io.*;
import java.util.ArrayList;

public class StorageLecturers {
    public static ArrayList<Lecturers> readFilelecturers() throws Exception {
        File file = new File("nhiphan.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream("nhiphan.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Lecturers> listlecturers = (ArrayList<Lecturers>) objectInputStream.readObject();
        objectInputStream.close();
        return listlecturers;
    }

    public static void writeFileLecturers(ArrayList<Lecturers> list) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("nhiphan.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }

}