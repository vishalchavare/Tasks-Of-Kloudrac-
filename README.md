#  Scheduling Assignment

## Overview

This project implements a Conflict Resource Aware Greedy Scheduler (CRAGS) for assigning tasks to execution slots while satisfying:

* Conflict constraints
* Resource capacity constraints
* SLA window constraints

## Approach

The scheduler processes tasks sequentially and assigns each task to the first feasible slot.

A slot is considered feasible if:

1. No conflicting task already exists in that slot
2. Resource capacity is available
3. The slot lies within the task SLA window

## Components

### Task

Represents workload information including resource requirements, SLA window and priority weight.

### Slot

Represents execution capacity and tracks assigned tasks.

### Scheduler

Responsible for:

* Conflict checking
* Capacity checking
* SLA validation
* Task assignment
* Penalty calculation

## Penalty Function

Penalty = Sum of Assigned Slot Numbers

Example:

T1 -> Slot 1

T2 -> Slot 2

T3 -> Slot 1

Penalty = 1 + 2 + 1 = 4

## Execution

Run:

Main.java

## Sample Output

T1 assigned to Slot 1

T2 assigned to Slot 2

T3 assigned to Slot 1

Final Assignment

{T1=1, T2=2, T3=1}

Penalty : 4.0
