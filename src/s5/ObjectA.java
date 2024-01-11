package s5;

public class ObjectA extends Thread{

    private ObjectB objectB;

    public void setObjectB(ObjectB objectB) {
        this.objectB = objectB;
    }

    public synchronized void testA () {
        System.out.println("testA started");
        objectB.testB();
        System.out.println("testA finished");
    }

    @Override
    public void run() {
        testA();
    }
}
