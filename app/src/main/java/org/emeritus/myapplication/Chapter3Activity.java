package org.emeritus.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.emeritus.myapplication.stacks.CrackingStack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by darrankelinske on 1/13/17.
 */

public class Chapter3Activity extends AppCompatActivity{

    public static String TAG = Chapter3Activity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CrackingStack<Integer> integerCrackingStack = new CrackingStack<>();
        integerCrackingStack.push(7);
        integerCrackingStack.push(3);
        integerCrackingStack.push(10);

        Stack<Integer> testStack = new Stack<>();
        testStack.push(4);
        testStack.push(3);
        testStack.push(10);
        testStack.push(7);
//
//        Log.d(TAG, "Popped value is: " +integerCrackingStack.pop());
//        Log.d(TAG, "Popped value is: " +integerCrackingStack.pop());
//        Log.d(TAG, "Popped value is: " +integerCrackingStack.pop());
//        Log.d(TAG, "Popped value is: " +integerCrackingStack.pop());

        StackWithMin2 stackWithMin2 = new StackWithMin2();
        stackWithMin2.push(7);
        Log.d(TAG, "The min is: " +stackWithMin2.min());
        stackWithMin2.push(3);
        Log.d(TAG, "The min is: " +stackWithMin2.min());
        stackWithMin2.push(1);
        Log.d(TAG, "The min is: " +stackWithMin2.min());
        stackWithMin2.pop();
        Log.d(TAG, "The min is: " +stackWithMin2.min());
        stackWithMin2.pop();
        Log.d(TAG, "The min is: " +stackWithMin2.min());

        Log.d(TAG, " " + stackSorter(testStack));

    }

    public class StackWithMin2 extends Stack<Integer> {
        Stack<Integer> s2;
        public StackWithMin2() {
            s2 = new Stack<>();
        }

        public void push(int value) {
            super.push(value);
            if(value < min()) s2.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                s2.pop();
            }
            return value;
        }

        public Integer min(){
            if(s2.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return s2.peek();
            }
        }
    }

    public Stack<Integer> stackSorter(Stack<Integer> incomingStack) {

    Stack<Integer> tempStack = new Stack<>();

        while(!incomingStack.isEmpty()) {
            int temp = incomingStack.pop();
            while(!tempStack.isEmpty() && temp > tempStack.peek()) {
                incomingStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        return tempStack;

    }

    // Question 3.6

    private class AnimalShelter extends LinkedList<Object> {
        private LinkedListNodeObject linkedListHead;
        private LinkedListNodeObject linkedListTail;
        private LinkedListNode firstDog;
        private LinkedListNode firstCat;

        public void enqueue(Object newAnimal){
            if (linkedListTail == null) {
                linkedListHead = new LinkedListNodeObject(newAnimal);
                linkedListTail = new LinkedListNodeObject(newAnimal);
            } else {
                linkedListTail.setNext(new LinkedListNodeObject(newAnimal));
            }
        }

        public Object dequeueAny() {
            LinkedListNodeObject temp = linkedListHead;
            if (linkedListHead.next != null) {
                linkedListHead = linkedListHead.next;
            }
            return temp.data;
        }

        public Object dequeueCat() {
            LinkedListNodeObject currentNode = linkedListHead;
            while (currentNode != null) {
                if (currentNode instanceof Object) {
                    LinkedListNodeObject tempNode = currentNode;
                    currentNode.data = currentNode.next.data;
                    currentNode.next = currentNode.next.next;
                    return tempNode;
                }
            }
                return null;

        }

        public Object dequeueDog() {
            LinkedListNodeObject currentNode = linkedListHead;
            while (currentNode != null) {
                if (currentNode instanceof Object) {
                    LinkedListNodeObject tempNode = currentNode;
                    currentNode.data = currentNode.next.data;
                    currentNode.next = currentNode.next.next;
                    return tempNode;
                }
            }
            return null;

        }

    }


}
