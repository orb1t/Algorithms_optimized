/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treenode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Jerry
 */
public class node {
    int data;
    node left;
    node right;
    node innext;
    node parent;
    node random;
    node next;
    boolean visited;
    int level;
    
    node(int data)
    {
    this.data=data;
    left=right=random=null;
    }
    
    //clone it----1)using hahsmap and other using left link
    
    public node clone(node root)
    {
    
        copy_left(root);//it will genrate copy of it
        clone_map(root);//it will fix the random pointer
    node save=root.left;
        restore_clone(root,root.left);
    
return save;        
    }
    
    public void restore_clone(node tree_node,node clone_root) //not right
    {
    if(tree_node==null||tree_node.left==null||clone_root==null)
        return;
        
    if(clone_root.left!=null) 
    { node save=clone_root.left.left;
    tree_node.left=tree_node.left.left;
    clone_root.left=save;
        
    }
    else
     tree_node.left=null;
    
    
        restore_clone(tree_node.left, clone_root.left);
        restore_clone(tree_node.right, clone_root.right);
    
    }
    
    public node clone_map(node root)
    {
    
        if(root==null)
        return null;
        
        
        if(root.left!=null&&root.random!=null)
        root.left.random=root.random.left;
    //root.left=root.left.left;
    
    
        clone_map(root.left.left);
        clone_map(root.right);
    
    
    return root;
    }
    
    public node copy_left(node root) //perfect
    {
    if(root==null)
    return null;
    
    node temp=root.left;
    node root1=new node(root.data);
    root.left=root1;
    root1.left=temp;
    
        copy_left(root.left.left);
        
 
    root.left.right = copy_left(root.right);
    return root.left;
        
        
    
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
    
    
    
     //make tree from level order and in order
    
    public int find_index(int arr[],int k,int strt,int end)
    { int index=-1;
    for(int i=strt;i<=end;i++)
    if(arr[i]==k)
        index=i;
    
    return index;
    }
    
    
    int level_index=0;
    public node make_inlevel(int level[],int in[],int strt,int end)//nnot completed
    {
        if(level_index>=level.length)return null;
        
        node root=new node(level[level_index++]);
        
    if(strt==end)
        return root;
        
     if(strt>end)   
         return null;
     
     
     int index=find_index(in, root.data, strt, end);
     
     root.left=make_inlevel(level, in, strt, index-1);
     root.right=make_inlevel(level, in, index+1,end);
     
     
     return root;
     
    }
    //http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
    
    int side=0;int diff=0;
    int dist_root=0;
    
    
    
    
    public void find_diff(node root,node temp,int s,int level)
    {
        if(root==null)
        return;
        
        if(root==temp)
        {
        dist_root=level;
        side=s;
        }
    
        find_diff(root.left, temp, 1,level+1);
        find_diff(root.right, temp, 2,level+1);
    
    
    }
    //not completed
    public void kdist_away(node root,node temp,int k,int level)
    {
    
    if(root==null)
    return;
    
    if(level==k)
            System.out.println(" "+root.data);
    
        kdist_away(root, temp.left, k,level+1);
        kdist_away(root, temp.right, k,level+1);
    
    
    
    }
    
  //  public void kdist_up(node root,node temp)
    
    
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
    
    //for getting vertical print 
        
        int min_hd=Integer.MAX_VALUE,max_hd=Integer.MIN_VALUE;
        
        public void cal_HD(node root,int hd) //to calculate min height and max height
        {
         
            if(root==null)
        return;
            
            if(hd<min_hd)
        min_hd=hd;
            if(hd>max_hd)
        max_hd=hd;
            
            
            
            cal_HD(root.left,hd-1);
        cal_HD(root.right,hd+1);
        }
        
        
        
        
       
         public void printvert(node root)  //both vert down and vert up   also using hashmap
        {
        for(int line=min_hd;line<=max_hd;line++)    
        print_vertup(root,line,0);
        }
        
          public void printvert_sum(node root)  //both vert down and vert up for vertical sum
        {
        for(int line=min_hd;line<=max_hd;line++)    
        { sum1=0;   
            System.out.println("  " +print_vertsum(root,line,0,0));}
        }
        
         
        public void print_vertup(node root,int line,int hd)   //in upward direction
        {
        
            if(root==null)
        return;
      print_vertup(root.left,line,hd-1);
        print_vertup(root.right,line,hd+1);
        
       
        if(line==hd)
        System.out.println(" "+root.data);
        
        }
        
        
        public void print_vertdown(node root,int line,int hd)  //downwards
        {
        
            if(root==null)
        return;
      
       
        if(line==hd)
        System.out.println(" "+root.data);
        
          print_vertdown(root.left,line,hd-1);
        print_vertdown(root.right,line,hd+1);
        
        
        
        }
      int sum1=0;
      
        public int print_vertsum(node root,int line,int hd,int sum)  //downwards
        {
        
            if(root==null)
        return 0;
      
        if(line==hd)
             sum1=sum1+root.data;
        
        
        print_vertsum(root.left,line,hd-1,sum1);
        print_vertsum(root.right,line,hd+1,sum1);
        
        
       
        return sum1;
        }
        
        
        //end of vertical print
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
    
    
    
 //normal traverse using stack wihtout recursion---------------------------------------------
    
    
    public void stk_preorder(node root)
    { 
        
    
        Stack<node> s1=new Stack<node>();
        s1.push(root);
        
        while(!s1.empty())
        {
        node temp=s1.peek();
            System.out.println("--> "+temp.data);
            s1.pop();
            
          if(temp.right!=null)
          {s1.push(temp.right);}
          
          if(temp.left!=null)
          {s1.push(temp.left);}
            
          
          
        }
        
    }
            
    public void stk_inorder(node root)
    { 
        Stack<node> s1=new Stack<node>();
        s1.push(root);
        
        while(!s1.empty())
        {
        node temp=s1.peek();
             if(!temp.visited)
            
             { 
                  temp.visited=true;
                  
                  s1.pop();
                  
                        if(temp.right!=null)
                          {s1.push(temp.right);}
                          
                         s1.push(temp);

                          if(temp.left!=null)
                          {s1.push(temp.left);}

             }  
             
             
             else
             System.out.println("--> "+s1.pop().data);
          
        }
        
        
        
        
        
    }
    
   public void stk_postorder(node root)         
   {
   Stack<node> s1=new Stack<node>();
   s1.push(root);
 
   
        while(!s1.empty())
        {
        node temp=s1.peek();
             if(!temp.visited)
            
             { 
                  temp.visited=true;
                        if(temp.right!=null)
                          {s1.push(temp.right);}


                          if(temp.left!=null)
                          {s1.push(temp.left);}

             }  
             
             
             else
             System.out.println("--> "+s1.pop().data);
          
        }
        
   
   
   
   
   }        
    
   public void postorder_visit(node root) //not using visited property but using another stack
   {
       
       Stack<node> s1=new Stack<node>();
       Stack<Boolean> flag=new Stack<Boolean>();
   s1.push(root);
   flag.push(false);
 
   
        while(!s1.empty())
        {
        node temp=s1.peek();
             if(!flag.peek())
            
             {   
                 flag.pop();
                 flag.push(true);
                  //temp.visited=true;
                        if(temp.right!=null)
                          {s1.push(temp.right);
                          flag.push(false);
                           }


                          if(temp.left!=null)
                          {s1.push(temp.left);
                           flag.push(false);}

             }  
             
             
             else
             { flag.pop();
             System.out.println("--> "+s1.pop().data);
             }
        }
        
   
   
       
       
   
   }
   
   
   
   
   ///end of stack traversal 
       
    public int Fheight(node root) //max height
    {
    if(root==null)
        return 0;
    
    return(1+max(Fheight(root.left),Fheight(root.right)));
      }
    
      public int mindepth(node root)  //min height
    {
    if(root==null)
        return 0;
    
    
    return(1+min(mindepth(root.left),mindepth(root.right)));
        
    
    }
    
    
    
    public int maxsum(node root) //not completed//not right...refer leet codes
    { 
        if(root==null)
            return 0;
    int left=maxsum(root.left);
    int right=maxsum(root.left);
    
    
    return (max(left, right)+root.data);
    
    
    }
    
   
    // traversal----------------------all ---types---------------------------------------------------------
    
    
   
    public void printLevel(node root) //level order traversal using queue
 {
        Queue<node> s1=new LinkedList<node>();
    s1.add(root);
    
            while(!s1.isEmpty())
            {
            node temp=s1.remove();
                System.out.println(" "+temp.data);

                if(temp.left!=null)
                s1.add(temp.left);

                 if(temp.right!=null)
                s1.add(temp.right);
            }
 }
     
    public void zigzag(node root)
    {
    Stack<node> s1=new Stack();
    Stack<node> s2=new Stack();
    
    s1.add(root);
    while(!s1.isEmpty()||!s2.isEmpty())
    {
    
                while(!s1.isEmpty())
                {
                node temp=s1.pop();
                    System.out.println("  "+temp.data);

                    if(temp.left!=null)
                            s2.add(temp.left);

                             if(temp.right!=null)
                            s2.add(temp.right);



                }

        
            while(!s2.isEmpty())
            {
            node temp=s2.pop();
                System.out.println("  "+temp.data);

                
                   if(temp.right!=null)
                        s1.add(temp.right);


                
                if(temp.left!=null)
                        s1.add(temp.left);

                      

            }

        
    
    
    
    }
        
    
    }
    
    
    public void revlevel(node root)
    {
     Queue<node> que=new LinkedList<node>();
    Stack<node> s1=new Stack();
    
    que.add(root);
    
            while(!que.isEmpty())
            {
            node temp=que.remove();
              s1.add(temp);
            //System.out.println(" "+temp.data);

                
                 if(temp.right!=null)
                que.add(temp.right);
                 
                if(temp.left!=null)
                que.add(temp.left);

            }
    
    while(!s1.isEmpty())
     System.out.println(" "+s1.pop().data);   
        
    
    
    
    }
    
    
     public void printLeftView(node root) //level order traversal using queue
 {
        Queue<node> s1=new LinkedList<node>();
    s1.add(root);
    
            while(!s1.isEmpty())
            {
            node temp=s1.remove();
                System.out.println(" "+temp.data);

                if(temp.left!=null)
                s1.add(temp.left);

                else if(temp.right!=null)
                s1.add(temp.right);
            }
            
 }
   
    
    
    //for online coding shud return
    public List<List<Integer>> leveOrder(node root) {
   
    List<List<Integer>> result = new ArrayList<>();
    
    int odd=0;
            int even=0;
    for(int i=0;i<result.size();i++)
    {
    if(i%2==0)
    {
   for(Integer j:result.get(i))
   {System.out.println(" "+j);
       odd=odd+j;}
    }
    else
    {
    
    for(Integer j:result.get(i))
    
    {even=even+j;
    System.out.println(" "+j);}
    }
    
        System.out.println(" odd is"+odd+"even is"+even);
        
    }
    
    
    List<node> level = new ArrayList<>(); //kind of temp...
    level.add(root);
    
    while(true){
        if (level.isEmpty() || level.get(0) == null){
            break;
        }
        List<node> nextLevel = new ArrayList<>();  //for each level;
        List<Integer> currentLevel = new ArrayList<>();

        for (node node : level){ 
            currentLevel.add(node.data);
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
        }
        result.add(currentLevel);
        level = nextLevel;
    }
    return result;
} 
    
    
    
    
    
     public  List<List<Integer>> levelOrder(node root) {
    
        
        
        
        return null;
    }
    
    
    
   
    public node leftmost(node root)   
    {
        
        if(root==null)
        return null;
    
        if(root.left==null)
            return root;
    
    while(root.left!=null)
        root=root.left;
    
    return root;
    
    }
            
  
    public int min(int val1,int val2)   // root=1 and root.left=2...mid depth sud be 2
    { if(val1==0)  //reson and analysis...in min of both 0 will alwz return dats y
        return val2;
    if(val2==0)
        return val1;
    if(val1>val2)
    return val2;
    else 
        return val1;
    }
   
    
    public int max(int val1,int val2)
    {
    if(val1>val2)
    return val1;
    else
        return val2;
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
    
    
    
    public Boolean isbal(node root) //wrong output  //corner cases for 1---right---2---right---3...wrong out put..
    {  
        if(root==null)
        return true;
        int x=Fheight(root)-mindepth(root);
        
        System.out.println("diff is "+x);
    return(x<=1);
    
        
    
    }
    
    
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
    
    
    
    
    
    
    
    
    
 // static int maxsum=0;
    
    public int maxsumPath(node root,int maxum[]) //wrong
    { 
        if(root==null)
            return 0;
        
//Input:	{2,-1}   
//Output:	1
//Expected:	2
        
  //      Input:	{1,-2,3}
//Output:	3
//Expected:	4

        
        
        int left=maxsumPath(root.left,maxum);
        int right=maxsumPath(root.right,maxum);
        int cursum;
        if(root.left==null&&root.right==null)//corner case if only one node =-3 then wrong ans =0 dats y
        cursum=root.data;
        else
        cursum=max(left+right+root.data,max(left,right));   //corner case here we have to consider left sum and right sum also
        if(cursum>maxum[0])maxum[0]=cursum;
        
        
        return (root.data+max(left,right)); 
    
    
    }
    
    public int findmaxsum(node root) //wrong
    {
    int max[]={Integer.MIN_VALUE};
        maxsumPath(root, max);
        return max[0];
    
    }
    
    
    public int diameter(node root)
    {
    
        if(root==null)
            return 0;
        
        
        int lheight=Fheight(root.left);
        int rheight=Fheight(root.right);
        
    int ld=diameter(root.left);
    int rd=diameter(root.right);
    
    
    
    
    
    return max(1+lheight+rheight,max(ld,rd));
    }
    
    
    public boolean covers(node root,node child)
    {
    if(root==null)
        return false;
    
    if(root.data==child.data)
        return true;
    
    
    return covers(root.left,child)||covers(root.right,child);
    
    
    }
    
    
    public node LCA(node root,node n1,node n2)  //not efficient ..
    {  
        if(root==null)
            return null;
        
        if(covers(root.left,n1)&&covers(root.left,n2))
            return LCA(root.left,n1,n2);
        
        if(covers(root.right,n1)&&covers(root.right,n2))
            return LCA(root.right,n1,n2);
        
           
        return root;
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
    
public int kdist_leaf(node root)    
{

    
return 0;
}
    
public node buildTree(int in[],int pre[],int instrt,int inend)
{


return null;
}

    
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
    
 
   //-----------------------------new codes-------------
    
    
    
    
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
    
     public boolean isskewed(node root)
    {
        
        if(root.left!=null)
        return false;
       
    return true&&isskewed(root.right);
        
    }
    
    
    
     public void flatten(node root) {   //we have to use reversee pre order to do that other wise storing right pointer wud be difficult
        
         if(root==null)return;
       
      
           flatten(root.right);
          flatten(root.left);
         //if(pre!=null)
         
      root.right=pre;
       root.left=null;
         
     pre=root;
    
    
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
    
     static node pre1=null;
    
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
    
   
   public void doubleit(node root)
   {
   if(root==null)
       return;
   
   
   node temp=root.left;
   node n1=new node(root.data);
   root.left=n1;
   n1.left=temp;
   
   
   doubleit(root.left.left);
   doubleit(root.right);
   
   
   
   }
   
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
    //page 6
    
    //http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
  public node makeheap_in(int in[],int instart,int inend)
  {
  if(instart>inend)
  return null;
  
  int index=find_max(in,instart,inend);
  node root=new node(in[index]);
  
  
  if(instart==inend)
  return root;
  
 
  root.left=makeheap_in(in, instart, index-1);
  root.right=makeheap_in(in,index+1,inend);
  
  return root;
  
  }
  
  public int find_max(int in[],int instart,int inend)
  {int maxi=instart;  
  for(int i=instart;i<=inend;i++)
  {
  if(in[maxi]<in[i])
  maxi=i;
  
  } 
  return maxi;
  }
  
    
  
  public node maketree_pre(int pre[],int pflag[],int strt,int end)
  {
  if(strt>end)return null;
  node root=new node(pre[strt]);
  if(pflag[strt]==1)
  {
  
  if(pflag[strt+1]==1)
  {  
  int index=find_lastleaf(pflag,strt,end);
  root.left=maketree_pre(pre, pflag, strt+1, index);
  
  root.right=maketree_pre(pre, pflag,index+1,end);
  }
      
  else
  {
  root.left=new node(pre[strt+1]);
      root.right=new node(pre[strt+2]);
  
  }  
      
      
  }
  
  return root;
  }
  
  public int find_lastleaf(int pflag[],int strt,int end)
  {  int index=strt;
      for(int i=0;i<=end;i++)
      { if(pflag[i]==0)
          index=i;
      }
      return index;
  }
   
  //practice of all the codes ...lets start...
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}



