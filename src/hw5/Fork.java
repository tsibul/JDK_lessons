package hw5;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Fork {
    private AtomicBoolean inUse;

    public Fork() {
        this.inUse = new AtomicBoolean();
    }

    public AtomicBoolean getInUse() {
        return inUse;
    }

    public void toggleInUse() {
        inUse.set(!inUse.get());
    }

    public static ArrayList<Fork> createForkList(int quantity) {
        ArrayList<Fork> forkList = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            forkList.add(new Fork());
            i++;
        }
        return forkList;
    }

    synchronized public static boolean forksFree(int index, ArrayList<Fork> forkList) {
        return !(forkList.get(index).getInUse().get() ||  forkList.get((index + 1) % forkList.size()).getInUse().get());
    }

    public static boolean takeForks(int index, ArrayList<Fork> forkList) {
        if (forksFree(index, forkList)) {
            forkList.get(index).toggleInUse();
            forkList.get((index + 1) % forkList.size()).toggleInUse();
            return true;
        }
        return false;
    }
    public static void putForks(int index, ArrayList<Fork> forkList) {
            forkList.get(index).toggleInUse();
            forkList.get((index + 1) % forkList.size()).toggleInUse();
    }



    public static String arrToString(ArrayList<Fork> forkArrayList) {
        String out = "";
        for(int i = 0; i < forkArrayList.size(); i++){
            out = out + " (" + i + ", " + forkArrayList.get(i).inUse.get() + ")";
        }
        return out;
    }
}
