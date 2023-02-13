package storage.Lecturers;

import codegym.Lecturers;
import controller.managerlecturers.ManagerLecturers;

import java.io.*;

public class StorageLecturers {
    ManagerLecturers managerLecturers=new ManagerLecturers();
    public void writedata(File file){
        try {
            OutputStream outputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            for (Lecturers k: managerLecturers.getListlecturers()
                 ) {
                objectOutputStream.writeObject(k);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
