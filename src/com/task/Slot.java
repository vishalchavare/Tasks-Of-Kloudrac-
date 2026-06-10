package com.task;
import java.util.ArrayList;
public class Slot {
	ArrayList<Task> assignedTasks =
	        new ArrayList<>();

    int id;

    double cpuCapacity;
    double ramCapacity;
    double gpuCapacity;
    double networkCapacity;

    double usedCpu;
    double usedRam;
    double usedGpu;
    double usedNetwork;

    public Slot(int id,
                double cpuCapacity,
                double ramCapacity,
                double gpuCapacity,
                double networkCapacity) {

        this.id = id;

        this.cpuCapacity = cpuCapacity;
        this.ramCapacity = ramCapacity;
        this.gpuCapacity = gpuCapacity;
        this.networkCapacity = networkCapacity;
    }
}