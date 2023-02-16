package view;

import controller.managerlecturers.ManagerLecturers;
import login.LoginLecturers;

import java.util.Scanner;

public class Menu {
    Scanner scanner=new Scanner(System.in);
    ManagerLecturers managerLecturers=new ManagerLecturers();
    public void menuManagerLecturers() {
        do {
            System.out.println("xin mời chọn menu");
            System.out.println("------------------");
            System.out.println("""
                    1.Thêm giảng viên
                    2.Sửa giảng viên
                    3.Xóa Giảng Viên
                    4.Tìm giảng viên theo tên
                    5.Hiên thị danh sách giảng viên theo tên
                    6.Tổng lương phải trả trong một tháng cho giảng viên""");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    managerLecturers.createNewLecturers(scanner);
                    break;
                case 2:
                    System.out.println("xin mời nhập id cần sửa");
                    int id=scanner.nextInt();
                    managerLecturers.editById(id,scanner);
                    break;
                case 3:
                    System.out.println("xin mời nhập id muốn xóa");
                    int id1=scanner.nextInt();
                    managerLecturers.removeLecturers(id1);

                    break;
                case 4:
                    System.out.println("nhập tên bạn muốn tìm");
                    scanner.nextLine();
                    String name1=scanner.nextLine();
                    managerLecturers.searchLecturers(name1);
                case 5:
                    System.out.println(managerLecturers.listlecturers);
                    break;
                case 6:
            }
        } while (true);
    }
    public void menuLecturers(){
        LoginLecturers loginLecturers=new LoginLecturers();
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("xin mời chọn menu");
            System.out.println("""
                1.Đăng nhập giám đốc
                2.Đăng nhập giảng viên
                3.Đăng nhập học viên""");
            int menu=scanner.nextInt();
            switch (menu){
                case 1:
                    loginLecturers.checkLogin();
                    break;
            }
        }while (true);
    }
}
