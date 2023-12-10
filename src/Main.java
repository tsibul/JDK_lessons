public class Main {
    public static void main(String[] args) {
        int[] array = {2, 5, 13, 7, 6, 4};
        System.out.println(intAve(array));
    }

    public static float intAve(int[] arr) {
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        return (float) arrSum / arr.length;
    }
}
