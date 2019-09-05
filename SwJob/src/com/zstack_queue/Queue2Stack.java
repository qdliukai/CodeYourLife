package com.zstack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2Stack {
    Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public Queue2Stack() {
        this.q = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        int ret = q.remove();
        q.add(ret);
        return ret;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}
