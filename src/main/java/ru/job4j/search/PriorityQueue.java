package ru.job4j.search;

import java.util.LinkedList;

/**
 * The class describes the operation of the simplest priority queue,
 * which works according to the FIFO principle.
 * @author Vladimir Seregin
 * @version 1.0
 */
public class PriorityQueue {

    /**
     * The task is stored in a collection of type LinkedList.
     */
    private final LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method accepts a request as input and adds it to the queue.
     * If there are 2 tasks with the same priority,
     * then they are distributed in the queue according to the FIFO principle.
     * @param task the task that is added to the queue.
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * The method allows you to get the first task in the queue.
     * @return task from the head of the queue or null if the queue is empty.
     */
    public Task take() {
        return tasks.poll();
    }
}
