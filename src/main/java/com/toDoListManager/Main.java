package com.toDoListManager;

import java.util.Scanner;

public class Main {
    static final int MAX_USERS = 6;
    static User[] users = new User[MAX_USERS];
    static int userCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("-- To-Do List Manager --");
            System.out.println("1. Create a new user");
            System.out.println("2. Add a task to a user");
            System.out.println("3. Manage a users tasks (mark as complete/view)");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createUser();
                    break;

                case 2:
                    addTaskToUser();
                    break;

                case 3:
                    manageUserTasks();
                    break;
                
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        } while (choice != 4);
    }

    static User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }

    static void createUser() {
            if (userCount >= MAX_USERS) {
                System.out.println("User limit reached.");
                return;
            }

            System.out.println("Enter the users name: ");
            String name = scanner.nextLine();

            if (getUser(name) != null) {
                System.out.println("User already exists.");
                return;
            }

            users[userCount++] = new User(name);
            System.out.println("User " + name + " was created");
        }

    static User getUserByName() {
        System.out.println("Please enter ther users name: ");
        String name = scanner.nextLine();
        User user = getUser(name);
        if (user == null) {
            System.out.println("User not found.");
        }
        return user;
    }

    static void addTaskToUser() {
       User user = getUserByName();
       if (user == null) {
        return;
       }
       String task;
       do {
        System.out.println("Please enter the tasks description (cannot be empty): ");
        task = scanner.nextLine().trim();
        if (task.isEmpty()) {
            System.out.println("Task cannot be empty, please try again");
        };
       } while (task.isEmpty());
       user.addTasktoUsersList(task);
       System.out.println("Task has been added.");
    }

    static void manageUserTasks() {
        User user = getUserByName();
        if (user == null) {
            return;
        }

        System.out.println("1. Mark a task as completed");
        System.out.println("2. View all tasks");
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            System.out.println("Enter the tasks description to mark it as completed: ");
            String description = scanner.nextLine();
            user.markTaskAsCompleted(description);
        } else if (option == 2) {
            user.printTasksForUser();
        } else {
            System.out.println("Invalid option, please try again.");
        }
    }
}
