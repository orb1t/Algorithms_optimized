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
public class connecting_node {
    
    
    //level wise linked lsit
    
    
    
    public void connect_level(node root)
    {
        if(root==null)
            return ;
    
        if(root.left!=null)
        {
        
              if(root.right!=null)
              root.left.next=root.right;
              else
              root.left.next=find_next(root.next);
            
            
        }
       
        if(root.right!=null)
     root.right.next=find_next(root.next);
        
        connect_level(root.left);
        connect_level(root.right);
        
        
    }
    
    
    public node find_next(node root)
    {
    if(root==null)
        return null;
    if(root.left!=null)
        return root.left;
    else if(root.right!=null)
      return root.right;
    
    
    else
       return find_next(root.next);
    
    }
  
      
    //---method to check previous node ------and making inorder connection
    static node pre=null;
    node head=pre;
    public void inorder_connection(node root)   //classic method of inorder--visited previous node..
    {  
        if(root!=null)
        {
     inorder_connection(root.left);
     pre.right=root;
     pre=root;
     
     inorder_connection(root.right);
        } 
        
    }  
    //pre order flattern
    
     public void flatten(node root) {   //we have to use reversee pre order to do that other wise storing right pointer wud be difficult
        
         if(root==null)return;
       
      
           flatten(root.right);
          flatten(root.left);
         //if(pre!=null)
         
      root.right=pre;
       root.left=null;
         
     pre=root;
    
    
    }
    
    
    
    
    
    
    
    
    static node prev=null;
    public void treetoDLL(node root,node head)
    { 
        if(root==null)
            return ;
        
        
        treetoDLL(root.left, head);
        
        if(prev==null)
            head=root;
        else
        { root.left=prev;
        prev.right=root;
        } 
        
          prev=root; 
          
        treetoDLL(root.right, head);
        
     
        
    
    //return head;
    
    } 
    
       
    public void print_prev(node root)
    { //pre.right=null; //making perfect linked list(commented for flattern function)
     while(root!=null)
     {  System.out.println("  --"+root.data);
    root=root.right;
     
     }}
    
    
    //inorder linked list...flattern
    public void populate_next(node root)  //innext(evenv can be done by right link) is link of getting inorder connectionn--its also done by reverse inorder
    {
    
        if(root!=null)
        {
     populate_next(root.left);
     pre.right=root;
     pre=root;
     
     populate_next(root.right);
        } 
          
    
    
    }
    
   //  static node pre1=null;
    
   
    
    
}
