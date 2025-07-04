package bems.repository;

import bems.exception.DuplicateEmployeeException;
import bems.model.BankEmployee;
import bems.model.BankManager;
import bems.model.BankTeller;

import java.util.*;

public class BankEmployeeRepository {
    private Map<String, BankEmployee> employees;

    public BankEmployeeRepository() {
        this.employees = new HashMap<>();
        seedData();
    }

    private void seedData() {
        try {
            BankEmployee manager1 = new BankManager("John Smith", 75000, "Loan Department");
            BankEmployee manager2 = new BankManager("Sarah Johnson", 82000, "Investment Department");
            BankEmployee teller1 = new BankTeller("Mike Davis", 45000, "Downtown Branch");
            BankEmployee teller2 = new BankTeller("Lisa Wilson", 48000, "Mall Branch");
            BankEmployee teller3 = new BankTeller("David Brown", 46000, "Airport Branch");

            employees.put(manager1.getId(), manager1);
            employees.put(manager2.getId(), manager2);
            employees.put(teller1.getId(), teller1);
            employees.put(teller2.getId(), teller2);
            employees.put(teller3.getId(), teller3);

            System.out.println("Sample data loaded successfully!");
            System.out.println("Created " + employees.size() + " sample employees.");
        } catch (Exception e) {
            System.out.println("Error seeding data: " + e.getMessage());
        }
    }

    public void save(BankEmployee employee) throws DuplicateEmployeeException {
        if (findByName(employee.getName()) != null) {
            throw new DuplicateEmployeeException("Employee with name '" + employee.getName() + "' already exists");
        }
        employees.put(employee.getId(), employee);
    }

    public BankEmployee findById(String id) {
        return employees.get(id);
    }

    public BankEmployee findByName(String name) {
        return employees.values().stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<BankEmployee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public boolean deleteById(String id) {
        return employees.remove(id) != null;
    }

    public void update(BankEmployee employee) {
        employees.put(employee.getId(), employee);
    }
}