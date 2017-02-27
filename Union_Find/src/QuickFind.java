/**
 * Created by Prit Sheth on 23-02-2017.
 */
public class QuickFind {

    private int id[];

    public QuickFind(int length) {
        id = new int[length];

        for (int i = 0; i < length; i++) {
            id[i] = i;
        }
    }

    /**
     * This union method will take O(n) time for each union call.
     * @param a
     * @param b
     */
    public void union(int a, int b) {

        int oldParent = id[a];
        int newParent = id[b];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == oldParent)
                id[i] = newParent;
        }
    }

    /**
     * This will give you the parent of any element in constant time.
     * @param a
     * @return
     */
    public int find(int a) {
        return id[a];
    }

    /**
     * Constant time to check!!
     * @param source
     * @param destination
     * @return
     */
    public boolean isConnected(int source, int destination) {
        return id[source] == id[destination];
    }


    public static void main(String[] args) {

    }

}
