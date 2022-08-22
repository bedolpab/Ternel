using System;

namespace QuickSort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = { 10, 5, 6, 200, 3, 7, 9, 10 };
            QuickSort(array, 0, array.Length - 1);
            foreach (var n in a)
            {
                System.Console.Write(n + " ");
            }
        }
        static void QuickSort(int[] arr, int l, int h)
        {
            if (l < h)
            {
                int index = Partition(arr, l, h);
                QuickSort(arr, l, index - 1);
                QuickSort(arr, index + 1, h);
            }
        }

        static int Partition(int[] arr, int l, int h)
        {
            int pivot = arr[h];
            int k = l;
            while (l < h)
            {
                if (arr[l] <= pivot)
                {
                    Swap(arr, l, k);
                    k++;
                }
                l++;
            }
            Swap(arr, k, h);
            return k;
        }

        static void Swap(int[] arr, int i, int j)
        {
            var temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
