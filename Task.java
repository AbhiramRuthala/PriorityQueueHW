// Name: Abhiram Ruthala
// Computing ID: kas4kj@virginia.edu
// Homework Name: HW-12 Priority Queue
// Resources used: Claude Sonnet 4.5 for debugging

import java.util.Objects;

public class Task implements Comparable<Task> {
    private int priority;
    private String name;
    public Task(String name) {
        this.name = name;
        this.priority = 0;
    }
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    //Fix comparable function - check the logic and implement it correctly. I think sense is right, but let's actually see through the logic here.

    //Check over and see which one is right in terms of the implemented logic.
//    @Override
//    public int compareTo(Task t1) {
//        return 1;
//    }

    @Override
    public int compareTo(Task o) {
        if(o.getPriority() > this.priority) return 1;
        else if(o.getPriority() < this.priority) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "[ " + name + "," + priority + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return priority == task.priority && Objects.equals(name, task.name);
    }

}
