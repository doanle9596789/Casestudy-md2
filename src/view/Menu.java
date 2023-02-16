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
                    6.Tổng lương phải trả trong một tháng cho giảng viên
                    7.Thoat ra ngoài menu chính""");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                   menuCreateLecturers();
                    break;
                case 2:
                    System.out.println("xin mời nhập id cần sửa");
                    int id2=scanner.nextInt();
                    managerLecturers.editById(id2);
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
                    System.out.println("Số tiền lương phải trả cho giảng viên là");
//                    System.out.println(managerLecturers.totalSalary());
                case 7:menuCodeGym();
            }
        } while (true);
    }
    public void menuCodeGym(){
        LoginLecturers loginLecturers=new LoginLecturers();
        do {
            System.out.println("xin mời chọn menu");
            System.out.println("""
                1.Đăng nhập giám đốc
                2.Đăng nhập giảng viên""");
            int menu=scanner.nextInt();
            switch (menu){
                case 1:
                    loginLecturers.checkLogin();
                    break;
            }
        }while (true);
    }
    public void menuCreateLecturers(){
        do {
        System.out.println("bạn muốn thêm nhân viên nào");
            System.out.println("""
                    1.Thêm nhân viên fullTime
                    2.Thêm nhân viên PartTime
                    3.Quay lai""");
            int menu=scanner.nextInt();
        switch (menu){
            case 1:managerLecturers.createNewLecturersFullTime(scanner);
            break;
            case 2:managerLecturers.createNewLecturersPartTime(scanner);
            break;
            case 3:menuManagerLecturers();
        }
    }while (true);
    }

}
