using System;
using System.Collections;

namespace SumOfTwoValues
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = { 3, 4, 5, 4, 1, -2, 5 };
            Console.WriteLine(SumExists(numbers, 4));
        }
        static bool SumExists(int[] array, int value)
        {
            Hashtable values = new Hashtable();
            for (int i = 0; i < array.Length; i++)
            {
                values.Add(i, array[i]);
                if (values.ContainsValue(value - array[i]))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
