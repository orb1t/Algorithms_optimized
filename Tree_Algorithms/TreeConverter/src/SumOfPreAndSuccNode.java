/**
 * Created by Jerry on 11-08-2017.
 */
public class SumOfPreAndSuccNode {

    // Update tree with sum of pre order node and successor node
    //http://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor/

    public void updateTreeWithSum(TreeNode root) {
        TreeNode pre = new TreeNode(0);
        updateNodeWithInorderSum(root, pre);

    }

    private void updateNodeWithInorderSum(TreeNode root, TreeNode pre) {

        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        updateNodeWithInorderSum(root.left, pre);
        int temp = pre.data;
        pre.data += root.data;
        root.data = temp;
        pre = root;
        updateNodeWithInorderSum(root.right, pre);

    }


}
