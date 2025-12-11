package org.example;

public class ToDoList {
    private Task[] list;
    private String name;
    private int k;

    public ToDoList(String name) {
        this.list = new Task[200];
        this.name = name;
        this.k = 0;
    }

    @Override
    public String toString() {
        if (k == 0)
            return "Список дел пуст";
        String s = "";
        for (int i = 0; i < k; i++) {
            if (list[i].isCompleted())
                s += "(" + (i+1) + ") " + "[x] " + "«" + list[i].getName() + "»" + "\n";
            else
                s += "(" + (i+1) + ") " + "[] " + "«" + list[i].getName() + "»" + "\n";
        }
        return s;
    }

    public void printNotCompletedTasks() {
        for (int i = 0; i < k; i++) {
            if (!list[i].isCompleted())
                System.out.println("(" + (i + 1) + ") " + "[x] " + "«" + list[i].getName() + "»");
        }
    }

    public void printCompletedTasks() {
        for (int i = 0; i < k; i++) {
            if (list[i].isCompleted())
                System.out.println("(" + (i + 1) + ") " + "[x] " + "«" + list[i].getName() + "»");
        }
    }

    public void addNewTask(Task newTask) {
        if (k == 0) {
            list[k] = newTask;
            k++;
        } else {
            int f = 0;
            for (int i = 0; i < k; i++) {
                if (list[i].getName().equals(newTask.getName())) {
                    f=1;
                }
            }
            if(f==0){
                list[k] = newTask;
                k++;
            }
        }
    }

    public void completeTask(int i) {
        if (i > 0 && i < k)
            list[i - 1].setCompleted(true);
    }

    public void completeTask(String name) {
        for (int i = 0; i < k; i++) {
            if (list[i].getName().equals(name))
                list[i].setCompleted(true);
        }
    }

    public int numByName(String name) {
        for (int i = 0; i < k; i++) {
            if (list[i].getName().equals(name))
                return i + 1;
        }
        return -1;
    }

    public void deleteTask(int i){
        if(i>0 && i<=k) {
            list[i - 1] = null;
            for (int j = i - 1; j < k; j++) {
                list[j] = list[j + 1];
            }
            k-=1;
        }
    }

    public void deleteTask(String name) {
        int i = numByName(name);
        deleteTask(i);
    }

    public int numberOfTasks() {
        return k;
    }

    public int numberOfCompletedTasks() {
        int c = 0;
        for (int i = 0; i < k; i++) {
            if (list[i].isCompleted())
                c++;
        }
        return c;
    }

    public int numberOfNotCompletedTasks() {
        int c = 0;
        for (int i = 0; i < k; i++) {
            if (!list[i].isCompleted())
                c++;
        }
        return c;
    }

    public double percentageOfCompletedTasks(){
        return (double)numberOfCompletedTasks()/numberOfTasks();
    }

    public void statistics(){
        System.out.println("Общее количество дел: " + numberOfTasks());
        System.out.println("Количество выполненных дел: " + numberOfCompletedTasks());
        System.out.println("Количество невыполненных дел: " + numberOfNotCompletedTasks());
        System.out.printf("Процент выполнения: %.2f", percentageOfCompletedTasks());
    }
}