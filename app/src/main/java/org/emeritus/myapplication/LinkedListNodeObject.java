package org.emeritus.myapplication;

/**
 * Created by darrankelinske on 1/2/17.
 */

public class LinkedListNodeObject {
    public LinkedListNodeObject next;
    public LinkedListNodeObject prev;
    public LinkedListNodeObject last;
    public Object data;
    public LinkedListNodeObject(Object d, LinkedListNodeObject n, LinkedListNodeObject p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    public LinkedListNodeObject(Object d) {
        data = d;
    }

    public LinkedListNodeObject() { }

    public void setNext(LinkedListNodeObject n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNodeObject p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }

    public LinkedListNodeObject clone() {
        LinkedListNodeObject next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        LinkedListNodeObject head2 = new LinkedListNodeObject(data, next2, null);
        return head2;
    }
}
