import java.util.Arrays;

/**
 * Created by Jerry on 22-08-2017.
 */
public class CoinChange {

    public static int getMin(int coins[], int target) {

        int dp[] = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

       /* for (int i : dp) {
            System.out.println("" + i);
        }*/
        return target;
    }

    public static void main(String[] args) {
        getMin(new int[]{1, 3, 5}, 10);
    }
}
