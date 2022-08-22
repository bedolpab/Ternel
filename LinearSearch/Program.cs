using System;

namespace LinearSearch
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 7, 11, 5, 1 };
            Console.WriteLine(Search(arr, 5));
        }
        static bool Search(int[] arr, int n)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] == n)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
