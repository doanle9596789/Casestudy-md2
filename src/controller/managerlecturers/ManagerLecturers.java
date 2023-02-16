package controller.managerlecturers;

import model.Center;
import model.LecturersFullTime;
import model.LecturersPartTime;
import model.StorageLecturers;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerLecturers {
    public ManagerLecturers(List<Center> listlecturers) {
        this.listlecturers = listlecturers;
    }

    public List<Center> listlecturers;

    public ManagerLecturers() {

        try {
            this.listlecturers =StorageLecturers.readFilelecturers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    File file = new File("lecterers.dat");



    public void createNewLecturersFullTime(Scanner scanner) {
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
        LecturersFullTime lecturers1 = new LecturersFullTime(id, name, age, phonenumber, email, address, basicsalary, bonus, fines);
        listlecturers.add(lecturers1);
        try {
            StorageLecturers.writeFileLecturers(listlecturers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createNewLecturersPartTime(Scanner scanner) {
        System.out.println("xin mời nhập id");
        int id1 = scanner.nextInt();
        System.out.println("xin mời nhập tên");
        scanner.nextLine();
        String name1 = scanner.nextLine();
        System.out.println("xin mời nhập tuổi");
        int age1 = scanner.nextInt();
        System.out.println("xin mời nhập số địen thoai");
        int phonenumber1 = scanner.nextInt();
        System.out.println("xin mời nhập email");
        scanner.nextLine();
        String email1 = scanner.nextLine();
        System.out.println("xin mời nhập địa chỉ");
        String address1 = scanner.nextLine();
        System.out.println("xin mời nhập lương theo giờ");
        double hourlySalary = scanner.nextDouble();
        System.out.println("nhập số giờ làm việc theo tháng");
        double workingHours=scanner.nextDouble();
        LecturersPartTime lecturersPartTime=new LecturersPartTime(id1,name1,age1,phonenumber1,email1,address1,hourlySalary,workingHours);
        listlecturers.add(lecturersPartTime);
        try {
            StorageLecturers.writeFileLecturers(listlecturers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editById(int id){
        for (Center c:listlecturers) {
            if (c.getId()==id){


            }
        }

        try {
            StorageLecturers.writeFileLecturers(listlecturers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void removeLecturers(int id) {
        int check=-1;
        for (int i=0;i<listlecturers.size();i++){
            if(listlecturers.get(i).getId()==id){
                check=i;
            }
        }
        if (check<0){
            System.out.println("id không tồn tại");
        }else {
            listlecturers.remove(check);
        }
            try {
                StorageLecturers.writeFileLecturers(listlecturers);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    public void searchLecturers(String name1){
        int check=-1;
        for (int i=0;i<listlecturers.size();i++){
            if(listlecturers.get(i).getName().equals(name1)){
                check=i;

            }
        }
        if (check<0){
            System.out.println("Tên không tồn tại");

        }else {
            System.out.println("thông tin giảng viên bạn muốn tìm là");
            System.out.println(listlecturers.get(check));
        }
    }
//    public double totalSalary(){
//        double total=0.0;
//        for (Center k1:listlecturers) {
//           total=( k1.getBasicsalary()+k1.getBonus()-k1.getFines());
//        }return total;
//    }
}
