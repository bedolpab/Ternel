
/*
 * Merge sort implemented in java
 * StringBuilder is used for performance enhancement
 */

public class Program {
    public static void main(String[] args) {
        int[] array = { 9, 3, 7, 5, 6, 4, 8, 2, 10, 12 };
        MergeSort(array, 0, array.length - 1);

        StringBuilder str = new StringBuilder();
        for (int n: array) {
            str.append(n);
            str.append(" ");
        }

        System.out.println(str.toString());
    }

    public static void MergeSort(int[] arr, int l, int r){
        if (l < r){
            int midpoint = l + (r-l)/ 2;
            MergeSort(arr, l, midpoint);
            MergeSort(arr, midpoint+1, r);
            Merge(arr, l, midpoint, r);
        }
    }
    public static void Merge(int[] arr, int l, int m, int r){
        int[] L = new int[m];
        int[] R = new int[(r-m) + 1];
        int i = 0;
        int j = 0;
        int k = 0;
        for(i = 0; i < m; i++){
            L[i] = arr[i];
        }
        for(j = 0; j < (r-m+1); j++){
            R[j] = arr[m+j];
        }
        i = 0;
        j = 0;
        while(i < m && j < (r-m+1)){
            if (L[i] < R[j]){
                arr[k++] = L[i++];
            }
            else{
                arr[k++] = R[j++];
            }
        }
        while(i < L.length){
            arr[k++] = L[i++];
        }
        while (j < R.length){
            arr[k++] = R[j++];
        }
    }

}
