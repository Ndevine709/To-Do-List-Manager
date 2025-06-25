package com.toDoListManager;

public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTasktoUsersList(String description) {
        taskList.addNewTask(description);
    }

    public void markTaskAsCompleted(String description) {
        boolean success = taskList.markTaskAsCompleted(description);
        if (!success) {
            System.out.println("Task not found for user: " + name);
        }
    }

    public void printTasksForUser() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }

    public String getName() {
        return name;
    }
}
