/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphi;

import java.util.ArrayList;

/**
 *
 * @author Jerry
 */
public class graph {
    
    int vertex;
    ArrayList<Integer>al[];
    
    
    public graph(int v)   //given number of vertex
    {
    vertex=v;
    al=new ArrayList[v];
        
    for(int i=0;i<v;i++)  //create all array list 
    al[i]=new ArrayList<>();
    
    }
    
    
    public void insert(int v1,int v2)
    {
    al[v1].add(v2);
    al[v2].add(v1);
        
    }
    
   
    public void print_list()
   {
   for(int i=0;i<vertex;i++)
           System.out.println("   "+i+" "+al[i]);
   
   }
    
    
    
    
    
    
}
