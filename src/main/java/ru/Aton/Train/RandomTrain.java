package ru.Aton.Train;

import java.util.LinkedList;
import java.util.Random;

public class RandomTrain {
    private final int size = (int) ((Math.random() * 1000));//рандомное количество поездов
    private int currentSizeOfTrain;
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Node> getRandomTrain() {
        LinkedList<Node> train = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
           train.add(addNode(random.nextBoolean()));
        }
        return train;
    }

    static class Node {
        boolean value;//значение света внутри вагона
        Node nextNode;//переменная которая будет указывать на следующий узел
        Node previousNode;//переменная которая будет указывать на предыдущий узел

        public Node(boolean value) {
            this.value = value;
            this.nextNode = this;
            this.previousNode = this;

        }
    }

    public Node addNode(boolean value) {
        Node newNode = new Node(value);
        if(currentSizeOfTrain==0){
            head=newNode;
        }else{
            newNode.nextNode=head;
            newNode.previousNode=tail;
            head.previousNode=newNode;
            tail.nextNode=newNode;
        }
        tail=newNode;
        currentSizeOfTrain++;
        return newNode;
    }
}
