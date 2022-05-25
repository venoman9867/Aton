package ru.Aton.Train;

//Класс вагон
public class Carriage {
    boolean value;//значение света внутри вагона
    Carriage nextCarriage;//переменная которая будет указывать на следующий узел
    Carriage previousCarriage;//переменная которая будет указывать на предыдущий узел

    public Carriage(boolean value) {
        this.value = value;
        this.nextCarriage = this;
        this.previousCarriage = this;

    }
}
