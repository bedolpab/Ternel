import java.util.Hashtable;

/*
 * Quicksort implemented in java
 * StringBuilder is used for performance enhancement
 */
public class Program {
    public static void main(String[] args) {
        int[] array = { 10, 5, 6, 200, 3, 7, 9, 10 };
        QuickSort(array, 0, array.length - 1);

        StringBuilder str = new StringBuilder();
        for (int n: array) {
            str.append(n);
            str.append(" ");
        }

        System.out.println(str.toString());
    }

    public static void QuickSort(int[] arr ,int l, int h){
        if(l < h){
            int index = Partition(arr, l, h);
            QuickSort(arr, l, index-1);
            QuickSort(arr, index + 1, h);
        }
    }

    public static int Partition(int[] arr, int l, int h){
        int pivot = arr[h];
        int k = l;
        while(l < h){
            if (arr[l] <= pivot){
                Swap(arr, l, k);
                k++;
            }
            l++;
        }
        Swap(arr, k, h);
        return k;
    }

    public static void Swap(int[] arr, int i, int j){
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
