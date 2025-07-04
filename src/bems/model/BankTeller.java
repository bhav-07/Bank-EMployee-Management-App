package bems.model;

public class BankTeller extends  BankEmployee {
    private String branch;

    public BankTeller(String name, double salary, String branch) {
        super(name, salary);
        this.branch = branch;
    }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    @Override
    public String toString() {
        return "Teller - " + super.toString() + ", Branch: " + branch;
    }
}
