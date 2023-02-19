package login;

import controller.managerlecturers.ManagerLecturers;
import view.Menu;

import java.util.Scanner;

public class LoginLecturers {
    Menu menu=new Menu();
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
        System.out.println("Please enter your current name");
        String username1=scanner.nextLine();
        if (username1.equalsIgnoreCase(username)){
            return true;
        }else return false;
    }public boolean loginPassword(){
        System.out.println("enter password");
        int password1=scanner.nextInt();
        scanner.nextLine();
        if (password1==password){
            return true;
        }else return false;
    }public void checkLoginLecturers(){
        if (loGinUserName()&&loginPassword()){
            menu.menuManagerLecturers();
        }else {
            System.out.println("Please login again");
            checkLoginLecturers();
        }
    }
}
