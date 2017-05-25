import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int P = scanner.nextInt();


        Integer data[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextInt();
        }

        String query[] = new String[P];
        query = scanner.next().split(" ");


        for (int i = 0; i < P; ) {
            if (query[0].charAt(i) == '?') {
                System.out.println(getMaximumCount(data, K));
                i++;
            } else {
                int totalRead = 0;
                while (i < P && query[0].charAt(i) != '?') {
                    totalRead++;
                    i++;
                }
                Collections.rotate(Arrays.asList(data), totalRead);

            }
        }
    }

    private static void rotateArray(int[] data, int i) {
        int last = data[data.length - 1];
        int temp = 0;
//        data[0] = last;
        for (int j = 0; j < data.length; j++) {
            temp = data[j];
            data[j] = last;
            last = temp;
        }
    }


    private static int getMaximumCount(Integer data[], int K) {
       /* int[] values = new int[data.size()];
        ListIterator listIterator = data.listIterator();
        int x = 0;
        while (listIterator.hasNext() && x <= data.size() - K) {
            for (int i = 0; i < K; i++) {
                
            }
 
            int next = (Integer) listIterator.next();
            values[x] = next;
            x++;
        }*/


        int max = 0;
        int temp = 0;
        for (int i = 0; i <= data.length - K; i++) {

            for (int j = i; j < i + K; j++) {
                if (data[j] == 1)
                    temp++;
            }

            if (max < temp)
                max = temp;
            temp = 0;

        }
        return max;
    }
}
 