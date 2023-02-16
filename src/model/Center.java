package model;

import java.io.Serializable;

public class Center implements Serializable {
    protected int id;
    private String name;
    private int age;
    private int phonenumber;
    private String email;
    private String address;

    public Center() {
    }

    public Center(int id, String name, int age, int phonenumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int tuoi) {
        this.age = tuoi;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' ;
    }

}
