import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class BinarySearch {

    public BinarySearch() {
    }

    // O(logn) binary search algorithim
    public int binarySearch(ArrayList<Employee> arr, String searchKey) {
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = searchKey.compareTo(arr.get(m).getFirstName());
            // Check if x is present at mid
            if (res == 0) {
                return m;
            }
            // If x greater, ignore left half
            if (res > 0) {
                l = m + 1;
            }
            // If x is smaller, ignore right half
            else {
                r = m - 1;
            }
        }
        return -1;
    }

    // linear search upper and lower bound index search algorithim
    public int[] upperLowerBound(ArrayList<Employee> employees, int searchIndex, String searchKey) {

        // find the lower and upperbound indexes of the searched item
        int upperbound, lowerbound;
        upperbound = lowerbound = searchIndex;
        if (searchIndex != -1) {
            try {
                // iterate to find the upperbound index
                while (employees.get(upperbound + 1).getFirstName().equals(searchKey)) {
                    upperbound++;
                }
                // iterate to find the lowerbound index
                while (employees.get(lowerbound - 1).getFirstName().equals(searchKey)) {
                    lowerbound--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        // copy and return arrays of the upper and lower bound indexes
        int[] upperLowerBound = new int[2];
        upperLowerBound[0] = lowerbound;
        upperLowerBound[1] = upperbound;
        return upperLowerBound;
    }
}