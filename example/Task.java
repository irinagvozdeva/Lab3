package org.example;

public class Task {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    @Override
    public String toString(){
        String s = "";
        if (this.isCompleted())
            s += "[x] " + "«" + this.name + "»" + "\n";
        else
            s += "[] " + "«" + this.name + "»" + "\n";
        return s;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}