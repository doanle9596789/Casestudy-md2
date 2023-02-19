package login;

import controller.managerlecturers.ManagerLecturers;
import view.Menu;

import java.util.Scanner;

public class LoginStudent {
    Menu menu=new Menu();
    Scanner scanner=new Scanner(System.in);
    private String username="minhdoan";
    private int password=54321;

    public LoginStudent() {
    }

    public LoginStudent(String username, int password) {
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
    }public void checkLoginStudent(){
        if (loGinUserName()&&loginPassword()){
            menu.menuManagerStudent();
        }else {
            System.out.println("Please login again");
            checkLoginStudent();
        }
    }
}
