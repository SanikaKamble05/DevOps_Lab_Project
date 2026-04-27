package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Complete Assignment|2023-10-01");
        tasks.add("Review Code");
        tasks.add("Write Documentation|2023-10-05");

        ViewTasks viewTasks = new ViewTasks(tasks);
        viewTasks.showTasks();
    }
}