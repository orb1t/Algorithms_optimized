import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Prit Sheth on 11-02-2017.
 */
public class LevelOrderRunner implements TraversalRunner {


    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        answer.add((double) root.data);
        int child = 0, parent = 1, divisor = 1;
        double sum = 0;
        while (queue.isEmpty()) {

            TreeNode node = queue.remove();
            sum += node.data;
            parent--;

            if (node.left != null) {
                queue.add(node.left);
                child++;
            }

            if (node.right != null) {
                queue.add(node.right);
                child++;
            }

            //next level
            if (parent == 0) {
                parent = child;
                divisor = child;
                answer.add(sum / divisor);
            }

        }
return answer;
    }


    @Override
    public void traverse(TreeNode root) {

        Queue queue = new LinkedList<TreeNode>();
        queue.add(root);
        int parent = 1, child = 0;

        while (!queue.isEmpty()) {

            TreeNode temp = (TreeNode) queue.remove();
            System.out.print(temp.data);
            if (temp.left != null) {
                child++;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                child++;
                queue.add(temp.right);
            }


            parent--;
            if (parent == 0) {
                System.out.println();
               /* if(!queue.isEmpty()){
                    TreeNode answer = (TreeNode)(queue.peek());
                   System.out.println(answer.data);}*/
                parent = child;
                child = 0;

            }


        }

    }
}
