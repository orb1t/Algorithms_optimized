/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphi;

/**
 *
 * @author Prit Sheth
 */
public class Graphi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        graph g=new graph(5);
        g.insert(0, 1);g.insert(0, 2);
        g.insert(1, 2);g.insert(1, 3);
        g.insert(2, 3); g.insert(2, 4);
        g.insert(3, 4);
        
        
        g.print_list();
        
        
        traversal t1=new traversal(5);
        t1.bfs(g, 0);
        
        //t1.print_path();
        
        
        
    }
    
}
