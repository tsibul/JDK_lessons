package hw5;

import java.util.ArrayList;

import static hw5.Fork.arrToString;
import static hw5.Fork.createForkList;

public class Main {
    public static void main(String[] args) {
        int itemsNo = 5;
        ArrayList<Fork> forkList = createForkList(itemsNo);
        System.out.println(arrToString(forkList));

//        for (int i = 0; i < itemsNo; i++){
//            Philosopher philosopher = new Philosopher("", i, forkList  );
//            philosopher.start();
//        }

        Philosopher socratos = new Philosopher("Socratos", 0, forkList, "ell");
        Philosopher platonos = new Philosopher("Platonos", 1, forkList, "eng");
        Philosopher heraclitos = new Philosopher("Heraclitos", 2, forkList, "eng");
        Philosopher chaadaev = new Philosopher("Чаадев", 3, forkList, "rus");
        Philosopher shedrovitskiy = new Philosopher("Щедровицкий", 4, forkList, "rus");
        socratos.start();
        platonos.start();
        heraclitos.start();
        chaadaev.start();
        shedrovitskiy.start();

    }
}
