package ru.Aton.Train;

import java.util.ArrayList;

public class Human {
    private Train train = new Train();
    ArrayList<Carriage> randomTrain = train.makeTrain();

    //метод обхода по вагонам и подсчета их количества
    public void countCarriages() {
        int count = 0;
        Carriage head=train.randomPosition();
        Carriage currentCarriage=head;
        System.out.println("Сколько должно было быть: "+train.countOfCarriages);
        do{
            if(currentCarriage.value==true){
                currentCarriage.value=false;
                count=0;
                break;
            }
            count++;
        }while (head.value!=false);//делаем до дех пор пока head не будет false
        System.out.println("Сколько насчиталось: "+count);
    }

}
