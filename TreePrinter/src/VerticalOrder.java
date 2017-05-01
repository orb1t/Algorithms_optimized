import java.util.*;

/**
 * Created by Jerry on 29-04-2017.
 */
public class VerticalOrder {


    public void printVerticalOrder(TreeNode root) {
        Map<Integer, List<TreeNode>> verticalMap = new TreeMap<>();
        getVerticalView(root, 0, verticalMap);
        for (Integer integer : verticalMap.keySet()) {
            System.out.print(integer+" - ");
            List<TreeNode> treeNodes = verticalMap.get(integer);
            for (TreeNode treeNode : treeNodes) {
                System.out.print(treeNode.data+" ");
            }
            System.out.println();
        }

    }

    public void getVerticalView(TreeNode root, int distance, Map<Integer, List<TreeNode>> verticalMap) {

        if (root == null)
            return;

        if (!verticalMap.containsKey(distance)) {
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(root);
            verticalMap.put(distance, nodes);
        } else {
            List<TreeNode> treeNodes = verticalMap.get(distance);
            treeNodes.add(root);
            verticalMap.put(distance, treeNodes);
        }

        getVerticalView(root.left, distance - 1, verticalMap);
        getVerticalView(root.right, distance + 1, verticalMap);
    }


}
