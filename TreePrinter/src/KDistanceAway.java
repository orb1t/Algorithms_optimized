/**
 * Created by Jerry on 29-04-2017.
 */
public class KDistanceAway {

    public void printkDistanceDown(TreeNode root, int k) {

        if (root == null || k < 0)
            return;

        if (k == 0)
            System.out.println(root.data);


        printkDistanceDown(root.left,k-1);
        printkDistanceDown(root.right,k-1);

    }

    public void printkDistanceUp(TreeNode root){

    }

}
