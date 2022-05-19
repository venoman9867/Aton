package ru.Aton.Train;

public class Main {
    /*Значит, идея такая, что нам нужно включить свет в начальном вагоне, в котором мы находимся, если он ещё не горит.
     Затем пойти в одну любую сторону до тех пор, пока не встретим там вагон с работающим освещением, при этом
     считаем пройденные вагоны. Выключаем в найденном вагоне свет и идём обратно к начальному. Если в нём свет всё ещё
      горит, то повторяем операцию. Если же нет, значит мы прошли полный круг и уже знаем ответ!*/
    public static void main(String[] args) {
        CircularLinkedList train = RandomTrain.getRandomTrain();
        int count=0;
       if(!train.getHead().value){//Итак, мы оказались в первом вагоне, включаем свет!
           train.getHead().value=true;
       }
    }
}
