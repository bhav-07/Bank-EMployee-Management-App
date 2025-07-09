# Bank Employee Management App

A simple Java console application for managing bank employee records. This application lets you add, view, search, update, and delete employee information for bank managers and tellers.

## What This App Does

This is a command-line program that helps manage bank employee data. You can store information about two types of employees:
- **Bank Managers**: Have a name, salary, and department
- **Bank Tellers**: Have a name, salary, and branch location

The app keeps all data in memory while it's running and comes with some sample employee records to get you started.

## Features

The application provides these main functions through a menu system:

1. **Add New Employee** - Create records for new managers or tellers
2. **View All Employees** - See a list of all current employees  
3. **Search by ID** - Find a specific employee using their ID
4. **Update Employee** - Change employee details like name, salary, or department/branch
5. **Delete Employee** - Remove an employee from the system
6. **Sort by Salary** - Display employees ordered by their salary amount
7. **Exit** - Close the application

## How It Works

The app follows a simple layered structure:

- **User Interface**: The main class handles menu display and user input
- **Business Logic**: Service class manages employee operations and validation  
- **Data Storage**: Repository class stores employee data in memory
- **Employee Models**: Classes that define what employee information looks like
- **Error Handling**: Custom exceptions for common problems like duplicate names 

## Project Structure

```
src/bems/
├── client/                    # Main application
│   └── BankEmployeeManagementApp.java
├── service/                   # Business logic
│   └── BankEmployeeService.java
├── repository/                # Data management
│   └── BankEmployeeRepository.java
├── model/                     # Employee classes
│   ├── BankEmployee.java
│   ├── BankManager.java
│   └── BankTeller.java
├── exception/                 # Error handling
│   ├── DuplicateEmployeeException.java
│   ├── EmployeeNotFoundException.java
│   └── InvalidEmployeeTypeException.java
└── utility/                   # Helper tools
    └── IDGenerator.java
```

## Employee Types

### Bank Manager
- Has a department (like "Loans", "Customer Service", etc.)
- Typically has higher salary ranges
- Manages specific bank departments

### Bank Teller  
- Assigned to a specific branch location
- Handles customer transactions
- Works at branch level operations 

## How Employee IDs Work

Each employee gets a unique ID automatically when created. The system generates IDs like "E101", "E102", "E103" and so on. You don't need to worry about creating IDs yourself.

## Error Handling

The app handles common problems gracefully:

- **Duplicate Names**: Won't let you add two employees with the same name
- **Employee Not Found**: Shows helpful message if you search for someone who doesn't exist  
- **Invalid Employee Type**: Catches mistakes when specifying manager vs teller

## Sample Data

The app comes with example employees already loaded:
- Sample managers in different departments
- Sample tellers at various branches
- Different salary ranges to demonstrate sorting

## Technical Details

**Language**: Java  
**Storage**: In-memory (data doesn't persist after closing)  
**Interface**: Command-line menu system  
**Architecture**: Layered design with separation of concerns  

The code uses object-oriented principles like inheritance (BankManager and BankTeller both extend BankEmployee) and follows common design patterns like Repository and Service layers.

## Running the Application

To run this application:
1. Make sure you have Java installed
2. Compile all the Java files in the src/bems directory
3. Run the BankEmployeeManagementApp class
4. Follow the menu prompts to manage employee data

The application will show you a numbered menu and wait for your choice. Simply type the number of the operation you want to perform.

## Notes

- This is a learning project that demonstrates basic Java concepts
- Data is stored in memory only - it won't save when you close the app
- The user interface is text-based for simplicity
- All employee names must be unique in the system
- Salary values are stored as decimal numbers
