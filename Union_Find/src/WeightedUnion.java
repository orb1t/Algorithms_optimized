/**
 * Created by Prit Sheth on 13-03-2017.
 */
public class WeightedUnion {

    private int id[];
    private int size[];

    public WeightedUnion(int length) {
        id = new int[length];
        size = new int[length];

        for (int i = 0; i < length; i++) {
            id[i] = i;
            size[i] = 1;
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

        id[a] = id[id[a]];
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

    private void weightedUnion(int a, int b) {
        int c = findRoot(a);
        int p = findRoot(b);
        if (size[c] <= size[p]) {
            id[c] = p;
            size[p] += size[c];
        } else {
            id[p] = c;
            size[c] += size[p];
        }
    }


    public static void main(String[] args) {

    }

}
