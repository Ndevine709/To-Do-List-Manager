package com.toDoListManager;

public class Task {
    String description;
    boolean taskStatus;
    Task next;

    public Task(String description) {
        this.description = description;
        this.taskStatus = false;
        this.next = null;
    }

    public void completeTask() {
        this.taskStatus = true;
    }

    @Override
    public String toString() {
        return description + " - " + (taskStatus ? "Completed" : "Pending");
    }
}
