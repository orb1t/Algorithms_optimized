/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Prit Sheth
 */
public class traversal {
    
    //-----------------------------normal traversal using recursion  -------------------------------------     
    public void  itraverse(node root)
    {
        if(root==null)
        return ;
    
        itraverse(root.left);
        System.out.println("  "+root.data);
        itraverse(root.right);
        
    }
    
    
    public void  pretraverse(node root)
    {
    
    if(root==null)
        return ;
     System.out.println("  "+root.data);
        itraverse(root.left);
        
        itraverse(root.right);
        
    }
    
    
    
    public void  posttraverse(node root)
    {
    
    if(root==null)
        return ;
    
        itraverse(root.left);
        
        itraverse(root.right);
        System.out.println("  "+root.data);
        
    }
    
    
  //------end of normal traverse using recursion
    
    
    
    
    
}
