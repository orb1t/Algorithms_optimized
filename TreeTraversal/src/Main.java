/**
 * Created by Jerry on 20-03-2017.
 */
public class Main {


    /**
     *           0
     *      1          2
     * 3       4     5  6
     *  7    8     9
     *
     *
     */


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);
        TreeNode root9 = new TreeNode(9);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        root5.left = root9;
        root3.right = root7;
        root4.left = root8;

LevelOrderRunner levelOrderRunner = new LevelOrderRunner();
        levelOrderRunner.traverse(root);


    }





}
