package view;

import controller.managerlecturers.ManagerLecturers;
import controller.managerlecturers.Regex;
import login.LoginLecturers;
import model.Center;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    ManagerLecturers managerLecturers = new ManagerLecturers();

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
                    6.Tổng lương phải trả trong một tháng cho giảng viên
                    7.Thoat ra ngoài menu chính""");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("enter the lecturer need more");
                    scanner.nextLine();
                    String nameLecturers=scanner.nextLine();
                    managerLecturers.add(nameLecturers);
                    break;
                case 2:

                case 3:


                    break;
                case 4:

                case 5:

                case 6:
                case 7:
            }
        } while (true);
    }

    public void menuCodeGym() {
        LoginLecturers loginLecturers = new LoginLecturers();
        do {
            System.out.println("xin mời chọn menu");
            System.out.println("""
                    1.Đăng nhập giám đốc
                    2.Đăng nhập giảng viên""");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    loginLecturers.checkLogin();
                    break;
            }
        } while (true);
    }

}
