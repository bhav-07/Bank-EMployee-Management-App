package bems.model;

public class BankManager extends  BankEmployee {
    private String department;

    public BankManager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Manager - " + super.toString() + ", Department: " + department;
    }
}
