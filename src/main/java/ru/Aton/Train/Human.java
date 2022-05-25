package ru.Aton.Train;

import java.util.ArrayList;

public class Human {
    private Train train = new Train();
    ArrayList<Carriage> randomTrain = train.makeTrain();

    //метод обхода по вагонам и подсчета их количества
    public void countCarriages() {
        int count = 0;
        Carriage head=train.randomPosition();
        head.value=true;
        Carriage currentCarriage=head.nextCarriage;
        System.out.println("Сколько должно было быть: "+train.countOfCarriages);
        do{
            if(currentCarriage.value==true){//если свет включен в вагоне включен выключаем его и начинаем заново
                currentCarriage.value=false;
                count=0;
                continue;
            }else{
                currentCarriage=currentCarriage.nextCarriage;//если свет выключен, просто идем дальше и считаем!
                count++;
            }

        }while (head.value==false);//делаем до дех пор пока head не будет false
        System.out.println("Сколько насчиталось: "+count);
    }

}
