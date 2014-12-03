/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Jerry
 */
public class level_traversal {
       
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
    
    
}
