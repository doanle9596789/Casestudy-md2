package model;

public class Student extends Center {
   private double averageofsubject;

   public Student(double averageofsubject) {
      this.averageofsubject = averageofsubject;
   }

   public Student(int id, String name, int tuoi, int phonenumber, String email, String address, double averageofsubject) {
      super(id, name, tuoi, phonenumber, email, address);
      this.averageofsubject = averageofsubject;
   }

   public double getAverageofsubject() {
      return averageofsubject;
   }

   public void setAverageofsubject(double averageofsubject) {
      this.averageofsubject = averageofsubject;
   }
}
