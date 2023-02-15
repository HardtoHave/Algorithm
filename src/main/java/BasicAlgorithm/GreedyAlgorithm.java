package BasicAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * a list of tasks with their corresponding start and end times,
 * and we want to schedule as many tasks as possible without overlapping.
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //define tasks start time and end time
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", 0, 6));
        tasks.add(new Task("Task 2", 1, 4));
        tasks.add(new Task("Task 3", 3, 5));
        tasks.add(new Task("Task 4", 3, 8));
        tasks.add(new Task("Task 5", 4, 7));
        tasks.add(new Task("Task 6", 5, 9));
        tasks.add(new Task("Task 7", 6, 10));
        tasks.add(new Task("Task 8", 8, 11));
        //sort tasks by ending time in ascending order
        tasks.sort(Comparator.comparingInt(o -> o.endTime));
        for(Task task:tasks){
            System.out.println(task.name);
        }
        //schedule the tasks
        ArrayList<Task> schedule = new ArrayList<>();
        int lastEnd = -1;
        for (Task task : tasks) {
            if (task.startTime >= lastEnd) {
                schedule.add(task);
                lastEnd = task.endTime;
            }
        }
        // Print the schedule
        System.out.println("Schedule:");
        for (Task task : schedule) {
            System.out.println(task.name + " [" + task.startTime + ", " + task.endTime + "]");
        }
    }
    // Define the Task class with name, start time, and end time
    static class Task {
        String name;
        int startTime;
        int endTime;

        public Task(String name, int startTime, int endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
