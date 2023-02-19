package view;

import controller.managerlecturers.ManagerLecturers;
import controller.managerlecturers.SalaryLecturers;
import controller.managerstudent.ManagerStudent;
import login.LoginLecturers;
import login.LoginStudent;

import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    public static ManagerLecturers managerLecturers= ManagerLecturers.getInstance();
    public static ManagerStudent managerStudent=ManagerStudent.getInstance1();
    SalaryLecturers salaryLecturers=new SalaryLecturers();
    public void menuManagerLecturers() {
        do {
            System.out.println("select menu");
            System.out.println("------------------");
            System.out.println("""
                    1.Add Lecturers
                    2.Edit Lecturers
                    3.Delete Lecturers
                    4.Find lecturers by name
                    5.Show list of lecturers by name
                    6.Total salary to be paid in a month for Full Time lecturers
                    7.Total salary to be paid to Part Time lecturers
                    8.Sort Lecturers By Id
                    9.Back to Menu CodeGym""");

            int input = managerLecturers.checkInt(scanner);
            switch (input) {
                case 1:
                    System.out.println("enter the lecturer need more");
                    String nameLecturers=scanner.nextLine();
                    managerLecturers.create(nameLecturers);
                    break;
                case 2:managerLecturers.editByName();
                break;

                case 3:managerLecturers.removeId();
                    break;
                case 4:
                    managerLecturers.findByName();
                    break;
                case 5:
                    managerLecturers.showLecturers();
                    break;
                case 6:
                    System.out.println("the amount payable to the full-time faculty is:"+"\n"+salaryLecturers.oneMonthSalaryFullTime());
                break;
                case 7:
                    System.out.println("the amount payable to the part-time faculty is:"+"\n"+salaryLecturers.oneMoonthSalaryPartTime());
                    break;
                case 8: managerLecturers.sortLecturersById();
                break;
                case 9:
                    menuCodeGym();
                    break;
                default:
                    System.out.println(" please re-enter");
            }
        } while (true);
    }
    public void menuManagerStudent(){
      do {
          System.out.println("select menu");

        System.out.println("------------------");
        System.out.println("""
                1.Add Student
                2.Edit Student
                3.Delete Student
                4.Find Student by name
                5.Show list of Student by name
                6.list of students passing the module
                7.list of students who did not pass the module     
                8.Sort Student By Id
                9.Back to Menu CodeGym""");
        int input = managerStudent.checkInt(scanner);
        switch (input){
            case 1:
                managerStudent.create();
                break;
            case 2:managerStudent.editByName();break;
            case 3:managerStudent.removeId();break;
            case 4:managerStudent.findByName();break;
            case 5:managerStudent.showStudent();break;
            case 6:managerStudent.thanorequal75();break;
            case 7:managerStudent.lessorequal75();break;
            case 8:managerStudent.sortStudentById();break;
            case 9:menuCodeGym();

        } }while (true);
    }

    public void menuCodeGym() {
        LoginStudent loginStudent=new LoginStudent();
        LoginLecturers loginLecturers=new LoginLecturers();
        do {
            System.out.println("seclect menu");
            System.out.println("-------------------");
            System.out.println("""
                    1.Login Manager
                    2.Login Lecturers
                    3.Enter exit program""");
            int input =managerLecturers.checkInt(scanner);
            switch (input) {
                case 1:
                    loginLecturers.checkLoginLecturers();
                    break;
                case 2:
                    loginStudent.checkLoginStudent();
                    break;
                case 3:System.exit(input);
            }
        } while (true);
    }


}
