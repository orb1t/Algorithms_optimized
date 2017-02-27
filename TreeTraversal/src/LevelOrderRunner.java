import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jerry on 11-02-2017.
 */
public class LevelOrderRunner implements TraversalRunner {


    public static void main(String[] args) {

    }

    @Override
    public void traverse(TreeNode root) {

        Queue queue = new LinkedList<TreeNode>();
        queue.add(root);
        int parent = 1, child = 0;

        while (!queue.isEmpty()) {

            TreeNode temp = (TreeNode)queue.remove();

            if(temp.left!=null)
            {
                child++;
                queue.add(temp.left);
            }

            if(temp.right!=null)
            {
                child++;
                queue.add(temp.right);
            }


            parent --;
            if(parent == 0){

                if(!queue.isEmpty()){
                    TreeNode answer = (TreeNode)(queue.peek());
                    System.out.println(answer.data);}
                parent = child;
                child = 0;

            }




        }

    }
}
