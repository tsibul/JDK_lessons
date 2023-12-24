package s3;

import java.io.DataInput;
import java.io.InputStream;

//public class Main {
//    public static void main(String[] args) {
//        T_1<String, Integer, Float> t_1 = new T_1<>("Один", 1, 1f);
//        t_1.showTypes();
//    }
//}

/**
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K),
 * конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трех переменных.
 * <p>
 * Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа:
 * T должен реализовать интерфейс Comparable,
 * V должен реализовать интерфейс DataInput и расширять класс InputStream,
 * K должен расширять класс Number.
 */
class T_1<T extends Comparable<T>, V extends InputStream & DataInput,K extends Number> {

    T first;
    V second;
    K third;

    public T_1(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public void showTypes() {
        System.out.println(first.getClass().getName());
        System.out.println(second.getClass().getName());
        System.out.println(third.getClass().getName());
    }

    //region геттеры
    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }
    //endregion
}


//Описать собственную коллекцию – список на основе массива.
//Коллекция должна иметь возможность хранить любые типы данных, иметь методы добавления и удаления элементов.

public class MyCollection<T> {
    private Object[] myCollection = new Object[20];
    private int collLength;

    public void putElement(T t) {
        if (collLength == myCollection.length) {
            Object[] newCollection = new Object[collLength + 20];
            System.arraycopy(myCollection, 0, newCollection, 0, collLength);
            myCollection = newCollection;
        }
        myCollection[collLength++] = t;
    }

    public void removeElement(int index) {
        if (index < collLength && index >= 0) {
            for (int i = index; i < collLength - 1; i++) {
                myCollection[index] = myCollection[index + 1];
            }
//            myCollection[collLength] = null;
            collLength--;
        }
    }

}

//Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа,
//содержащим любые типы данных. Итераторы обычно имеют только два метода – проверка на наличие
//следующего элемента и переход к следующему элементу. Но также, особенно в других языках программирования,
//возможно встретить итераторы, реализующие дополнительную логику.


//public class MyIterator<T> implements Iterator<T> {
//
//    List<T> collection;
//    int iter;
//
//    public MyIterator(List<T> collection) {
//        this.collection = collection;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return iter < collection.size();
//    }
//
//    @Override
//    public T next() {
//        return collection.get(iter++);
//    }
//}