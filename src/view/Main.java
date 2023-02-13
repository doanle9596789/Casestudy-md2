package view;

import controller.managerlecturers.ManagerLecturers;

public class Main {
    public static void main(String[] args) {
        ManagerLecturers managerLecturers=new ManagerLecturers();
        managerLecturers.createNewLecturers();
        managerLecturers.prin();
    }
}
