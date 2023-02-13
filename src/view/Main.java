package view;

import controller.managerlecturers.ManagerLecturers;
import login.LoginLecturers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    LoginLecturers loginLecturers=new LoginLecturers();
                  loginLecturers.checkLogin();
            }
        }while (true);

    }
}
