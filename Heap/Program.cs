using System;
using System.Linq;
using System.Collections.Generic;

namespace Heap
{
    class Program
    {
        static void Main(string[] args)
        {
            var list = new List<int>() { 9, 11, 18, 13, 15, 14, 8, 12, 10, 4, 6, 3, 7};
            Viewlist(list);
            System.Console.WriteLine("");
            Viewlist(HeapSort(list));
        }
        static List<int> HeapSort(List<int> list)
        {
            List<int> sorted = new List<int>(new int[list.Count]);
            if (sorted.Count == 0)
            {
                return sorted;
            }
            BuildMinHeap(list);
            for (int i = 0; i < sorted.Count; i++)
            {
                sorted[i] = DeleteMin(list);
            }
            return sorted;
        }
        static void BuildMinHeap(List<int> list)
        {
            if (list.Count == 0)
            {
                return;
            }
            for (int i = list.Count - 1; i >= 0; i--)
            {
                int L = 2 * i + 1;
                int R = 2 * i + 2;

                if (R > list.Count - 1 && L > list.Count - 1)
                {
                    continue;
                }
                else if (R > list.Count - 1)
                {
                    if (list[i] > list[L])
                    {
                        Swap(list, i, L);
                        SiftDown(list, L); 
                    }
                }
                else if (L > list.Count - 1)
                {
                    if (list[i] > list[R])
                    {
                        Swap(list, i, R);
                        SiftDown(list, R);
                    }
                }
                else if (list[i] > list[R] || list[i] > list[L])
                {
                    if (list[R] < list[L])
                    {
                        Swap(list, i, R);
                        SiftDown(list, R);
                    }
                    else if (list[L] < list[R])
                    {
                        Swap(list, i, L);
                        SiftDown(list, L);
                    }
                }
            }
        }
        static void Update(List<int> list, int i, int newValue)
        {
            if (newValue < list[i])
            {
                list[i] = newValue;
                SiftUp(list, i);
            }

            if (newValue > list[i])
            {
                list[i] = newValue;
                SiftDown(list, i);
            }
        }
        static int DeleteMin(List<int> list)
        {
            if (list.Count == 0)
            {
                return -1;
            }
            int smallestElement = GetMin(list);
            Swap(list, 0, list.Count - 1);
            list.RemoveAt(list.Count - 1);
            SiftDown(list, 0);
            return smallestElement;
        }
        static int GetMin(List<int> list)
        {
            if (list.Count >= 0)
            {
                return list[0];
            }
            else
            {
                return -1;
            }
        }
        static void Insert(List<int> list, int i)
        {
            list.Add(i);
            SiftUp(list, list.Count - 1);
        }

        static void SiftUp(List<int> list, int i)
        {
            int parent = (i - 1) / 2;
            while (i != 0 && list[i] < list[parent])
            {
                Swap(list, i, parent);
                i = parent;
                parent = (i - 1) / 2;
            }
        }
        static void SiftDown(List<int> list, int i)
        {
            int L = 2 * i + 1;
            int R = 2 * i + 2;
            while (L < list.Count && list[i] > list[L] || R < list.Count && list[i] > list[R])
            {
                if (list[R] < list[L])
                {
                    Swap(list, i, R);
                    i = R;
                }
                else if (list[L] < list[R])
                {
                    Swap(list, i, L);
                    i = L;
                }
                L = 2 * i + 1;
                R = 2 * i + 2;
            }
        }
        static void Swap(List<int> list, int i, int j)
        {
            var temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }
        static void Viewlist(List<int> list)
        {
            for (int i = 0; i < list.Count; i++)
            {
                System.Console.Write(list[i] + " ");
            }
        }
    }
}
