/**
 * Created by Jerry on 21-08-2017.
 */
public class StringFromPreorder {
    String answer = "";

    public String tree2str(TreeNode t) {

        if (t == null)

            System.out.println(t.data);
        tree2str(t.left);
        tree2str(t.right);

    }
}
