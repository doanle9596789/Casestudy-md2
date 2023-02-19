package controller.managerlecturers;

import model.Center;
import model.LecturersFullTime;
import model.LecturersPartTime;
import storage.IReadWriteFile;
import storage.ReadWriteFile;

import java.util.*;

public class ManagerLecturers {
    Scanner scanner = new Scanner(System.in);
    private static ManagerLecturers instance;
    private final List<Center> listlecturers;
    private final IReadWriteFile iReadWriteFile = ReadWriteFile.getInstance();

    private ManagerLecturers() {
        this.listlecturers = iReadWriteFile.readToFile();
    }

    public static ManagerLecturers getInstance() {
        if (instance == null) {
            instance = new ManagerLecturers();
        }
        return instance;
    }

    public void sortLecturersById(){
        sortLecturers();
        iReadWriteFile.writeToFile(listlecturers);
    }

    public void create(String nameLecturers) {
        if (Objects.equals(nameLecturers, "LecturersFullTime")) {
            String id = getID();
            String name =getName();
            String address =getAddress();
            String age =getAge();
            String phoneNumber =getPhoneNumber();
            String email =getEmail();
            System.out.println(" Enter the basic salary of a full-time lecturer");
            double basicSalary = Double.parseDouble(scanner.nextLine());
            System.out.println("enter bonus");
            double bonus = Double.parseDouble((scanner.nextLine()));
            System.out.println("enter fines");
            double fines = Double.parseDouble(scanner.nextLine());
            listlecturers.add( new LecturersFullTime(id, name, age, phoneNumber, email, address, basicSalary, bonus, fines));
        } else if (Objects.equals(nameLecturers, "LecturersPartTime")){
            String id = getID();
            String name =getName();
            String address =getAddress();
            String age =getAge();
            String phoneNumber =getPhoneNumber();
            String email =getEmail();
            System.out.println("enter hourlySalary");
            double hourlySalary = Double.parseDouble(scanner.nextLine());
            System.out.println("enter workingHours");
            double workingHours = Double.parseDouble(scanner.nextLine());
            listlecturers.add(new LecturersPartTime(id, name, age, phoneNumber, email, address, hourlySalary, workingHours));
        }else {
            System.out.println("Please re-enter");
        }
        iReadWriteFile.writeToFile(listlecturers);
    }
    public double totalSalaryFullTime(){
             double total=0;
        for (Center gv:listlecturers) {
            if (gv instanceof LecturersFullTime){
                total+=(((LecturersFullTime) gv).getBasicsalary()+ ((LecturersFullTime) gv).getBonus()- ((LecturersFullTime) gv).getFines());
            }
        }return total;
    }
    public double totalSalaryPartTime(){
        double total=0;
        for (Center gv:listlecturers) {
            if (gv instanceof LecturersPartTime){
                total+=(((LecturersPartTime) gv).getHourlySalary()* ((LecturersPartTime) gv).getWorkingHours());
            }
        }return total;

    }
    public void sortLecturers() {
        listlecturers.sort(new Comparator<Center>() {
            @Override
            public int compare(Center o1, Center o2) {
                return (Integer.parseInt(o1.getId()))-(Integer.parseInt(o2.getId()));
            }

        });
    }


    public void showLecturers() {
        for (Center gv : listlecturers) {
            System.out.println(gv);
            System.out.println("_______________");

        }
    }

    public void editById() {

        System.out.println("Enter the teacher's id to edit");
        String id = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < listlecturers.size(); i++) {
            if (listlecturers.get(i).getId().equals(id)) {
                check = i;

            }

        }
        if (check < 0) {
            System.out.println("id is not in the list");
        } else {
            String id1 = getID();
            String name = getName();
            String address = getAddress();
            String age = getAge();
            String phone =getPhoneNumber();
            String email = getEmail();
            listlecturers.get(check).setId(id1);
            listlecturers.get(check).setName(name);
            listlecturers.get(check).setAddress(address);
            listlecturers.get(check).setAge(age);
            listlecturers.get(check).setPhoneNumber(phone);
            listlecturers.get(check).setEmail(email);
            if (listlecturers.get(check) instanceof LecturersFullTime) {
                System.out.println("  Enter the base salary of a full-time lecturer");
                double basicSalary = checkDouble(scanner);
                ((LecturersFullTime) listlecturers.get(check)).setBasicsalary(basicSalary);
                System.out.println("enter bonus");
                double bonus =checkDouble(scanner);
                ((LecturersFullTime) listlecturers.get(check)).setBonus(bonus);
                System.out.println("enter fines");
                double fines = checkDouble(scanner);
                ((LecturersFullTime) listlecturers.get(check)).setFines(fines);
            } else if (listlecturers.get(check) instanceof LecturersPartTime) {
                System.out.println("enter hourlySalary");
                double hourlySalary = checkDouble(scanner);
                ((LecturersPartTime) listlecturers.get(check)).setHourlySalary(hourlySalary);
                System.out.println("enter workingHours");
                double workingHours =checkDouble(scanner);
                ((LecturersPartTime) listlecturers.get(check)).setHourlySalary(workingHours);

            }

        }iReadWriteFile.writeToFile(listlecturers);
    }
    public void removeId() {
        System.out.println("enter the id to delete :");
        String id=scanner.nextLine();
        int check=-1;
        for (int i=0;i<listlecturers.size();i++){
            if(listlecturers.get(i).getId().equals(id)){
                check=i;
            }
        }
        if (check<0){
            System.out.println("id does not exist");
        }else {
            listlecturers.remove(check);
        }
        iReadWriteFile.writeToFile(listlecturers);
    }
    public  void findByName(){

        System.out.println("Enter the name you want to search ");
        String name=scanner.nextLine();
        int check=-1;
        for (int i=0;i<listlecturers.size();i++){
            if(listlecturers.get(i).getName().equals(name)){
                check=i;
                System.out.println(listlecturers.get(check));
            }
        }
        if (check<0){
            System.out.println("Name does not exist");

        }
    }
    private String getEmail() {
        while (true) {
            try {
                System.out.println("enter email");
                String email = scanner.nextLine();
                if (controller.managerlecturers.Regex.validateEmail(email)) {
                    boolean check = true;
                    for (Center nv :listlecturers) {
                        if (nv.getEmail().equals(email)) {
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
                    for (Center nv : listlecturers) {
                        if (nv.getPhonenumber().equals(phoneNumber)) {
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
                System.out.println("Enter the Lecturers age:");
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

                    for (Center gv : listlecturers) {
                        if (gv.getId().equals(id)) {
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
