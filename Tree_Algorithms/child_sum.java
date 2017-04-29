/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Prit Sheth
 */
public class child_sum {
    
    
    
    
    public boolean child_sum(node root)
    {
    
    if(root==null || root.left==null && root.right==null)
        return true;
    
    if(root.right==null)
        return root.data==root.left.data &&  child_sum(root.left);//go for leftt
    
    else if(root.left==null)
        return root.data==root.right.data &&  child_sum(root.right);
    
    else
        return (root.data==root.left.data+root.right.data) &&  child_sum(root.left)&&child_sum(root.right);
    
    
    }
    
    
}
