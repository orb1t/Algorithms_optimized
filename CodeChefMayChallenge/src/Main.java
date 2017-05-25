import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jerry on 06-05-2017.
 */
public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int testCases = scanner.nextInt();

            while (testCases-- > 0) {
                int len = scanner.nextInt();
            int length = 2 * len + 1;
            int A[] = new int[length];
            for (int i = 1; i < length; i++) {
                A[i] = scanner.nextInt();
            }

            Arrays.sort(A);
            int i = 2;
            /*int j = len + 1;
            while (i <= len) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i += 2;
                j += 2;
            }*/
                int median = getMedian(len, A);
                System.out.println(median);

                int j = length -1;
                while (i <= len) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    i += 2;
                    j -= 2;
                }


                for (int k = 1; k < length; k++) {
                    System.out.print(A[k]+" ");
                }

        }

    }

    private static int getMedian(int len, int[] a) {
        int median ;
        if (len % 2 == 0) {
            median = (a[len+len/2] + a[(len+len/2)+1])/2;

        } else {
             median = a[len+(len+1)/2];
        }
        return median;
    }
}
