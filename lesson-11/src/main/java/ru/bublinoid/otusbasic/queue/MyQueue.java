package ru.bublinoid.otusbasic.queue;

import ru.bublinoid.otusbasic.inkedlist.MyLinkedList;

public class MyQueue<T> {

    private MyLinkedList<T> linkedList;

    public MyQueue() {
        this.linkedList = new MyLinkedList<>();
    }

    public void offer(T data) {
        linkedList.addLast(data);
    }

    public T poll() {
        return linkedList.getSize() == 0 ? null : linkedList.remove(0);
    }
}