package model;

import java.io.*;
import java.util.List;

public class StorageLecturers {
    public static List<Center> readFilelecturers() throws Exception {
        File file = new File("lecturers.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream("lecturers.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Center> listlecturers = (List<Center>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return listlecturers;
    }

    public static void writeFileLecturers(List<Center> list) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("lecturers.dat" );
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
        fileOutputStream.close();
    }

}