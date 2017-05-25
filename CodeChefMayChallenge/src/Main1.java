import java.util.Scanner;

/**
 * Created by Jerry on 07-05-2017.
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int length = scanner.nextInt();
            int course[] = new int[length];
            for (int i = 0; i < length; i++) {
                course[i] = scanner.nextInt();
            }

            System.out.println(course.length - getMax(course));

        }
    }


    private static int getMax(int[] course) {
        int max = 0;
        for (int i = 0; i < course.length; i++) {
            if (max < course[i]) max = course[i];
        }
        return max;
    }

    private static int getMaximum(int[] course) {

        boolean visited[] = new boolean[course.length + 1];

        for (int i = 0; i < course.length; i++) {
            visited[course[i]] = true;
        }
        int counter = 0;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i])
                counter++;
        }
        return counter;
    }
}
