package hw3;


import hw3.hw3.Calc;
import hw3.hw3.CompareArrays;
import hw3.hw3.Pair;

public class Main {
    public static void main(String[] args) {
//        Pair <String, Integer> pair = new Pair<>("John", 26);
//        System.out.println(pair.toString());

//        Integer [] ar1 =  {1, 2, 3, 4, 5, 12};
//        Float [] ar2 =  { 6f, 7f, 8f, 9f, 10f};
//        System.out.println(CompareArrays.compareArrays(ar1, ar2));

        System.out.println(Calc.sum(5, 6) + " " + Calc.sum(5, 6).getClass().getName());
        System.out.println(Calc.sum(5, 6f) + " " + Calc.sum(5, 6f).getClass().getName());
        System.out.println(Calc.sum(5, 6L) + " " + Calc.sum(5, 6L).getClass().getName());
        System.out.println(Calc.sum(5, 6.0) + " " + Calc.sum(5, 6.0).getClass().getName());
        System.out.println(Calc.divide(5, 0));
        System.out.println(Calc.divide(5, 0L));

    }
}