package codegym;

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

    public void createnew() {
        System.out.println("xin mời nhập id");
        int id = scanner.nextInt();
        System.out.println("xin mời nhập tên");
        String name = scanner.nextLine();
        System.out.println("xin mời nhập tuổi");
        int age = scanner.nextInt();
        System.out.println("xin mời nhập số địen thoai");
        int phonenumber = scanner.nextInt();
        System.out.println("xin mời nhập email");
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

    }
}
