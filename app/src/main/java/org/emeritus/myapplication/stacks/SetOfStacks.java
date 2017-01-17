package org.emeritus.myapplication.stacks;

import java.util.Stack;

/**
 * Created by darrankelinske on 1/13/17.
 */

public class SetOfStacks<T> extends Stack<T> {
    Stack<Stack<T>> setOfStacks;
    Stack<T> currentStack;
    public int totalCount;
    public SetOfStacks() {
        setOfStacks = new Stack<>();
        currentStack = new Stack<>();
        totalCount = 0;
    }

    @Override
    public T push(T item) {
        if (totalCount % 33 == 0) {
            setOfStacks.push(currentStack);
            currentStack = new Stack<>();
        }
        currentStack.push(item);
        totalCount++;
        return item;
    }

    @Override
    public synchronized T pop() {
        T item = currentStack.pop();
        totalCount--;
        if (totalCount % 33 == 0) {
            currentStack = setOfStacks.pop();
        }
        return item;
    }
}
