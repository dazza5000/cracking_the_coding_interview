package org.emeritus.myapplication.stacks;

import java.util.EmptyStackException;

/**
 * Created by darrankelinske on 1/13/17.
 */

public class CrackingStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private T min;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> node = new StackNode<>(item);
        node.next = top;
        top = node;
//        if (item < min) {
//            min = item;
//        }
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

//    public T min(){
//        return min;
//    }
}
