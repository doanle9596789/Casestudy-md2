package view;
import controller.managerlecturers.ManagerLecturers;
import login.LoginLecturers;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
