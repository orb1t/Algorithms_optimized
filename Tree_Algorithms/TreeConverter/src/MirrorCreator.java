/**
 * Created by Prit Sheth on 20-03-2017.
 */
public class MirrorCreator {

    public TreeNode createMirror(TreeNode root) {

        if (null == root)
            return null;

        createMirror(root.left);
        createMirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }

}
