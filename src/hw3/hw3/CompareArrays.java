package hw3.hw3;

public class CompareArrays {
    public static <T1, T2> boolean compareArrays(T1 [] arr1, T2 [] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        if (arr1Length != arr2Length) {
            return false;
        }
        for(int i = 0; i < arr1Length; i++){
           if(!arr1[i].getClass().equals(arr2[i].getClass())){
               return false;
           }
        }
        return true;
    }
}
