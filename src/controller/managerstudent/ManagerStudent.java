package controller.managerstudent;

import controller.managerlecturers.ManagerLecturers;
import model.Center;
import model.LecturersFullTime;
import model.LecturersPartTime;
import model.Student;
import storage.IReadWriteFile;
import storage.ReadWriteFile;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ManagerStudent {
    Scanner scanner = new Scanner(System.in);
    private static ManagerStudent instance1;
    private final List<Center> listStudent;
    private final IReadWriteFile iReadWriteFile = ReadWriteFile.getInstance1();

    private ManagerStudent() {
        this.listStudent = iReadWriteFile.readToFileStudent();
    }

    public static ManagerStudent getInstance1() {
        if (instance1 == null) {
            instance1 = new ManagerStudent();
        }
        return instance1;
    }

    public void sortStudentById() {
        sortStudents();
        iReadWriteFile.writeToFileStudent(listStudent);
    }

    private void sortStudents() {
        listStudent.sort(new Comparator<Center>() {
            @Override
            public int compare(Center o1, Center o2) {
                return (Integer.parseInt(o1.getId())) - (Integer.parseInt(o2.getId()));
            }

        });
    }
    public  void findByName(){

        System.out.println("Enter the name you want to search ");
        String name=scanner.nextLine();
        int check=-1;
        for (int i=0;i<listStudent.size();i++){
            if(listStudent.get(i).getName().equals(name)){
                check=i;
                System.out.println(listStudent.get(check));
            }
        }
        if (check<0){
            System.out.println("Name does not exist");

        }
    }

    public void showStudent() {
        for (Center hs : listStudent) {
            System.out.println(hs);
            System.out.println("_______________");

        }
    }

    public void create() {
        String id = getID();
        String name = getName();
        String address = getAddress();
        String age = getAge();
        String phoneNumber = getPhoneNumber();
        String email = getEmail();
        System.out.println("enter mediumScore");
       double mediumScore=checkDouble(scanner);
        listStudent.add(new Student(id, name, age, phoneNumber, email, address,mediumScore));
        iReadWriteFile.writeToFileStudent(listStudent);
    }
    public void editByName() {

        System.out.println("Enter the student name to edit");
        String namer = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getName().equals(namer)) {
                check = i;

            }

        }
        if (check < 0) {
            System.out.println("name is not in the list");
        } else {
            String id = getID();
            String name = getName();
            String address = getAddress();
            String age = getAge();
            String phone = getPhoneNumber();
            String email = getEmail();
            System.out.println("enter mediumScore");
            double mediumScore = checkDouble(scanner);
            listStudent.get(check).setId(id);
            listStudent.get(check).setName(name);
            listStudent.get(check).setAddress(address);
            listStudent.get(check).setAge(age);
            listStudent.get(check).setPhoneNumber(phone);
            listStudent.get(check).setEmail(email);
            ((Student) listStudent.get(check)).setMediumScore(mediumScore);
            iReadWriteFile.writeToFileStudent(listStudent);
        }
    }
    public void removeId() {
        System.out.println("enter the id to delete :");
        String id=scanner.nextLine();
        int check=-1;
        for (int i=0;i<listStudent.size();i++){
            if(listStudent.get(i).getId().equals(id)){
                check=i;
            }
        }
        if (check<0){
            System.out.println("id does not exist");
        }else {
            listStudent.remove(check);
        }
        iReadWriteFile.writeToFileStudent(listStudent);
    }
    public void  thanorequal75(){
        for (Center hs:listStudent) {
            if (((Student) hs).getMediumScore()>=75){
                System.out.println(hs);
            }
        }
    }
    public void  lessorequal75(){
        for (Center hs:listStudent) {
            if (((Student) hs).getMediumScore()<75){
                System.out.println(hs);
            }
        }
    }
    private String getEmail() {
        while (true) {
            try {
                System.out.println("enter email");
                String email = scanner.nextLine();
                if (controller.managerlecturers.Regex.validateEmail(email)) {
                    boolean check = true;
                    for (Center hs :listStudent) {
                        if (hs.getEmail().equals(email)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return email;
                    } else {
                        System.out.println("Email already exists");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter the wrong format, please re-enter your email");
            }
        }
    }

    public String getPhoneNumber() {
        while (true) {
            try {
                System.out.println("Enter your phone number :");
                String phoneNumber = scanner.nextLine();
                if (controller.managerlecturers.Regex.validatePhone(phoneNumber)) {
                    boolean check = true;
                    for (Center hs : listStudent) {
                        if (hs.getPhonenumber().equals(phoneNumber)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return phoneNumber;
                    } else {
                        System.out.println("phone number already exists:");
                    }
                } else throw new Exception();

            } catch (Exception e) {
                System.out.println("you must enter the correct 10 number format.....");
            }

        }
    }

    public String getAge() {
        while (true) {
            try {
                System.out.println("Enter the Student age:");
                String age = scanner.nextLine();
                if (Integer.parseInt(age) < 15 || Integer.parseInt(age) > 60) {
                    throw new Exception();
                } else return age;
            } catch (Exception e) {
                System.out.println("re-enter employee age from 15 years old to 59 years old");
            }
        }
    }


    public String getAddress() {

        System.out.println("enter address :");
        return scanner.nextLine();
    }

    public String getName() {
        while (true) {
            try {
                System.out.println("enter name:");
                String name = scanner.nextLine();
                if (controller.managerlecturers.Regex.validateName(name)) {
                    return name;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("name must be in correct format:");
            }
        }

    }

    public String getID() {
        while (true) {
            try {
                System.out.println("enter id :");
                String id = scanner.nextLine();
                if (controller.managerlecturers.Regex.validateId(id)) {

                    for (Center hs: listStudent) {
                        if (hs.getId().equals(id)) {
                            throw new Exception();
                        }
                        break;
                    }
                    return id;
                } else System.out.println("id input in the correct format is number (0-9)");
            } catch (Exception e) {
                System.out.println("Enter the same id, re-enter it to see if it still matches!!!!");
            }
        }


    }
    public int checkInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Enter incorrectly, please re-enter");
        }
        return checkInt(scanner);
    }
    public  double checkDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Enter incorrectly, please re-enter");
        }
        return checkDouble(scanner);
    }
}
