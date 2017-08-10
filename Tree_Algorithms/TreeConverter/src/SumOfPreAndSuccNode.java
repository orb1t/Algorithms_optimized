/**
 * Created by Jerry on 11-08-2017.
 */
public class SumOfPreAndSuccNode {

    // Update tree with sum of pre order node and successor node
    //http://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor/

    public void updateTreeWithSum(TreeNode root){

        updateNodeWithInorderSum(root,root,root);

    }

    private void updateNodeWithInorderSum(TreeNode root, TreeNode left, TreeNode right) {

    }


}
