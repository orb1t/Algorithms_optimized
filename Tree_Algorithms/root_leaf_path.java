/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jerry
 */
public class root_leaf_path {
    
     public void root_leaf(node root,int path[],int plength)
   {
   
       if(root==null)
       return ;
       
       if(root!=null)
       path[plength++]=root.data;
       
       if(root.left==null&&root.right==null)
           printpath(path,plength);
       
       root_leaf(root.left, path, plength);
       root_leaf(root.right, path, plength);
       
       
   }
   
    public void printpath(int path[],int length)
    { System.out.println("-----------");
    for(int i=0;i<length;i++)
            System.out.println("-->"+path[i]);
    
    }  
    
    
}
