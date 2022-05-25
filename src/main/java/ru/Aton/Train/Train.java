package ru.Aton.Train;

import java.util.ArrayList;
import java.util.Random;

public class Train {
    private Random random = new Random();
    private Carriage head;//это первый поезд
    private Carriage tail;//это последний поезд
    private final int countOfCarriages = random.nextInt(1, 1000);//это сколько в нем будет вагонов

    private ArrayList<Carriage> train = new ArrayList<>();//это наш поезд

    //тут мы заполняем поезд с рандомно включенным светом
    public ArrayList<Carriage> makeTrain() {
        for (int i = 0; i < countOfCarriages; i++) {
            train.add(addCarriage(random.nextBoolean()));
        }
        return train;
    }

    //метод возвращающий рандомную позицию человека в поезде
    public Carriage randomPosition() {
        return train.get(random.nextInt(1, countOfCarriages));
    }

    //этот метод нужен для сцепления вагонов, при добавлении нового
    private Carriage addCarriage(boolean value) {
        Carriage newNode = new Carriage(value);
        if (train.size() == 0) {
            head = randomPosition();
        } else {
            newNode.nextCarriage = head;
            newNode.previousCarriage = tail;
            head.previousCarriage = newNode;
            tail.nextCarriage = newNode;
        }
        tail = newNode;
        return newNode;
    }

}
