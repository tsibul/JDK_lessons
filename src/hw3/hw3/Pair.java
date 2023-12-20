package hw3.hw3;

//Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
//Класс должен иметь методы getFirst(), getSecond() для получения значений каждого
//из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары.

public class Pair <T1, T2>{
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + getFirst().toString() + ", " + getSecond().toString() + ")";
    }
}
