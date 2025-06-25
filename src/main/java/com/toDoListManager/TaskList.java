package com.toDoListManager;

public class TaskList {
    private Task head;

    public void addNewTask(String description) {
        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public boolean markTaskAsCompleted(String description) {
        Task current = head;
        while (current !=null) {
            if (current.description.equals(description)) {
                current.completeTask();
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks in the list to print.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
