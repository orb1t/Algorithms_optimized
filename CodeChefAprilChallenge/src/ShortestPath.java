import java.util.*;

/**
 * Created by Prit Sheth on 16-04-2017.
 */
public class ShortestPath {


    public static class Edge {
        int source;
        int destination;
        long weight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0) {

            String[] values = in.nextLine().split(" ");
            //total cities
            int N = Integer.valueOf(values[0]);

            //old cities
            int K = Integer.valueOf(values[1]);
            for (int i = 1; i <= K; i++) {

            }

            int totalOldRoads = (K * (K - 1)) / 2;
            //length of all old roads.
            int X = Integer.valueOf(values[2]);
            // all new roads.
            int M = Integer.valueOf(values[3]);
            //source city
            int S = Integer.valueOf(values[4]);

            List<Edge> adj[] = new List[N + 1];
//            Edge edges[] = new Edge[totalOldRoads + M];

            for (int i = 1; i <= N; i++)
                adj[i] = new ArrayList<>();

            while (M > 0) {
                int u = in.nextInt();
                int v = in.nextInt();
                int dist = in.nextInt();
                Edge e = new Edge();
                e.source = u;
                e.destination = v;
                e.weight = dist;
                adj[u].add(e);
                M--;
            }


            int distTo[] = new int[N + 1];
            boolean visited[] = new boolean[N + 1];

            for (int i = 0; i <= N; i++) {
                distTo[i] = Integer.MAX_VALUE;
            }


            testCases--;
        }  // Write Your Code Here
    }
}



