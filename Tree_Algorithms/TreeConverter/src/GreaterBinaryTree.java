/**
 * Created by Jerry on 20-08-2017.
 */
public class GreaterBinaryTree {

    public TreeNode convertBST(TreeNode root) {
int sum = 0;
//        covertRoot(root);
        return root;
    }

    public int getRoot(TreeNode root, int value,int direction) {

        if(root == null)
            return 0;

        int right = getRoot(root.right, value,1);

        root.data = (direction==1)?  right + root.data: value+root.data;
        getRoot(root.left, root.data,0);
        return root.data;

    }

}
