import com.sun.deploy.util.ArrayUtil;

import java.util.Collections;

/**
 * Created by Jerry on 25-03-2017.
 */
public class SegmentTree {

    public static void main(String[] args) {
        int arr[] = new int[]{-1, 3, 4, 0, 2, 1};
        int segment[] = new int[15];

        constructMinimumSegmentTree(arr, segment, 0, arr.length - 1, 0);
        for (int i : segment) {
            System.out.println(i);

        }
    }

    /**
     * @param arr
     * @param segment
     * @param low
     * @param high
     * @param pos
     */
    public static void constructMinimumSegmentTree(int arr[], int segment[], int low, int high, int pos) {

        if (low == high) {
            segment[pos] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        int leftChildPosition = 2 * pos + 1;
        int rightChildPosition = 2 * pos + 2;

        constructMinimumSegmentTree(arr, segment, low, mid, leftChildPosition);
        constructMinimumSegmentTree(arr, segment, mid + 1, high, rightChildPosition);
        segment[pos] = getMinimum(segment[leftChildPosition], segment[rightChildPosition]);
    }

    public static void constructSumRangeSegmentTree(int arr[], int segment[], int low, int high, int pos) {

        if (low == high) {
            segment[pos] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        int leftChildPosition = 2 * pos + 1;
        int rightChildPosition = 2 * pos + 2;

        constructMinimumSegmentTree(arr, segment, low, mid, leftChildPosition);
        constructMinimumSegmentTree(arr, segment, mid + 1, high, rightChildPosition);
        segment[pos] = segment[leftChildPosition] + segment[rightChildPosition];
    }


    public int getRangeMinimumQuery(int segment[], int queryLow, int queryHigh, int low, int high, int pos) {
        //1) total overlap then return answer from segment
        if (queryLow <= low && high <= queryHigh)
            return segment[pos];

        //2) no overlap then return maximum value
        if (queryHigh < low || queryLow > high)
            return Integer.MAX_VALUE;

        //3) partial overlap then divide into two part

        int mid = (low + high) / 2;
        int leftRangeValue = getRangeMinimumQuery(segment, queryLow, queryHigh, low, mid, 2 * pos + 1);
        int rightRangeValue = getRangeMinimumQuery(segment, queryLow, queryHigh, mid + 1, high, 2 * pos + 2);
        return getMinimum(leftRangeValue, rightRangeValue);
    }

    public int getRangeSumQuery(int segment[], int queryLow, int queryHigh, int low, int high, int pos) {
        //1) total overlap then return answer from segment
        if (queryLow <= low && high <= queryHigh)
            return segment[pos];

        //2) no overlap then return maximum value
        if (queryHigh < low || queryLow > high)
            return Integer.MAX_VALUE;

        //3) partial overlap then divide into two part

        int mid = (low + high) / 2;
        int leftRangeValue = getRangeSumQuery(segment, queryLow, queryHigh, low, mid, 2 * pos + 1);
        int rightRangeValue = getRangeSumQuery(segment, queryLow, queryHigh, mid + 1, high, 2 * pos + 2);
        return (leftRangeValue + rightRangeValue);
    }


    private static int getMinimum(int i, int j) {
        return (i < j) ? i : j;
    }

     int nextPowerOf2( int n)
    {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;
        return n;
    }

}
