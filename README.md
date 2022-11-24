Better sorting algorithms that run in O(nlog(n))

MergeSort developed iteratively. QuickSort developed recursively

QuickSort randomly picks pivot between indexes (1-array.length-1) but still could choose min or max in collection. This would bring the worst case of Quicksort and would run in O(n^2). 

Better way to implement quicksort is to randomly select 3 numbers from collection and find the median. Guaranteed not to hit worst case.

Instructions to run:

Compile: javac *.java
Run: java MergeSort.java 15 1 14 (Where 15 is amount of numbers and 1 -14 is the range)

To test on multiple input:

./testMergeSort or ./testQuickSort

open new txtfiles created to see results
