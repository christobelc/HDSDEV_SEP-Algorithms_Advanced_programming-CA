import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 * this java implementation is based from original code at:  https://stackoverflow.com/questions/34783815/java-recursive-mergesort-for-arraylists/34825244
 */

public class MergeSort<T extends Comparable<? super T>> {

    // We try and get the middle index and create two temporary arrays left and
    // right. The mergeSort method is then called recursively for both the
    // sub-arrays:
    public void mergeSort(List<T> input) {
        if (input.size() != 1) {
            // two arrays for left and right
            List<T> left = new ArrayList<T>();
            List<T> right = new ArrayList<T>();
            boolean lSwitch = true;
            // Arrange the left and right arrays
            while (!input.isEmpty()) {
                if (lSwitch) {
                    left.add(input.remove(0));
                } else {
                    right.add(input.remove(0));
                }
                lSwitch = !lSwitch;
            }
            // sort left and right
            mergeSort(left);
            mergeSort(right);
            input.addAll(merge(left, right));
        }
    }

    // The merge function compares the elements of the left and right arraylists one
    // by one and
    // places the smaller element into the input array. When we reach the end of one
    // of the sub-arrays, the rest of the elements from the other array are copied
    // into the input array thereby giving us the final sorted array:
    private List<T> merge(List<T> left, List<T> right) {
        List<T> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            // Initial index of merged subarry array
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                // copy elements of left if any
                merged.add(left.remove(0));
            } else {
                // copy elements of right if any
                merged.add(right.remove(0));
            }
        }
        // add the elements from left and right
        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }
}