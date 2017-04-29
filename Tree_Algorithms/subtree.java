/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Prit Sheth
 */
public class subtree {
      public Boolean isSub(node root1,node root2)
    {  
     if(root1==null) 
         return false;
     
     
     if(root2==null)   //checking for root2 if it is null..then null is subtree of root t1
         return true;
     
     if(isidentical(root1,root2))
         return true;
     
     return   isSub(root1.left, root2)||isSub(root1.right, root2);
        
    
    }
   // int flag=0;
    public Boolean isidentical(node root1,node root2)
    {

        
        if(root1==null && root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        
    if(root1.data!=root2.data)
    { 
        return false;
    }
       return  isidentical(root1.left, root2.left) && isidentical(root1.right, root2.right);
    
    
    }
    
}
