package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList("Список дел");
        toDoList.addNewTask(new Task("Сходить в магазин"));
        toDoList.addNewTask(new Task("Купить воду"));
        toDoList.addNewTask(new Task("Купить колечко"));
        toDoList.addNewTask(new Task("Купить браслетик"));
        toDoList.addNewTask(new Task("Помыть посуду"));
        toDoList.addNewTask(new Task("Помыть пол"));
        toDoList.addNewTask(new Task("Сходить в магазин"));

        System.out.println(toDoList);

        toDoList.completeTask(3);
        toDoList.completeTask(4);
        toDoList.completeTask("Помыть пол");

        System.out.println(toDoList);

        toDoList.deleteTask("Помыть пол");
        System.out.println(toDoList);

        toDoList.printCompletedTasks();
        System.out.println();
        toDoList.printNotCompletedTasks();
        System.out.println();

        toDoList.statistics();
    }
}