package controller.managerlecturers;

import model.Center;
import model.LecturersFullTime;
import model.LecturersPartTime;
import model.StorageLecturers;
import view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class ManagerLecturers {
Scanner scanner=new Scanner(System.in);
    public ManagerLecturers(List<Center> listlecturers) {
        this.listlecturers = listlecturers;
    }

    public List<Center> listlecturers;

    public ManagerLecturers() {
        try {
            this.listlecturers = new ArrayList<>();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void add(String nameLecturers) {
        Center center=create(nameLecturers);
        listlecturers.add(center);
        try {
            StorageLecturers.writeFileLecturers(listlecturers);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Center create(String nameLecturers) {
        String id =getID();
        String name = getName();
        String address = getAddress();
        String age = getAge();
        String phoneNumber = getPhoneNumber();
        String email = getEmail();
        if (Objects.equals(nameLecturers, "LecturersFullTime")) {
            System.out.println(" Enter the base salary of a full-time lecturer");
            double basicsalary  = Double.parseDouble(scanner.nextLine());
            System.out.println("enter bonus");
            double bonus=Double.parseDouble((scanner.nextLine()));
            System.out.println("enter fines");
            double fines=Double.parseDouble(scanner.nextLine());
            return new LecturersFullTime(id, name, address, age, phoneNumber, email,basicsalary,bonus,fines);

        } else {
            System.out.println("enter hourlySalary");
            double hourlySalary=Double.parseDouble(scanner.nextLine());
            System.out.println("enter workingHours");
            double workingHours=Double.parseDouble(scanner.nextLine());
            return new LecturersPartTime(id,name,age,phoneNumber,email,address,hourlySalary,workingHours);
        }

}

    private String getEmail() {
        while (true) {
            try {
                System.out.println("nhập email");
                String email = scanner.nextLine();
                if (Regex.validateEmail(email)) {
                    boolean check = true;
                    for (Center nv :listlecturers) {
                        if (nv.getEmail().equals(email)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return email;
                    } else {
                        System.out.println("email đã tồn tại");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("nhập sai định dạng vui lòng nhập lại email");
            }
        }
    }

    private String getPhoneNumber() {
        while (true) {
            try {
                System.out.println("nhập số điện thoại :");
                String phonenumber = scanner.nextLine();
                if (Regex.validatePhone(phonenumber)) {
                    boolean check = true;
                    for (Center nv :listlecturers) {
                        if (nv.getPhonenumber().equals(phonenumber)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return phonenumber;
                    } else {
                        System.out.println("số điên thoại đã tồn tại :");
                    }
                } else throw new Exception();

            } catch (Exception e) {
                System.out.println("bạn phải nhập đúng định dạng 10 số.....");
            }

        }
    }
    private String getAge() {
        while (true) {
            try {
                System.out.println("nhập tuổi nhân viên:");
                String age = scanner.nextLine();
                if (Integer.parseInt(age) < 15 || Integer.parseInt(age) > 60) {
                    throw new Exception();
                } else return age;
            } catch (Exception e) {
                System.out.println("nhập lại tuổi nhân viên từ 15 tuổi đến 59 tuổi");
            }
        }
    }


    private String getAddress() {

        System.out.println("nhập địa chỉ :");
        return scanner.nextLine();
    }

    private String getName() {
        while (true) {
            try {
                System.out.println("nhập name:");
                String name = scanner.nextLine();
                if (Regex.validateName(name)) {
                    return name;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("name phải đúng định dạng :");
            }
        }

    }

    private String getID() {
        while (true) {
            try {
                System.out.println("enter id :");
                String id = scanner.nextLine();
                if (Regex.validateId(id)) {

                    for (Center gv :listlecturers) {
                        if (gv.getId().equals(id)) {
                            throw new Exception();
                        }
                        break;
                    }
                    return id;
                }else System.out.println("id nhập đúng định dạng là số (0-9)");
            } catch (Exception e) {
                System.out.println("NHhập id trùng,bạn nhập lại xem còn trùng không!!!!");
            }
        }


    }
}


//    public void createNewLecturersFullTime(Scanner scanner) {
//        System.out.println("xin mời nhập id");
//        int id = scanner.nextInt();
//        System.out.println("xin mời nhập tên");
//        scanner.nextLine();
//        String name = scanner.nextLine();
//        System.out.println("xin mời nhập tuổi");
//        int age = scanner.nextInt();
//        System.out.println("xin mời nhập số địen thoai");
//        int phonenumber = scanner.nextInt();
//        System.out.println("xin mời nhập email");
//        scanner.nextLine();
//        String email = scanner.nextLine();
//        System.out.println("xin mời nhập địa chỉ");
//        String address = scanner.nextLine();
//        System.out.println("xin mời nhập lương cơ bản");
//        double basicsalary = scanner.nextDouble();
//        System.out.println("xin mời nhập tiền thưởng");
//        double bonus = scanner.nextDouble();
//        System.out.println("xin mời nhập tiền phạt");
//        double fines = scanner.nextDouble();
//        LecturersFullTime lecturers1 = new LecturersFullTime(id, name, age, phonenumber, email, address, basicsalary, bonus, fines);
//        listlecturers.add(lecturers1);
//        try {
//            StorageLecturers.writeFileLecturers(listlecturers);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void createNewLecturersPartTime(Scanner scanner) {
//        System.out.println("xin mời nhập id");
//        int id1 = scanner.nextInt();
//        System.out.println("xin mời nhập tên");
//        scanner.nextLine();
//        String name1 = scanner.nextLine();
//        System.out.println("xin mời nhập tuổi");
//        int age1 = scanner.nextInt();
//        System.out.println("xin mời nhập số địen thoai");
//        int phonenumber1 = scanner.nextInt();
//        System.out.println("xin mời nhập email");
//        scanner.nextLine();
//        String email1 = scanner.nextLine();
//        System.out.println("xin mời nhập địa chỉ");
//        String address1 = scanner.nextLine();
//        System.out.println("xin mời nhập lương theo giờ");
//        double hourlySalary = scanner.nextDouble();
//        System.out.println("nhập số giờ làm việc theo tháng");
//        double workingHours=scanner.nextDouble();
//        LecturersPartTime lecturersPartTime=new LecturersPartTime(id1,name1,age1,phonenumber1,email1,address1,hourlySalary,workingHours);
//        listlecturers.add(lecturersPartTime);
//        try {
//            StorageLecturers.writeFileLecturers(listlecturers);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void editById(int id){
//        for (Center c:listlecturers) {
//            if (c.getId()==id){
//
//
//            }
//        }
//
//        try {
//            StorageLecturers.writeFileLecturers(listlecturers);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void removeLecturers(int id) {
//        int check=-1;
//        for (int i=0;i<listlecturers.size();i++){
//            if(listlecturers.get(i).getId()==id){
//                check=i;
//            }
//        }
//        if (check<0){
//            System.out.println("id không tồn tại");
//        }else {
//            listlecturers.remove(check);
//        }
//            try {
//                StorageLecturers.writeFileLecturers(listlecturers);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//    public void searchLecturers(String name1){
//        int check=-1;
//        for (int i=0;i<listlecturers.size();i++){
//            if(listlecturers.get(i).getName().equals(name1)){
//                check=i;
//
//            }
//        }
//        if (check<0){
//            System.out.println("Tên không tồn tại");
//
//        }else {
//            System.out.println("thông tin giảng viên bạn muốn tìm là");
//            System.out.println(listlecturers.get(check));
//        }
//    }
//
//}
