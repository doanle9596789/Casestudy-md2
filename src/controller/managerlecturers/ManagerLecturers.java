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
    public void menuManager(){
        System.out.println("xin mời chọn menu");
        System.out.println("------------------");
        System.out.println("""
                1.Thêm giảng viên
                2.Sửa giảng viên
                3.Xóa Giảng Viên
                4.Tìm giảng viên theo tên
                5.Hiên thị danh sách giảng viên theo tên
                6.Tổng lương phải trả trong một tháng cho giảng viên""");
        int menu=scanner.nextInt();
        do {
            switch (menu){
                case 1:
                    createNewLecturers();
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
            }
        }while (true);
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

}
