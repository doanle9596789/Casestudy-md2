package storage;

import model.Center;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteFile {
    private  ReadWriteFile() {}

    private static ReadWriteFile instance;
    private static ReadWriteFile instance1;
    public static ReadWriteFile getInstance() {
        if (instance == null) {
            return instance = new ReadWriteFile();
        }
        return instance;
    }
    public static ReadWriteFile getInstance1() {
        if (instance1 == null) {
            return instance1 = new ReadWriteFile();
        }
        return instance1;
    }
    public void writeToFile(List<Center> lectureList) {
        File file = new File("test.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(lectureList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Center> readToFile() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                List<Center> lecturers;
                try {
                    lecturers = (List<Center>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);

                }
                return lecturers;
            } else {
                return new ArrayList<>();
            }
        }

    }

    @Override
    public void writeToFileStudent(List<Center> listStudents) {
        File file = new File("fileStudent.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(listStudents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Center> readToFileStudent() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("fileStudent.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                List<Center> lecturers;
                try {
                    lecturers = (List<Center>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);

                }
                return lecturers;
            } else {
                return new ArrayList<>();
            }
        }
    }

}