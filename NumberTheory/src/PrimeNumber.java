import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jerry on 10-08-2017.
 */
public class PrimeNumber {

    private static final int INITIAL_INDEX = 2;

    public static void main(String[] args) {
        System.out.println("isPrime: " + isPrime(10));
        getPrimeNumber(100);
    }

    private static boolean isPrime(int number) { // root of N : complexity

        if (number < INITIAL_INDEX)
            return false;

        for (int i = INITIAL_INDEX; i * i <= number; i++)
            if (number % i == 0)
                return false;
        return true;
    }

    private static void getPrimeFactors() {

    }

    private static List<Integer> getAllFactors(int number) {

        List<Integer> factors = new ArrayList<>();

        if (number < INITIAL_INDEX) {
            factors.add(number);
            return factors;
        }

        for (int i = INITIAL_INDEX; i * i <= number; i++) {
            if (number % i == 0) {
                factors.add(number / i);
                factors.add(i);
            }
        }
        return factors;
    }

    //Sieves of Erastones

    public static void getPrimeNumber(int number) {

        boolean sieves[] = new boolean[number + 1];

        for (int i = 2; i * i < number; i++) {
            if (!sieves[i])
                for (int j = 2 * i; j <= number; j += i) {
                    sieves[j] = true;
                }
        }

        //printing all primes
        for (int i = 2; i < number; i++) {
            if (!sieves[i])
                System.out.print(i + " ");
        }

    }


}
