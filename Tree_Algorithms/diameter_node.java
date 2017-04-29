/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Prit Sheth
 */
public class diameter_node {

    public int max(int val1, int val2) {
        if (val1 > val2)
            return val1;
        else
            return val2;
    }


    public int Fheight(node root) //max height
    {
        if (root == null)
            return 0;

        return (1 + max(Fheight(root.left), Fheight(root.right)));
    }


    public int diameter(node root) {

        if (root == null)
            return 0;


        int lheight = Fheight(root.left);
        int rheight = Fheight(root.right);

        int ld = diameter(root.left);
        int rd = diameter(root.right);


        return max(1 + lheight + rheight, max(ld, rd));
    }


}
