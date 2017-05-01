/**
 * Created by Jerry on 29-04-2017.
 */
public class RightView {

    public void printRightView(TreeNode root) {

        if (root == null)
            return;

        System.out.println(root.data);

        if (root.right != null)
            printRightView(root.right);
        else if (root.left != null)
            printRightView(root.left);
    }
}
