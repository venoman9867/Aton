package ru.Aton.Theards;

import java.util.Arrays;

public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        String[][] lyrics = {
                {"Cher", "They say we're young and we don't know \nWe won't find out until we grow"},
                {"Sonny", "Well I don't know if all that's true \n'Cause you got me, and baby I got you"},
                {"Sonny", "Babe"},
                {"Sonny, Cher", "I got you babe \nI got you babe"},
                {"Cher", "They say our love won't pay the rent \nBefore it's earned, our money's all been spent"},
                {"Sonny", "I guess that's so, we don't have a pot \nBut at least I'm sure of all the things we got"},
                {"Sonny", "Babe"},
                {"Sonny, Cher", "I got you babe \nI got you babe"},
                {"Sonny", "I got flowers in the spring \nI got you to wear my ring"},
                {"Cher", "And when I'm sad, you're a clown \nAnd if I get scared, you're always around"},
                {"Cher", "So let them say your hair's too long \n'Cause I don't care, with you I can't go wrong"},
                {"Sonny", "Then put your little hand in mine \nThere ain't no hill or mountain we can't climb"},
                {"Sonny", "Babe"},
                {"Sonny, Cher", "I got you babe \nI got you babe"},
                {"Sonny", "I got you to hold my hand"},
                {"Cher", "I got you to understand"},
                {"Sonny", "I got you to walk with me"},
                {"Cher", "I got you to talk with me"},
                {"Sonny", "I got you to kiss goodnight"},
                {"Cher", "I got you to hold me tight"},
                {"Sonny", "I got you, I won't let go"},
                {"Cher", "I got you to love me so"},
                {"Sonny, Cher", "I got you babe \nI got you babe \nI got you babe \nI got you babe \nI got you babe"}
        };
        Runnable cherTurn = () -> {//Строки песни для Cher
            Arrays.stream(lyrics).forEach(arr -> {
                if(arr[0].equals("Sonny, Cher")){//Cher и Sonny поют вместе!
                    System.out.println("Cher: "+arr[1]);
                }
                if (arr[0].equals("Cher")) {
                    synchronized (lock) {
                        try {
                            System.out.println("Cher: " + arr[1]);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {//если строка не принадлежит Cher мы ждем пока Sonny ее прочитает
                    synchronized (lock) {
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            });
        };
        Runnable sonnyTurn = () -> {//Строки песни для Sonny
            Arrays.stream(lyrics).forEach(arr -> {
                if(arr[0].equals("Sonny, Cher")){//Cher и Sonny поют вместе!
                    System.out.println("Sonny: "+arr[1]);
                }
                if (arr[0].equals("Sonny")) {
                    synchronized (lock) {
                        try {
                            System.out.println("Sonny: " + arr[1]);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {//если строка не принадлежит Sonny мы ждем пока Cher ее прочитает
                    synchronized (lock) {
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        };
        Thread cher = new Thread(cherTurn);
        Thread sonny = new Thread(sonnyTurn);
        cher.start();
        sonny.start();
    }

}
