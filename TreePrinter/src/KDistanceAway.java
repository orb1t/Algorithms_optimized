/**
 * Created by Jerry on 29-04-2017.
 */
public class KDistanceAway {

    public void printkDistanceDown(TreeNode root, int k) {

        if (root == null || k < 0)
            return;

        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        printkDistanceDown(root.left, k - 1);
        printkDistanceDown(root.right, k - 1);

    }

    public void printkDistanceUp(TreeNode root, TreeNode target, int K) {
        getDistanceFromTargetNode(root, target, K);
    }

    public int getDistanceFromTargetNode(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return 0;


        int leftResult = getDistanceFromTargetNode(root.left, target, k);
        if (leftResult != 0) {
            if (leftResult == k) {
                System.out.println(root.data);
                return -1;
            }
            printkDistanceDown(root.right, k - leftResult - 1);
            return ++leftResult;
        }

        int rightResult = getDistanceFromTargetNode(root.right, target, k);
        if (rightResult != 0) {
            if (rightResult == k) {
                System.out.println(root.data);
                return -1;
            }
            printkDistanceDown(root.left, k - rightResult - 1);
            return ++rightResult;
        } else if (root.data == target.data) {
            printkDistanceDown(root, k);
            return 1;
        }
        return 0;
    }

}
