/**
 * Created by Prit Sheth on 23-02-2017.
 */
public class QuickUnion {

    private int id[];

    public QuickUnion(int length) {
        id = new int[length];

        for (int i = 0; i < length; i++) {
            id[i] = i;
        }
    }

    /**
     * This union method will take O(n) time for each union call.
     *
     * @param a
     * @param b
     */
    public void union(int a, int b) {

        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA == rootB)
            return;
        id[rootA] = rootB;

    }

    /**
     * This will give you the parent of any element in O(n) time.
     *
     * @param a
     * @return
     */
    public int findRoot(int a) {

        if (id[a] == a)
            return a;

        return findRoot(id[a]);
    }

    /**
     * Constant time to check!!
     *
     * @param source
     * @param destination
     * @return
     */
    public boolean isConnected(int source, int destination) {
        return findRoot(source) == findRoot(destination);
    }

    public static void main(String[] args) {

    }


}
