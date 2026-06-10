package com.task;
import java.util.HashSet;
import java.util.Set;

public class Task {
	Set<String> conflicts = new HashSet<>();
	

    String id;

    double cpu;
    double ram;
    double gpu;
    double network;

    int startWindow;
    int endWindow;

    double weight;

    public Task(String id, double cpu, double ram,
                double gpu, double network,
                int startWindow, int endWindow,
                double weight) {

        this.id = id;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.network = network;
        this.startWindow = startWindow;
        this.endWindow = endWindow;
        this.weight = weight;
        
    }
}