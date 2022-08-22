using System;

namespace BinarySearch
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20 };
        }

        static int BinarySearch(int[] array, int n, int key)
        {
            // Safety check
            if (array == null | n == 0)
            {
                return -1;
            }

            int low = 0;
            int high = array.Length - 1;
            int midpoint = low + (high - low) / 2;

            while (low < high)
            {
                midpoint = low + (high - low) / 2;

                // Early exit
                if (key == array[low])
                {
                    return low;
                }
                else if (key == array[high])
                {
                    return high;
                }
                else if (key == array[midpoint])
                {
                    return midpoint;
                }

                // Search left half of array
                if (key < array[midpoint])
                {
                    high = midpoint - 1;
                }
                // Search right half of array 
                else
                {
                    low = midpoint + 1;
                }
            }
            return -1;
        }
    }
}
