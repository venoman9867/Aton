package ru.Aton.Train;

import java.util.ArrayList;

public class Human {
    private final Train train = new Train();
    private final ArrayList<Carriage> randomTrain = train.makeTrain();
    private final Carriage head = randomTrain.get(train.randomPosition());

    //метод обхода по вагонам и подсчета их количества
    public void countCarriages() {
        int count = 0;
        //если свет в вагоне выключен мы его включаем
        if (!head.value) {
            head.value = true;
        }
        //Завожу переменную текущий вагон, чтобы итерироваться по поезду
        Carriage currentCarriage = head;
        System.out.println("Сколько вагонов в составе: " + train.countOfCarriages);
        do {
            currentCarriage = currentCarriage.nextCarriage;//текущим вагоном становится следующий вагон
            count++;
            if (currentCarriage.value) {// если свет включен, выключаем его
                currentCarriage.value = false;
                for (int i = count; i > 0; i--) {// и идем обратно
                    currentCarriage = currentCarriage.previousCarriage;
                }
                count = 0;//сбрасываем счетчик
            }
        } while (currentCarriage.nextCarriage != head);//делаем до тех пор, пока голова поезда не выключится
        System.out.println("Сколько вагонов насчиталось: " + (count + 1));
    }

}
