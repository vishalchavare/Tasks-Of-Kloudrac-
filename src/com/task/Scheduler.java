package com.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {

    Map<String, Integer> assignment =
            new HashMap<>();

    public boolean hasCapacity(Task task, Slot slot) {

        if (slot.usedCpu + task.cpu > slot.cpuCapacity) {
            return false;
        }

        if (slot.usedRam + task.ram > slot.ramCapacity) {
            return false;
        }

        if (slot.usedGpu + task.gpu > slot.gpuCapacity) {
            return false;
        }

        if (slot.usedNetwork + task.network > slot.networkCapacity) {
            return false;
        }

        return true;
    }

    public void assignTask(Task task, Slot slot) {

        slot.usedCpu += task.cpu;
        slot.usedRam += task.ram;
        slot.usedGpu += task.gpu;
        slot.usedNetwork += task.network;

        slot.assignedTasks.add(task);

        assignment.put(
                task.id,
                slot.id);

        System.out.println(
                task.id +
                " assigned to Slot " +
                slot.id);
    }

    public boolean hasConflict(
            Task currentTask,
            Task assignedTask) {

        return currentTask.conflicts
                .contains(assignedTask.id);
    }

    public boolean hasConflictInSlot(
            Task task,
            Slot slot) {

        for (Task assignedTask :
                slot.assignedTasks) {

            if (task.conflicts.contains(
                    assignedTask.id)) {

                return true;
            }
        }

        return false;
    }

    public boolean withinWindow(
            Task task,
            int slotId) {

        return slotId >= task.startWindow
                &&
                slotId <= task.endWindow;
    }

    public void scheduleTasks(
            ArrayList<Task> tasks,
            ArrayList<Slot> slots) {

        for (Task task : tasks) {

            boolean assigned = false;

            for (Slot slot : slots) {

                if (!hasConflictInSlot(task, slot)
                        &&
                        hasCapacity(task, slot)
                        &&
                        withinWindow(task, slot.id)) {

                    assignTask(task, slot);

                    assigned = true;

                    break;
                }
            }

            if (!assigned) {

                System.out.println(
                        task.id +
                        " could not be assigned");
            }
        }

        System.out.println();

        System.out.println(
                "Final Assignment");

        System.out.println(
                assignment);

        System.out.println(
                "Penalty : "
                        + calculatePenalty());
    }

    public double calculatePenalty() {

        double penalty = 0;

        for (String taskId :
                assignment.keySet()) {

            int slotId =
                    assignment.get(taskId);

            penalty += slotId;
        }

        return penalty;
    }
}