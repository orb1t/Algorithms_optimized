/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treenode;



/**
 *
 * @author Jerry
 */
public class verify_BST {
    
     public boolean isValidBST(node root) {
     
         return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
         
    }
    
    
     
      public boolean isValidBST(node root,int min,int max)
      {
      if(root==null)
          return true;
      
      
      if(min>root.data || root.data>max)
      return false;
     
      
      boolean l=isValidBST(root.left, min, root.data);
      
      if(l!=true)return false;
      
      boolean r=isValidBST(root.left, min, root.data);
      
      
          return l&&r;
      
      }
    
      
      static  node pre1=null;
       public boolean isBST(node root)
    {
        
       
        
       if(root==null)
        return true;
        
    boolean l= isBST(root.left);
     if(l==false)return false;
    
     if(pre1!=null&&pre1.data>=root.data)
    
     {  System.out.println("  pre data"+pre1.data+"root data"+root.data);
         System.out.println("entered");
         return false;
     }
     
     pre1=root;
     
    boolean r= isBST(root.right);
    
    return l&&r;
     
    }    
      
      
      
      
    
    
    
}
