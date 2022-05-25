package ru.Aton.Train;

import java.util.ArrayList;

public class Human {
    private Train train = new Train();
    ArrayList<Carriage> randomTrain = train.makeTrain();

    //метод для изменения света в вагоне
    public void changeLight() {
    }

    //метод обхода по вагонам и подсчета их количества
    public void countCarriages() {
        int count = 0;
        Carriage head = train.randomPosition();
        Carriage currentCarriage = train.randomPosition();
        System.out.println("Сколько должно было быть: "+train.countOfCarriages);
        do {
            currentCarriage = currentCarriage.nextCarriage;
            count++;
        } while (currentCarriage != head);
        System.out.println("Сколько насчиталось: "+count);
    }

}
