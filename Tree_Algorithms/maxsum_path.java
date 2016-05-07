/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jerry
 */
public class maxsum_path {
    
    
   private int maxpathsum = Integer.MIN_VALUE;

    public int maxPathSum(node root){  //right method for maximmum path sum
        if (root == null)
            return maxpathsum;
        maxPathSumhelper(root);
        return maxpathsum;
    }

    private int maxPathSumhelper(node root) {
        int leftmax, rightmax;
        if (root.left == null && root.right == null){
        if (root.data > maxpathsum)
            maxpathsum = root.data;
            return root.data;
        }

        if (root.left != null)
            leftmax = maxPathSumhelper(root.left);
        else
            leftmax = 0;
        if (root.right != null)
            rightmax = maxPathSumhelper(root.right);
        else
            rightmax = 0;

        int localmax = max(root.data, root.data + leftmax, root.data + rightmax);
        if (localmax > maxpathsum)
            maxpathsum = localmax;
        if (root.data + leftmax + rightmax > maxpathsum)
            maxpathsum = root.data + leftmax + rightmax;
        return localmax;
    }

    
     private int max(int a, int b, int c){
    if (a >= b && a >=c)
        return a;
    else if (b>=c)
        return b;
    else
        return c;
    }  
    
    
}
