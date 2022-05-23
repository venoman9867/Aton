package ru.Aton.Train;

public class Main {
    /*Значит, идея такая, что нам нужно включить свет в начальном вагоне, в котором мы находимся, если он ещё не горит.
     Затем пойти в одну любую сторону до тех пор, пока не встретим там вагон с работающим освещением, при этом
     считаем пройденные вагоны. Выключаем в найденном вагоне свет и идём обратно к начальному. Если в нём свет всё ещё
      горит, то повторяем операцию. Если же нет, значит мы прошли полный круг и уже знаем ответ!*/
     static RandomTrain train=new RandomTrain();
    public static void main(String[] args) {

        int i=randomLocation();
        int count=0;
        System.out.println("Вагонов в составе: "+train.getSize());
        while (train.getRandomTrain().get(i).nextNode!=train.getHead()) {
            for (int j = 0; j < train.getSize(); j++) {
                count++;
                if (train.getRandomTrain().get(i).value = true) {
                    train.getRandomTrain().get(i).value = false;
                    count=0;
                    break;
                }
            }
        }
        System.out.println("Вагонов посчиталось "+count);

    }
    public static int randomLocation(){
        return (int)(Math.random()*train.getSize());
    }
}
