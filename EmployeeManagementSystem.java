import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String name;
    int age;
    String position;
    double salary;

    public Employee(String name, int age, String position, double salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.next();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();

        System.out.print("Enter employee position: ");
        String position = scanner.next();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(name, age, position, salary);
        employees.add(newEmployee);

        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee employee : employees) {
                System.out.println("Name: " + employee.name +
                                   ", Age: " + employee.age +
                                   ", Position: " + employee.position +
                                   ", Salary: " + employee.salary);
            }
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter the name of the employee to update: ");
        String searchName = scanner.next();

        for (Employee employee : employees) {
            if (employee.name.equals(searchName)) {
                System.out.print("Enter new position: ");
                String newPosition = scanner.next();
                employee.position = newPosition;

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter the name of the employee to delete: ");
        String searchName = scanner.next();

        for (Employee employee : employees) {
            if (employee.name.equals(searchName)) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}