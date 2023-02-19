package storage;

import model.Center;

import java.util.List;

public interface IReadWriteFile {

    void writeToFile(List<Center> listlecturers);
    List<Center> readToFile();
    void writeToFileStudent(List<Center> listStudents);
    List<Center> readToFileStudent();
}