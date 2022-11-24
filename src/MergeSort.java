import java.util.*;

/*
 * Purpose: Honors Data Structure and Algorithms Lab 10 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 11/22/22
 * Submitted:  11/22/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Lukas DeLoach
 * @version: 2022.22.11
 */
public class MergeSort
{
    static int[] data;
    static int comps =0;

    public static void main(String[] args)
    {
        setup(args);
        System.out.println("Initially: "+getContent());
        iterativeMergeSort();
        System.out.println("Sorted:    "+getContent());
        System.out.println("Performed "+comps+" item comparisons.\n\n");
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
     * Iterative method iterativeMergeSort()
     * Starts by comparing singletons placing them sorted into sub-sectioned containing two elements.
     * Then compares the subsectioned arrays sorting and merging them.
     * Calls upon the merge method*/
    public static void iterativeMergeSort() {
        int length = data.length;
        int[] temp = new int[length];
        for(int i = 1; i < length; i<<=1) {

            for(int j = 0; j<length; j+=2*i) {
                merge(data, temp, j, i);
            }
            data = temp;
            temp = new int[length];
        }
    } //end iterativeMergeSort


    /**
     * Merge method that will be used by iterativeMergeSort
     * Takes two arrays and takes elements from the source array and sorts/merges them into the destination array.
     */
    public static void merge(int [] source, int [] destination, int start, int len) {
        int s1 = start;
        int e1 = len+start > data.length ? data.length : len+start; //to ensure we do not go out of bounds
        int s2 = e1;
        int e2 = e1+len>data.length ? data.length : e1+len; //to ensure we do not got out of bounds
        int k = start;
        while(s1<e1&&s2<e2) {
            comps++;
            if(source[s1] <  source[s2]) {
                destination[k++] = source[s1++];
            }
            else {
                destination[k++] = source[s2++];
            }
        }
        while(s1<e1) {
            destination[k++] = source[s1++];
        }

        while(s2<e2) {
            destination[k++] = source[s2++];
        }
    }//end merge

    /**
     * Returns a StringBuilder objects of numbers in the collection
     * @return str -  StringBuilder object
     * */
    public static StringBuilder getContent () {
        //complete this method
        StringBuilder str = new StringBuilder();
        for(int num : data) {
            str.append(num + " ");
        }
        return str;
    }
} //end MergeSort
