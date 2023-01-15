
/*
 * Binary Search implemented in java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        // This is ugly but it is for easy visuals
        array.add(9);
        array.add(11);
        array.add(18);
        array.add(13);
        array.add(15);
        array.add(14);
        array.add(8);
        array.add(12);
        array.add(10);
        array.add(4);
        array.add(6);
        array.add(3);
        array.add(7);
        ViewList(array);
        ViewList(HeapSort(array));

    }

    public static List<Integer> HeapSort(List<Integer> arr){
        List<Integer> sorted = new ArrayList<Integer>(arr.size());
        for(int i = 0; i < arr.size(); i++){
            sorted.add(0);
        }
        if(sorted.size() == 0){
            return sorted;
        }
        BuildMinHeap(arr);

        for(int i = 0; i < sorted.size(); i++){
            sorted.set(i, DeleteMin(arr));
        }
        return sorted;
    }

    public static void BuildMinHeap(List<Integer> arr){
        if(arr.size() == 0){
            return;
        }
        for(int i = arr.size() - 1; i >= 0; i--){
            int L = 2 * i + 1;
            int R = 2 * i + 2;

            if(R > arr.size() - 1 && L > arr.size() - 1){
                continue;
            }
            else if(R > arr.size() - 1){
                if(arr.get(i) > arr.get(L)){
                    Swap(arr, i , L);
                    SiftDown(arr, L);
                }
            }
            else if(L > arr.size() - 1){
                if(arr.get(i) > arr.get(R)){
                    Swap(arr, i ,R);
                    SiftDown(arr, R);
                }
            }
            else if(arr.get(i) > arr.get(R) || arr.get(i) > arr.get(L)){
                if(arr.get(R) < arr.get(L)){
                    Swap(arr, i, R);
                    SiftDown(arr, R);
                }
                else if (arr.get(L) < arr.get(R)){
                    Swap(arr, i , L);
                    SiftDown(arr, L);
                }
            }
        }
    }

    public static void Update(List<Integer> arr, int i , int newValue){
        if (newValue < arr.get(i)) {
            arr.set(i, newValue);
            SiftUp(arr, i);
        }

        if(newValue > arr.get(i)){
          arr.set(i, newValue);
          SiftDown(arr, i);
        }
    }
    public static int DeleteMin(List<Integer> arr){
        if(arr.size() == 0){
            return -1;
        }
        int smallestElement = GetMin(arr);
        Swap(arr, 0, arr.size() - 1);
        arr.remove(arr.size()-1);
        SiftDown(arr, 0);
        return smallestElement;
    }

    public static int GetMin(List<Integer> arr){
        if(arr.size() >= 0){
            return arr.get(0);
        }
        else{
            return -1;
        }
    }

    public static void Insert(List<Integer> arr, int i){
        arr.add(i);
    }

    public static void SiftUp(List<Integer> arr, int i){
        int parent = (i - 1) / 2;
        while(i != 0 && arr.get(i) < arr.get(parent)){
            Swap(arr, i, parent);
            i = parent;
            parent = (i-1)/2;
        }
    }

    public static void SiftDown(List<Integer> arr, int i){
        int L = 2 * i + 1;
        int R = 2 * i + 2;
        while(L < arr.size() && arr.get(i) > arr.get(L) || R < arr.size() && arr.get(i) > arr.get(R)){
            if(arr.get(R) < arr.get(L)){
                Swap(arr, i ,R);
                i = R;
            }
            else if (arr.get(L) < arr.get(R)){
                Swap(arr, i ,L);
                i = L;
            }
            L = 2 * i + 1;
            R = 2 * i + 2;
        }

    }

    public static void Swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void ViewList(List<Integer> arr){
        StringBuilder str = new StringBuilder();
        for(int n: arr){
            str.append(n);
            str.append(" ");
        }
        System.out.println(str);
        str.setLength(0);
    }



}
