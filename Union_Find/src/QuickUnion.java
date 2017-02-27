/**
 * Created by Jerry on 23-02-2017.
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

        int child = find(a);
        int newParent = find(b);
        if (child == newParent)
            return;
        id[child] = newParent;

    }

    /**
     * This will give you the parent of any element in O(n) time.
     *
     * @param a
     * @return
     */
    public int find(int a) {

        if (id[a] == a)
            return a;

        return find(id[a]);
    }

    /**
     * Constant time to check!!
     *
     * @param source
     * @param destination
     * @return
     */
    public boolean isConnected(int source, int destination) {
        return find(source) == find(destination);
    }


    public static void main(String[] args) {

    }


}
