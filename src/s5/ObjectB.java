package s5;

public class ObjectB extends Thread{

    private ObjectA objectA;

    public void setObjectA(ObjectA objectA) {
        this.objectA = objectA;
    }

    public synchronized void testB () {
        System.out.println("testB started");
        objectA.testA();
        System.out.println("testB finished");
    }

    @Override
    public void run() {
        testB();
    }
}
