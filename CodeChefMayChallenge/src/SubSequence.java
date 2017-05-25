import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jerry on 08-05-2017.
 */
public class SubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long K = scanner.nextLong();

        long A[] = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        Arrays.sort(A);
        int x = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > K)
                break;
            x++;
        }
        long B[] = new long[x];
        for (int i = 0; i < x; i++) {
            B[i] = A[i];
        }
//20  0 to 9 10
        long firstHalf[];
        long secondHalf[];
        if (x % 2 == 0) {
            firstHalf = new long[x / 2];
            secondHalf = new long[x / 2];

            for (int i = 0; i < x / 2; i++) {
                firstHalf[i] = B[i];
                secondHalf[i] = B[(x / 2) + i];
            }
        } else {

            firstHalf = new long[(x / 2) + 1];
            secondHalf = new long[x / 2];

            for (int i = 0; i <= x / 2; i++) {
                firstHalf[i] = B[i];
                if (((x / 2) + 1) + i != x) secondHalf[i] = B[((x / 2) + 1) + i];
            }

        }

        List<Long> firstSubSet = getAllSubsets(K, firstHalf.length, firstHalf);
        List<Long> secondSubSet = getAllSubsets(K, secondHalf.length, secondHalf);

        Long[] product1 = firstSubSet.toArray(new Long[firstSubSet.size()]);
        Long[] product2 = secondSubSet.toArray(new Long[secondSubSet.size()]);
        Arrays.sort(product1);
        Arrays.sort(product2);

        int index = product1.length + product2.length;

        for (int i = 0; i < product2.length; i++) {
            int total = getIndex(product1, product2[i], K);
            if (total == -1)
                break;
            index = index + total + 1;
        }

        System.out.println(index);
    }

    private static int getIndex(Long[] product1, Long value, Long K) {
        int low = 0;
        int high = product1.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if ((product1[mid] <= (K / value) && mid + 1 < product1.length && product1[mid] > (K / value)) || (product1[mid] <= (K / value) && mid == product1.length - 1))
                return mid;
            if (product1[mid] == (K / value)) {
                low = mid + 1;
            }
            if (product1[mid] > (K / value))
                high = mid - 1;
            else if (product1[mid] < (K / value))
                low = mid + 1;

        }

        return -1;
    }

    private static List<Long> getAllSubsets(long k, int x, long[] b) {
        List<Long> result = new ArrayList<>();

        for (int i = 1; i < 1 << x; i++) {
            long temp = 1;
            for (int j = 0; j < x; j++) {

                int m = i & 1 << j;
                if ((m) != 0) {
                    if (b[j] != 0 && temp > Long.MAX_VALUE / b[j]) {
                        temp = k + 2;
                        break;
                    }
                    temp *= b[j];
                }
                if (temp > k) {
                    break;
                }
            }
            if (temp <= k)
                result.add(temp);

        }
        return result;
    }
}
