package controller.managerlecturers;
import codegym.Lecturers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerLecturers {
    List<Lecturers> listlecturers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public ManagerLecturers() {
    }

    public ManagerLecturers(List<Lecturers> listlecturers) {
        this.listlecturers = listlecturers;
    }

    public List<Lecturers> getListlecturers() {
        return listlecturers;
    }

    public void setListlecturers(List<Lecturers> listlecturers) {
        this.listlecturers = listlecturers;
    }

    public void createNewLecturers() {
        System.out.println("xin mời nhập id");
        int id = scanner.nextInt();
        System.out.println("xin mời nhập tên");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("xin mời nhập tuổi");
        int age = scanner.nextInt();
        System.out.println("xin mời nhập số địen thoai");
        int phonenumber = scanner.nextInt();
        System.out.println("xin mời nhập email");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.println("xin mời nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("xin mời nhập lương cơ bản");
        double basicsalary = scanner.nextDouble();
        System.out.println("xin mời nhập tiền thưởng");
        double bonus = scanner.nextDouble();
        System.out.println("xin mời nhập tiền phạt");
        double fines = scanner.nextDouble();
        Lecturers lecturers1 = new Lecturers(id, name, age, phonenumber, email, address, basicsalary, bonus, fines);
        listlecturers.add(lecturers1);
    }
    public void prin(){
        for (Lecturers k:listlecturers
             ) {
            System.out.println(k.toString());

        }
    }
}
