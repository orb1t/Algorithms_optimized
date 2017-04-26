import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Jerry on 14-04-2017.
 */


public class Solution {


    public static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int a1;
        int b1;


        @Override
        public int compareTo(Edge o) {
            long x = this.a1 / this.b1;
            long y = o.a1 / o.b1;

            if (x == y) {
                if (this.a1 < o.a1)
                    return -1;
            }

            return (x > y) ? -1 : 0;

        }
    }

    private static int id[];
    private static int size[];


    public static void setup(int length) {
        id = new int[length];
        size = new int[length];

        for (int i = 0; i < length; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }


    public static void main(String[] args) {
        Set<Edge> edgeSet = new HashSet<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> adj[] = new List[n];
        setup(n);
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int m = in.nextInt();
        Edge edge[] = new Edge[m];
        for (int a0 = 0; a0 < m; a0++) {
            edge[a0] = new Edge();
            int u = in.nextInt();
            int v = in.nextInt();
            //to ignore self loops
            if (u == v) {
                in.nextInt();
                in.nextInt();
                continue;
            }

            edge[a0].source = u;
            edge[a0].destination = v;

            //Creating edge in adj matrix
            adj[u].add(v);
            edgeSet.add(edge[a0]);

            int a = in.nextInt();
            int b = in.nextInt();

            edge[a0].a1 = a;
            edge[a0].b1 = b;


            // Write Your Code Here
        }
        Arrays.sort(edge);
        getFraction(n, edge);
        for (Edge edge1 : edge) {
            System.out.println(edge1.a1 + " " + edge1.b1);
        }


    }


    /**
     * This union method will take O(n) time for each union call.
     *
     * @param a
     * @param b
     */
    public static void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        id[rootA] = rootB;
    }

    /**
     * This will give you the parent of any element in O(n) time.
     *
     * @param a
     * @return
     */
    public static int findRoot(int a) {

        if (id[a] == a)
            return a;

        id[a] = id[id[a]];
        return findRoot(id[a]);
    }

    public static void createGraph(int vertex, Edge edges[]) {

    }

    public static boolean isConnected(int source, int destination) {
        return findRoot(source) == findRoot(destination);
    }


    public static void getFraction(int vertex, Edge edges[]) {
        ArrayList<Edge> result = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];

            if (!isConnected(edge.source, edge.destination)) {
                union(edge.source, edge.destination);
                result.add(edge);
            }
        }

        long up = 0;
        long down = 0;
        for (Edge edge : result) {
            up += edge.a1;
            down += edge.b1;
        }

        System.out.println(asFraction(up,down));
    }

    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    public static String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

}
