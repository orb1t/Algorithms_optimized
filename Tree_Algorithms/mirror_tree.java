/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Prit Sheth
 */
public class mirror_tree {
     public void make_mirror(node root)//change itselft
    {
    if(root==null)
    return ;
    
        make_mirror(root.left);
        make_mirror(root.right);
    
    node temp=root.left;
    root.left=root.right;
    root.right=temp;
    
    }
    
    
   public node create_mirror(node root) 
   {
   if(root==null)
   return null;
   
   node root2=new node(root.data);
   root2.left=create_mirror(root.right);
   root2.right=create_mirror(root.left);
   
   return root2;
   }
    
   
   
        public boolean is_mirror(node root1,node root2)
    {
    
        if(root1==null&&root2==null)
            return true;
        
        
        if(root1!=null&&root2==null||root1==null&&root2!=null)
            return false;
        
        if(root1.data!=root2.data)
            return false;
        
    
    return is_mirror(root1.left,root2.right) && is_mirror(root1.right,root2.left);
    }
    
   
   
   
   
}
