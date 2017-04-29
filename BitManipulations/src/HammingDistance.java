/**
 * Created by Prit Sheth on 24-03-2017.
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int a1 = x & (1 << i);
            int a2 = y & (1 << i);
            if (a1 != a2)
                count++;
        }
        return count;
    }


    public static int hammingDistanceOptimized(int x, int y) {
        int count = 0;
        int ans = x ^ y;

        for (int i = 0; i < 32; i++) {
            if ((ans & (1 << i)) != 0)
                count++;
        }
        return count;
    }


    public static int toggled(int x) {

        for (int i = 0; i < 31; i++) {
          x ^= 1<<i;
        }
        return x;
    }

    /* Function to get no of set bits in binary
       representation of passed binary no. */
    int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = toggled(1);
        System.out.println(i);
    }
}
