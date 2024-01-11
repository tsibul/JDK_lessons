package hw5;

import java.util.ArrayList;
import java.util.HashMap;

import static hw5.Fork.*;

public class Philosopher extends Thread {

    private String name;
    private int eatCounter;

    private PhilLang nationality;

    private int index;
    private ArrayList<Fork> forkList;

    public Philosopher(String name, int index, ArrayList<Fork> forkList, String nationality) {
        this.name = name;
        this.index = index;
        this.forkList = forkList;
        this.nationality = new PhilLang(nationality);
    }

    public void think() {
        System.out.println(index + " " + name + ": '" + nationality.getMessage("thinkStart") + "'");
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(index + " " + name + ": '" + nationality.getMessage("thinkFinish") + "'");
        System.out.println(index + " " + name + ": '" + nationality.getMessage("lookForFood") + "'");
    }

    public void eat() {
        if (takeForks(index, forkList)) {
            System.out.println(index + " " + name + ": '" + nationality.getMessage("eatStart") + "' Forks:" + arrToString(forkList));
            eatCounter++;
            try {
                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(index + " " + name + ": '" + nationality.getMessage("eatFinish") + "'");
            putForks(index, forkList);
        }
    }

    @Override
    public void run() {
        while (eatCounter < 4) {
            think();
            eat();
        }
        System.out.println(index + " " + name + ": '" + nationality.getMessage("stop") + "' (" + (eatCounter - 1) + ")");
    }
}

