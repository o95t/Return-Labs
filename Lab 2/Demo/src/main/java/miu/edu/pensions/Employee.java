package miu.edu.pensions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Employee {

    static List<Employee> getData(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {
            return Arrays.asList(
                    new Employee(1, "Daniel", "Agar", format.parse("2018-01-17"), 105945.50, new PensionPlan("EX1089", format.parse("2023-01-17"), 100.00)),
                    new Employee(2, "Benard", "Shaw", format.parse("2019-04-03"), 197750.00 , new PensionPlan()),
                    new Employee(3, "Carly", "Agar", format.parse("2014-05-16"), 842000.75, new PensionPlan("SM2307", format.parse("2019-11-04"), 1555.50)),
                    new Employee(4, "Wesley", "Schneider", format.parse("2019-05-02"), 74500.00, new PensionPlan()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public long employeeId;
    public String firstName;
    public String lastName;
    public Date employmentDate;
    public double yearlySalary;
    public PensionPlan pensionPlan;

    public Employee() {
    }

    public Employee(long employeeId, String firstName, String lastName, Date  employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    public Employee(long employeeId, String firstName, String lastName, Date  employmentDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date  getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date  employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }
}
