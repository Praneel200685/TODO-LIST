import java.util.*;

public class Main {
    private ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Main app = new Main();
        app.manageTodoList();
    }

    public void manageTodoList() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the TODO List Application!");

        do {
            displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting the TODO List Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nTODO List Menu:");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. Display tasks");
        System.out.println("4. Exit");
    }

    private void addTask(Scanner sc) {
        System.out.println("Enter the task to add:");
        String task = sc.nextLine();
        todoList.add(task);
        System.out.println("Task added successfully!");
    }

    private void removeTask(Scanner scanner) {
        if (todoList.isEmpty()) {
            System.out.println("The TODO list is empty. Nothing to remove.");
            return;
        }

        displayTasks();
        System.out.println("Enter the task number to remove:");
        int taskNumber = scanner.nextInt();

        if (taskNumber > 0 && taskNumber <= todoList.size()) {
            todoList.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private void displayTasks() {
        if (todoList.isEmpty()) {
            System.out.println("The TODO list is currently empty.");
            return;
        }

        System.out.println("\nTODO List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }
}