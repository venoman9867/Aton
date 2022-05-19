package ru.Aton.Train;

import java.util.Random;

/*Здесь происходит, все то о чем не должен знать человек в поезде*/
public class RandomTrain {

    public static CircularLinkedList getRandomTrain() {
        int size = (int) (Math.random() * 10);//рандомное количество поездов
        CircularLinkedList train = new CircularLinkedList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            train.addNode(random.nextBoolean());//рандомное расставление освещения в поездах, true-on, false-off
        }
        return train;
    }
}
