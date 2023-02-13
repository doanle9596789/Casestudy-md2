package login;

import controller.managerlecturers.ManagerLecturers;

import java.util.Scanner;

public class LoginLecturers {
    ManagerLecturers managerLecturers=new ManagerLecturers();
    Scanner scanner=new Scanner(System.in);
    private String username="doanle";
    private int password=12345;

    public LoginLecturers() {
    }

    public LoginLecturers(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    public boolean loGinUserName(){
        System.out.println("xin moi dang nhap ten");
        String username1=scanner.nextLine();
        if (username1.equalsIgnoreCase(username)){
            return true;
        }else return false;
    }public boolean loginPassword(){
        System.out.println("nhap mat khau");
        int password1=scanner.nextInt();
        if (password1==password){
            return true;
        }else return false;
    }public void checkLogin(){
        if (loGinUserName()&&loginPassword()){
            managerLecturers.menuManager();
        }else {
            System.out.println("xin moi dang nhap lai");
            checkLogin();
        }
    }
}
