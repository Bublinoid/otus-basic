package ru.bublinoid.otusbasic.stack;

import ru.bublinoid.otusbasic.inkedlist.MyLinkedList;

public class MyStack<T> {

    private MyLinkedList<T> linkedList;

    public MyStack() {
        this.linkedList = new MyLinkedList<>();
    }

    public void push(T data) {
        linkedList.addFirst(data);
    }

    public T pop() {

        if (linkedList.getSize() == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        return linkedList.remove(0);
    }
}