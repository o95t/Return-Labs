package miu.edu.pensions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getData();

        printEmployeesJson(employees);

        printMonthlyUpcomingEnrolleesJson(employees);
    }

    private static void printEmployeesJson(List<Employee> employees) {
//        for(Employee employe : employees){
//            employe.setPensionPlan(null);
//            employe.setEmploymentDate(null);
//        }
        String json = new Gson().toJson(employees);
        System.out.println("List of Employees (sorted by last name and yearly salary):\n" + json);
    }

    private static void printMonthlyUpcomingEnrolleesJson(List<Employee> employees)  {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfNextMonth = today.plusMonths(1).withDayOfMonth(today.plusMonths(1).lengthOfMonth());

        List<Employee> upcomingEnrollees = new ArrayList<>();

        for (Employee employee : employees) {
            LocalDate employmentDate = LocalDate.ofInstant(employee.getEmploymentDate().toInstant(), ZoneId.systemDefault());
            if (employmentDate.plusYears(5).isBefore(lastDayOfNextMonth.plusDays(1))) {
                if (employee.getPensionPlan() == null) {
                    upcomingEnrollees.add(employee);
                }
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(upcomingEnrollees);
        System.out.println("Monthly Upcoming Enrollees report (sorted by employment date):\n" + json);
    }
}
