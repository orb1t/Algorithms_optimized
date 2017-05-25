import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jerry on 19-05-2017.
 */
public class CicularDistance {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int r_0 = in.nextInt();
        int g = in.nextInt();
        int seed = in.nextInt();
        int p = in.nextInt();
//        int result = circularWalk(9, 2, 7, 1, 3, 4, 7);
        int result = circularWalk(n, s, t, r_0, g, seed, p);
        System.out.println(result);


    }

    static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p) {
        // Complete this function

        int[] R = computeRVector(r_0, n, g, seed, p);
        Map<Integer, Integer> map = new HashMap<>();
        boolean processed[] = new boolean[n];
        boolean visited[] = new boolean[n];
        return getDistance(s, t, map, R, processed, visited);
    }

    private static int[] computeRVector(int r_0, int n, int g, int seed, int p) {
        int R[] = new int[n];
        R[0] = r_0;
        for (int i = 1; i < n; i++) {
            R[i] = (R[i - 1] * g + seed) % p;
        }
        return R;
    }

    public static int getDistance(int source, int destination, Map<Integer, Integer> map, int R[], boolean processed[], boolean visited[]) {

        if (R[source] == 0) {
            map.put(source, -1);
            processed[source] = true;
            visited[source] = true;
            return -1;
        }

        if (visited[source])
            return -1;

        visited[source] = true;

        if (processed[source]) {
            Integer distance = map.get(source);
            if (distance != -1)
                return distance;
            else
                return -1;

        }


        int left = source - R[source];
        if (left < 0) {
            left = R.length + left;
            if (left <= destination && destination < R.length) {
                map.put(source, 1);
                return 1;
            }
        }

        int right = source + R[source];
        if (right >= R.length) {
            right = right - R.length;
            if (0 <= destination && destination <= right) {
                map.put(source, 1);
                return 1;
            }
        }

        if (left <= destination && destination <= source || source <= destination && destination <= right) {
            map.put(source, 1);
            return 1;
        }

        int min = Integer.MAX_VALUE;

        int index = source;
        int k = R[source];
        while (k-- > 0) {
            index--;
            if (index < 0)
                index = R.length + index;

            int localDistance = getDistance(index, destination, map, R, processed, visited);


//            if (localDistance == 1) {
//                return localDistance + 1;
//            }

            if (localDistance != -1)
                min = Math.min(min, localDistance + 1);

        }

        k = R[source];
        while (k-- > 0) {
            index++;

            if (index == R.length)
                index = 0;

            int localDistance = getDistance(index, destination, map, R, processed, visited);

        /*    if (localDistance == 1) {
                return localDistance + 1;
            }*/

            if (localDistance != -1)
                min = Math.min(min, localDistance + 1);

        }

        processed[source] = true;
        min = (min == Integer.MAX_VALUE) ? -1 : min;
        map.put(source, min);
return  min;
    }


}
