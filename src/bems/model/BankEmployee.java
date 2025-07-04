package bems.model;

import bems.utility.IDGenerator;

public class BankEmployee {
    protected String id;
    protected String name;
    protected double salary;

    public BankEmployee(String name, double salary) {
        this.id = IDGenerator.generateEmployeeID();
        this.name = name;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}
