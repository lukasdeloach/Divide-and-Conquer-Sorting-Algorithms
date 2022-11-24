import java.util.Random;
/*
 * Purpose: Honors Data Structure and Algorithms Lab 10 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 11/22/22
 * Submitted:  11/22/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Lukas DeLoach
 * @version: 2022.22.11
 */
public class QuickSort {

    static int[] data;
    static int comps = 0;
    static int swaps = 0;
    public static void main(String[] args)
    {
        setup(args);
        System.out.println("Initially: "+getContent());
        quickSort(data, 0, data.length-1);
        System.out.println("Sorted:    "+getContent());
        System.out.println("Number of comparisons: " + comps);
        System.out.println("Number of swaps: " + swaps);
    } //end main

    public static void setup( String[] args) {
        Random rand = new Random();
        int nums = Integer.parseInt(args[0]), low = Integer.parseInt(args[1]), high = Integer.parseInt(args[2]);
        data = new int[nums];
        for(int i = 0; i < nums; i++) {
            data[i] = (rand.nextInt(high-low) + 1);
        }
    } //end setup

    /**
     * Recursive method quickSort that calls upon the partition method and itself twic. After partitioning, recursively sorts both sides before and after pivot.*/
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivIndex = partition(arr, low, high);
            quickSort(arr, low, pivIndex-1);
            quickSort(arr, pivIndex+1, high);
        }
    }

    /**
     * Partition method that is used in quicksort method.
     * First, treats base case - if range of input is less than 3 compares the two elements and swaps accordingly.
     * Then chooses a pivot at random - could improve this by picking median of 3 numbers.
     *Then iterates through collection and makes comparisons/swapping.
     * Next, checks index i, to see if there are any numbers smaller than the pivot.
     * @return low - pivot index that will be used in quickSort
     * */
    private static int partition(int[] arr, int low, int high) {
        if(high-low<2) {
            comps++;
            if(arr[low]>arr[high]) {
               swap(arr, low, high);
                swaps++;
		System.out.println("hereh");
            }
        }
        else {
            int pivIndex = new Random().nextInt(high-low)+low;
            int pivot = arr[pivIndex];
            if(pivIndex!=low) {
                swap(arr, low, pivIndex);
                swaps++;
            }

            int i = low+1;

            for(int j = low+1; j < high+1; j++) {
                comps++;
                if(arr[j] < pivot) {
                    swap(arr, j, i);
                    swaps++;
                    i++;
                }
            }

            if(i>1) {
                swaps++;
                swap(arr, low, i-1);
            }
            low = i-1;
        }
	System.out.println(getContent());
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static StringBuilder getContent () {
        //complete this method
        StringBuilder str = new StringBuilder();
        for(int num : data) {
            str.append(num + " ");
        }
        return str;
    }
}
