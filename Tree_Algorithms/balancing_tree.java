/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jerry
 */
public class balancing_tree {
    
     public int max(int val1,int val2)
    {
    if(val1>val2)
    return val1;
    else
        return val2;
    }
  
    
    
     public int Fheight(node root) //max height
    {
    if(root==null)
        return 0;
    
    return(1+max(Fheight(root.left),Fheight(root.right)));
      }
    
    
    
    public boolean isBalanced(node root) {
       int lh; /* for height of left subtree */
   int rh; /* for height of right subtree */ 
 
   /* If tree is empty then return true */
   if(root == null)
    return true; 
 
   /* Get the height of left and right sub trees */
   lh = Fheight(root.left);
   rh = Fheight(root.right);
 
   if( Math.abs(lh-rh) <= 1 &&
       isBalanced(root.left) &&
       isBalanced(root.right))
     return true;
 
   /* If we reach here then tree is not height-balanced */
   return false;

        
    }
}
