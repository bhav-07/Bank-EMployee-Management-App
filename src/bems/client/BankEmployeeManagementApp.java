package bems.client;

import bems.exception.DuplicateEmployeeException;
import bems.exception.EmployeeNotFoundException;
import bems.exception.InvalidEmployeeTypeException;
import bems.model.BankEmployee;
import bems.service.BankEmployeeService;

import java.util.*;

class BankEmployeeManagementApp {
    private BankEmployeeService employeeService;
    private Scanner scanner;

//    Commit from dev-branch
    //Another commit from dev-branch
    //lorem ipsum dolor sit amet, consectetur adipiscing elit
    //sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
    public BankEmployeeManagementApp() {
        this.employeeService = new BankEmployeeService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("CHANGES MADE BY ASHWIN");
        System.out.println("=== Bank Employee Management System ===");

        while (true) {
            showMenu();
            int choice = getChoice();

            try {
                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: viewAllEmployees(); break;
                    case 3: searchEmployeeById(); break;
                    case 4: updateEmployee(); break;
                    case 5: deleteEmployee(); break;
                    case 6: viewEmployeesSortedBySalary(); break;
                    case 7:
                        System.out.println("Thank you for using the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Bank Employee");
        System.out.println("2. View All Bank Employees");
        System.out.println("3. Search Bank Employee by ID");
        System.out.println("4. Update Bank Employee");
        System.out.println("5. Delete Bank Employee");
        System.out.println("6. List Bank Employees Sorted by Salary");
        System.out.println("7. Exit App");
        System.out.print("Enter choice: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void addEmployee() throws InvalidEmployeeTypeException, DuplicateEmployeeException {
        System.out.print("Enter employee type (manager/teller): ");
        String type = scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        String extra;
        if (type.equalsIgnoreCase("manager")) {
            System.out.print("Enter department: ");
            extra = scanner.nextLine();
        } else {
            System.out.print("Enter branch: ");
            extra = scanner.nextLine();
        }

        BankEmployee employee = employeeService.createEmployee(type, name, salary, extra);
        System.out.println("Employee added successfully!");
        System.out.println("Generated ID: " + employee.getId());
    }

    private void viewAllEmployees() {
        List<BankEmployee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n--- All Employees ---");
        for (BankEmployee emp : employees) {
            System.out.println(emp);
        }
    }

    private void searchEmployeeById() throws EmployeeNotFoundException {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();

        BankEmployee employee = employeeService.getEmployeeById(id);
        System.out.println("Employee found:");
        System.out.println(employee);
    }

    private void updateEmployee() throws EmployeeNotFoundException {
        System.out.print("Enter employee ID to update: ");
        String id = scanner.nextLine();

        BankEmployee currentEmployee = employeeService.getEmployeeById(id);
        System.out.println("Current details: " + currentEmployee);

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new salary: ");
        double newSalary = Double.parseDouble(scanner.nextLine());

        employeeService.updateEmployee(id, newName, newSalary);
        System.out.println("Employee updated successfully!");
    }

    private void deleteEmployee() throws EmployeeNotFoundException {
        System.out.print("Enter employee ID to delete: ");
        String id = scanner.nextLine();

        employeeService.deleteEmployee(id);
        System.out.println("Employee deleted successfully!");
    }

    private void viewEmployeesSortedBySalary() {
        List<BankEmployee> employees = employeeService.getEmployeesSortedBySalary();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n--- Employees Sorted by Salary ---");
        for (BankEmployee emp : employees) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) {
        new BankEmployeeManagementApp().start();
    }
}