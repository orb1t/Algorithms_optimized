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
public class construct_tree {
    
    
    public node buildTree(int[] preorder, int[] inorder) {
        return build(inorder,preorder,0,inorder.length-1);
    }
    
    public int find_index(int k,int in[],int low,int high)
    {
        
        for(int i=low;i<=high;i++)
            if(k==in[i])
            return i;
            
        return -1;
    }
    
    int pre_index=0;
    public node build(int in[],int pre[],int in_low,int in_high)
    {
        
        if(in_low>in_high)
        return null;
        
        
        node root=new node(pre[pre_index++]);
        int index=find_index(root.data,in,in_low,in_high);
        
        root.left=build(in,pre,in_low,index-1);
        root.right=build(in,pre,index+1,in_high);
        
        
        
        
        return root;
    }
    
        //construct tree from traversal...
    public node maketree(int a[],int low,int high)  //from sorted array convert it to tree
    {
        if(low>high)
            return null;
        
        int mid=(low+high)/2;
        node root=new node(a[mid]);
        root.left=maketree(a,low,mid-1);
        root.right=maketree(a,mid+1,high);
        
return root;
    }
    
 int post_index;
    public node buildTree1(int[] inorder, int[] postorder) {
        post_index=inorder.length-1;
        return build1(inorder,postorder,0,inorder.length-1);
    }
    
    
    public int find_index1(int k,int in[],int low,int high)
    {
        
        for(int i=low;i<=high;i++)
            if(k==in[i])
            return i;
            
        return -1;
    }
    
    
    public node build1(int in[],int pre[],int in_low,int in_high)
    {
        
        if(in_low>in_high)
        return null;
        
        
        node root=new node(pre[post_index--]);
        int index=find_index1(root.data,in,in_low,in_high);
        
         root.right=build1(in,pre,index+1,in_high);
        root.left=build1(in,pre,in_low,index-1);
       
        
        
        
        
        return root;
    }
   
    
    
    
    
    
}
