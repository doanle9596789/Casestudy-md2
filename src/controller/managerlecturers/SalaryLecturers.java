package controller.managerlecturers;

import model.Center;
import model.onemonthsalary;

import java.util.List;

public class SalaryLecturers implements onemonthsalary {
    ManagerLecturers managerLecturers=ManagerLecturers.getInstance();
    @Override
    public double oneMonthSalaryFullTime() {
    return managerLecturers.totalSalaryFullTime();
    }

    @Override
    public double oneMoonthSalaryPartTime(){
      return   managerLecturers.totalSalaryPartTime();
    }
}
