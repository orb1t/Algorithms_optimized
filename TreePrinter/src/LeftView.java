/**
 * Created by Jerry on 29-04-2017.
 */
public class LeftView {

    public void printLeftView(TreeNode root) {

        if (root == null)
            return;

        System.out.println(root.data);

        if (root.left != null)
            printLeftView(root.left);
        else if (root.right != null)
            printLeftView(root.right);

    }

}
