/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphi;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jerry
 */
public class traversal {
    
    boolean visited[];
    int edgeTo[];
    
    
    traversal(int v)
    {
    
        visited=new boolean[v];
        edgeTo=new int[v];
        
    }
    
    
    
    public void print_path()
    {
    for(int i=0;i<edgeTo.length;i++)
            System.out.println(" "+i+" "+edgeTo[i]);
        
    }
    
    
    
    
    
    public void dfs(graph g,int v)
    {
    
    visited[v]=true;

                for(int i:g.al[v])
                {                 if(!visited[i])
                                    {dfs(g,i);
                                     edgeTo[i]=v;}
                }

    
    }
    
    
    
    public void bfs(graph g,int v)
    {
    
        Queue<Integer>q=new LinkedList<Integer>();
        
        q.add(v);
        visited[v]=true;
        
        
        while(!q.isEmpty())
        {
        
        int x=q.remove();
            System.out.println(" "+x);    
                for(int i:g.al[x])
                {
                   if(!visited[i])
                   {
                   q.add(i);
                   visited[i]=true;
                   edgeTo[i]=x;
                   }


                }
        
        
        }
        
        
    }
    
    
    
}
