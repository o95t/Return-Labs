package miu.edu.pensions;

import java.time.LocalDate;
import java.util.Date;

public class PensionPlan {
    public String planReferenceNumber;
    public Date enrollmentDate;
    public double monthlyContribution;

    public PensionPlan() {
    }

    public PensionPlan(String planReferenceNumber, Date enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    @Override
    public String toString() {
        return "PensionPlan{" +
                "planReferenceNumber='" + planReferenceNumber + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", monthlyContribution=" + monthlyContribution +
                '}';
    }
}
