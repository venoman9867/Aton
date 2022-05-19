package ru.Aton.Train;


import java.util.Iterator;

public class CircularLinkedList implements Iterator {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public boolean hasNext() {
        Node currentNode;
        return currentNode!=head;
    }
    @Override
    public Boolean next() {
        return null;
    }

    static class Node {

        boolean value;//значение света внутри вагона
        Node nextNode;//переменная которая будет указывать на следующий узел

        public Node(boolean value) {
            this.value = value;
        }
    }

    public Node getHead() {//геттер, чтобы включить свет в первом вагоне
        return head;
    }// метод возращающий первый вагон

    public void addNode(boolean value) {
        Node newNode = new Node(value);//создаем новый узел

        if (head == null) {//если головы нету, новый узел становится головой
            head = newNode;
        } else {
            tail.nextNode = newNode;//иначе последний узел указывает на новый добавленный
        }
        size++;
        tail = newNode;//последний узел становится хвостом
        tail.nextNode = head;//и вновь добавленный последний узел указывает на голову
    }//метод добавляет вагон


}



