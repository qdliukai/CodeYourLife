package com.zstack_queue;

import java.util.Stack;

class Stack2Queue {
    Stack<Integer> pushstack;
    Stack<Integer> popstack;

    /**
     * Initialize your data structure here.
     */
    public Stack2Queue() {
        this.pushstack = new Stack();
        this.popstack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushstack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (popstack.isEmpty()) {
            while (!pushstack.isEmpty()) {
                popstack.push(pushstack.pop());
            }
        }
        return popstack.pop();
    }


    /**
     * Get the front element.
     */
    public int peek() {
        if (popstack.isEmpty()) {
            while (!pushstack.isEmpty()) {
                popstack.push(pushstack.pop());
            }
        }
        return popstack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushstack.isEmpty() && popstack.isEmpty();
    }
}