package com.task;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Tasks

        Task task1 =
                new Task(
                        "T1",
                        5,
                        10,
                        1,
                        2,
                        1,
                        3,
                        10);

        Task task2 =
                new Task(
                        "T2",
                        4,
                        8,
                        0,
                        1,
                        1,
                        3,
                        8);

        Task task3 =
                new Task(
                        "T3",
                        6,
                        12,
                        1,
                        1,
                        1,
                        3,
                        6);

        // Conflicts

        task1.conflicts.add("T2");
        task2.conflicts.add("T1");

        // Slots

        Slot slot1 =
                new Slot(
                        1,
                        32,
                        128,
                        8,
                        6);

        Slot slot2 =
                new Slot(
                        2,
                        32,
                        128,
                        8,
                        6);

        // Task List

        ArrayList<Task> tasks =
                new ArrayList<>();

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        // Slot List

        ArrayList<Slot> slots =
                new ArrayList<>();

        slots.add(slot1);
        slots.add(slot2);

        // Scheduler

        Scheduler scheduler =
                new Scheduler();

        scheduler.scheduleTasks(
                tasks,
                slots);

    }
}