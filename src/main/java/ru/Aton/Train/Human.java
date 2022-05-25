package ru.Aton.Train;

import java.util.ArrayList;

public class Human {
    private Train train = new Train();
    private ArrayList<Carriage> randomTrain = train.makeTrain();
    private Carriage head=train.randomPosition();

    //метод обхода по вагонам и подсчета их количества
    public void countCarriages() {
        int count = 0;
        head.value=true;//первым делом человек включает свет в первом вагоне
        Carriage currentCarriage=head;
        System.out.println("Сколько должно было быть: "+train.countOfCarriages);
        do{
            currentCarriage=currentCarriage.nextCarriage;
            if(currentCarriage.value=false){
                currentCarriage=currentCarriage.nextCarriage;
                count++;
            }else{
                currentCarriage.value=false;//выключаем свет
                count=0;//обнуляем счетчик
                continue;//начинаем по новой цикл
            }

        }while (head.value!=false);//делаем до дех пор пока head не будет false
        System.out.println("Сколько насчиталось: "+count);
    }

}
