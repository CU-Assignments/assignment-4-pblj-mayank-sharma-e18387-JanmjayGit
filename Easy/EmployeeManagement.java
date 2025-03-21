import java.util.ArrayList;
import java.util.Scanner;

// Employee class with Encapsulation
class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display Employee Info
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

// Main class for Employee Management
public class EmployeeManagement {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== Employee Management System ====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> displayAllEmployees();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    // Method to add an employee
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, salary);
        employeeList.add(emp);
        System.out.println("Employee added successfully!");
    }

    // Method to update an employee
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                scanner.nextLine(); // Clear buffer
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();

                emp.setName(newName);
                emp.setSalary(newSalary);
                System.out.println("Employee updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Method to remove an employee
    public static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);

        if (removed) {
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to search for an employee
    public static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println("Employee Found:");
                emp.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Method to display all employees
    public static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employee records found.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee emp : employeeList) {
                emp.displayDetails();
            }
        }
    }
}
