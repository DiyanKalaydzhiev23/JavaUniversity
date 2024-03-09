import java.time.LocalDate;
import java.time.Period;

public class Manager {
    private final String employeeName;
    private LocalDate hiringDate;

    Manager(String employeeName) {
        this.employeeName = employeeName;
        this.hiringDate = LocalDate.now();
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public LocalDate getHiringDate() {
        return this.hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public long getEmployeeYearsInCompany(LocalDate today) {
        Period period = Period.between(this.hiringDate, today);

        return period.getYears();
    }
}
