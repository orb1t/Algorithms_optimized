/**
 * Created by Prit Sheth on 19-03-2017.
 */
public class countLeaf {

    /**
     * Size of the tree, Total nodes of the tree
     *
     * @param treeNode
     * @return
     */
    public int countNodes(TreeNode treeNode) {
        if (null == treeNode) return 0;
        return countNodes(treeNode.left) + countNodes(treeNode.right) + 1;
    }

    public int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.data;

        int min1 = getMinimum(root);
        int min2 = getSecondMinimum(root, min1);

        return min2-min1;
    }


    public int getMinimum(TreeNode root) {

        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.data;

        int leftMin = getMinimum(root.left);
        int rightMin = getMinimum(root.right);

        int a = (leftMin < rightMin) ? leftMin : rightMin;
  return (root.data < a) ? root.data : a;
    }

    public int getSecondMinimum(TreeNode root, int min) {

        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.data;


        int leftMin = getSecondMinimum(root.left,min);
        int rightMin = getSecondMinimum(root.right,min);

        if(leftMin == min) return rightMin;
        else if(rightMin == min)return leftMin;
        else
        return (leftMin < rightMin) ? leftMin : rightMin;
    }



}
