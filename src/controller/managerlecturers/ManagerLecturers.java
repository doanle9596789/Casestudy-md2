package controller.managerlecturers;

import model.Lecturers;
import model.StorageLecturers;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerLecturers {
    public ManagerLecturers(List<Lecturers> listlecturers) {
        this.listlecturers = listlecturers;
    }

    public List<Lecturers> listlecturers;

    public ManagerLecturers() {

        try {
            this.listlecturers = StorageLecturers.readFilelecturers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    File file = new File("lecterers.dat");



    public void createNewLecturers(Scanner scanner) {
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
        try {
            StorageLecturers.writeFileLecturers(listlecturers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editById(int id,Scanner scanner){
        removeLecturers(id);
        createNewLecturers(scanner);
        try {
            StorageLecturers.writeFileLecturers(listlecturers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void removeLecturers(int id) {
        int check=-1;
        for (Lecturers k:listlecturers){
            if (k.getId()==id){
              check=id;
            }
        }if (check<0){
            System.out.println("không có id bạn nhập");
        }else {
            listlecturers.remove(listlecturers.get(id));
            try {
                StorageLecturers.writeFileLecturers(listlecturers);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }public void searchLecturers(String name1){
        int check=-1;
        for (int i=0;i<listlecturers.size();i++){
            if(listlecturers.get(i).getName().equals(name1)){
                check=i;

            }
        }
        if (check<0){
            System.out.println("Tên không tồn tại");

        }else System.out.println(listlecturers.get(check));
    }
    public double totalSalary(){
        double total=0.0;
        for (Lecturers k1:listlecturers) {
           total=( k1.getBasicsalary()+k1.getBonus()-k1.getFines());
        }return total;
    }
}
