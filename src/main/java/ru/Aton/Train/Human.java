package ru.Aton.Train;

import java.util.ArrayList;

public class Human {
    private Train train = new Train();
    private ArrayList<Carriage> randomTrain = train.makeTrain();
    private Carriage head = randomTrain.get(train.randomPosition());

    //метод обхода по вагонам и подсчета их количества
    public void countCarriages() {
        int count = 0;
        //если свет в вагоне выключен мы его включаем
        if (head.value == false) {
            head.value = true;
        }
        //Завожу переменную текущий вагон, чтобы итерироваться по поезду
        Carriage currentCarriage = head;
        do {
            currentCarriage = currentCarriage.nextCarriage;//текущим вагоном становится следующий вагон
            count++;
            if (currentCarriage.value == true) {// если свет включен выключаем его
                currentCarriage.value = false;
            }
        } while (head.value != false);
        System.out.println("Вагонов в составе: " + count);
    }

}
