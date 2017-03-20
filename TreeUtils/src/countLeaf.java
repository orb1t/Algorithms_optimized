/**
 * Created by Jerry on 19-03-2017.
 */
public class countLeaf {

    /**
     * Size of the tree, Total nodes of the tree
     * @param treeNode
     * @return
     */
    public int countNodes(TreeNode treeNode) {
        if (null == treeNode) return 0;
        return countNodes(treeNode.left) + countNodes(treeNode.right) + 1;
    }


}
