import java.util.*;

/**
 * Created by Jerry on 26-08-2017.
 */
public class LargestNumberDivBy3 {

    public static void main(String[] args) {
        System.out.println(getLargestNumberDivisibleBy3(new int[]{8, 7, 6, 1, 0}));
    }

    public static int getLargestNumberDivisibleBy3(int nums[]) {

        List<Integer> answer = new ArrayList<>();

        Arrays.sort(nums);
        Queue<Integer> q2 = new LinkedList();
        Queue<Integer> q1 = new LinkedList();
        int sum = 0;

        for (int num : nums) {
            if (num % 3 == 0)
                answer.add(num);

            else if (num % 3 == 1)
                q1.add(num);

            else if (num % 3 == 2)
                q2.add(num);
            sum += num;
        }

        if (sum % 3 == 2) {
            if (!q2.isEmpty()) //remove number who has remainder of 2 when divided by 3
                q2.remove();
            else if (q1.size() >= 2) {
                q1.remove();
                q1.remove();
            } else
                return 0;

        } else if (sum % 3 == 1) {
            if (!q1.isEmpty()) //remove number who has remainder of 1 when divided by 3
                q1.remove();
            else if (q2.size() >= 2) {
                q2.remove();
                q2.remove();
            } else
                return 0;
        }

        // building answer while emptying queue
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q1.isEmpty()) answer.add(q1.remove());
            if (!q2.isEmpty()) answer.add(q2.remove());
        }

        Collections.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        int result = 0;
        for (Integer a1 : answer) {
            result *= 10;
            result += a1;
        }
        return result;
    }

    public static int answer(int[] l) {
        return getLargestNumberDivisibleBy3(l);
    }
}
