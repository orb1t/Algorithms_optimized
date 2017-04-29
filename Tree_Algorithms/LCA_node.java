/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Prit Sheth
 */
public class LCA_node {


    public boolean covers(node root, node child) {
        if (root == null)
            return false;

        if (root.data == child.data)
            return true;


        return covers(root.left, child) || covers(root.right, child);


    }


    public node LCA(node root, node n1, node n2) {
        if (root == null)
            return null;

        if (covers(root.left, n1) && covers(root.left, n2))
            return LCA(root.left, n1, n2);

        if (covers(root.right, n1) && covers(root.right, n2))
            return LCA(root.right, n1, n2);


        return root;
    }


}
