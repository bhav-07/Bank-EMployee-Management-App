package bems.service;

import bems.exception.DuplicateEmployeeException;
import bems.exception.EmployeeNotFoundException;
import bems.exception.InvalidEmployeeTypeException;
import bems.model.BankEmployee;
import bems.model.BankManager;
import bems.model.BankTeller;
import bems.repository.BankEmployeeRepository;

import java.util.Comparator;
import java.util.List;

public class BankEmployeeService {
    private BankEmployeeRepository repository;

    public BankEmployeeService() {
        this.repository = new BankEmployeeRepository();
    }

    public BankEmployee createEmployee(String type, String name, double salary, String extra)
            throws InvalidEmployeeTypeException, DuplicateEmployeeException {

        BankEmployee employee = switch (type.toLowerCase()) {
            case "manager" -> new BankManager(name, salary, extra);
            case "teller" -> new BankTeller(name, salary, extra);
            default ->
                    throw new InvalidEmployeeTypeException("Invalid employee type: " + type + ". Must be 'manager' or 'teller'");
        };

        repository.save(employee);
        return employee;
    }

    public List<BankEmployee> getAllEmployees() {
        return repository.findAll();
    }

    public BankEmployee getEmployeeById(String id) throws EmployeeNotFoundException {
        BankEmployee employee = repository.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("BankEmployee with ID '" + id + "' not found");
        }
        return employee;
    }

    public BankEmployee getEmployeeByName(String name) throws EmployeeNotFoundException {
        BankEmployee employee = repository.findByName(name);
        if (employee == null) {
            throw new EmployeeNotFoundException("BankEmployee with name '" + name + "' not found");
        }
        return employee;
    }

    public void updateEmployee(String id, String name, double salary) throws EmployeeNotFoundException {
        BankEmployee employee = getEmployeeById(id);
        employee.setName(name);
        employee.setSalary(salary);
        repository.update(employee);
    }

    public void deleteEmployee(String id) throws EmployeeNotFoundException {
        if (!repository.deleteById(id)) {
            throw new EmployeeNotFoundException("BankEmployee with ID '" + id + "' not found");
        }
    }

    public List<BankEmployee> getEmployeesSortedBySalary() {
        List<BankEmployee> employees = getAllEmployees();
        employees.sort(Comparator.comparingDouble(BankEmployee::getSalary));
        return employees;
    }
}
