package view;
import codegym.Lecturers;
import controller.managerlecturers.ManagerLecturers;
import login.LoginLecturers;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static ManagerLecturers managerLecturers = new ManagerLecturers();
    public static void main(String[] args) {
        managerLecturers.readfileLectures();
        LoginLecturers loginLecturers=new LoginLecturers();
        ManagerLecturers managerLecturers=new ManagerLecturers();
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("xin mời chọn menu");
            System.out.println("""
                1.Đăng nhập giám đốc
                2.Đăng nhập giảng viên
                3.Đăng nhập học viên""");
            int menu=sc.nextInt();
            switch (menu){
                case 1:
                   loginLecturers.checkLogin();
                  break;
            }
        }while (true);

    }
}
