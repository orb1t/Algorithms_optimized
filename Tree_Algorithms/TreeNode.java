/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jerry
 */
public class TreeNode {

    /**
     *            0
     *        1       2
     *     3     4      5
     *                6    
     * 
     * 
     * 
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
     
//   root3    1
//           2
//        
        
        
        node root3=new node(1);     
        root3.left=new node(2);
       //root3.right=new node(2);
     //  root3.right.right=new node(6);
        
        node root4=new node(1);
        root4.left=new node(3);
       // root4.right=new node(8);
        
        
        node root2=new node(3);
        root2.right=new node(7);
        root2.right.left=new node(8);
        
        
       node root=new node(0);
       node n1=new node(1);
       node n2=new node(2);
      node n3=new node(3);
      node n4=new node(4);
      node n5=new node(5);
      node n6=new node(6);
      node n7=new node(7);
       
      root.left=n1;
      root.random=n4;
      root.right=n2;
            n1.left=n3;
            n1.right=n4;
       //     n3.right=n5;
            
            n2.right=n5;
            n5.left=n6;
            
     n2.random=n1;
     n4.random=n2;
     n5.random=n3;
     n1.random=root;
         
     
     
     
     
     
     
     
     
     
     
     
     
       // node sav=root.clone(root);
        
//     
//node rooty=root;
//
//        root.connect_level(root);
//        System.out.println("bkaa");
//        while(rooty!=null)
//        {
//        node temp=rooty;
//            while(temp!=null)
//            {
//                System.out.print("-->"+temp.data);
//                temp=temp.next;
//            }
//            System.out.println(" ");
//        rooty=rooty.left;
//        }
//        
//   root.printLevel(sav);
//            
//     int in[]={4,2,1,3,5};
//     int level[]={1,2,3,4,5};
//     
//     node inlevel=root.make_inlevel(level, in, 0, in.length-1);
//        System.out.println("making from inlevel and inorder");
//     root.itraverse(inlevel);
//       System.out.println("making from inlevel and inorder");
//     
        //System.out.println("our ans is");
        
            node root6=new node(-3);//maxsum path corner cases
            
            int path[]=new int[50];
            int plength=0; 
      // root.root_leaf(root, path, plength);
  // root3.itraverse(root3);

   
   
//   root3.make_mirror(root3);
//        System.out.println("   after mirroring ");
//            root3.itraverse(root3);
//            
            
   // node root10=root3.create_mirror(root3);
   // root3.itraverse(root10);
            
            
           // System.out.println("is bst "+root3.isBST(root3));
           // root.flatten(root);
            //root.print_prev(root);
            
//              
//    root.doubleit(root);
//    root.itraverse(root);
//           
            //root.postorder_visit(root);
         
           // System.out.println("max sum is"+root.findmaxsum(root6));
           // System.out.println("max sum is "+root.maxsum);
          //  root.zigzag(root);
            
        //array to tree 
            
          //  node ans=root.LCA(root, root.left.left,root.left.right);
           // System.out.println("lca is"+ans.data);
            //System.out.println("diameter is"+root.diameter(root));
   
//    
//            int a[]={1,2,4,6,3,8,9};
//            int pflag[]={1,1,0,0,1,0,0};
//            
//            node rootx=root.maketree_pre(a, pflag, 0,a.length-1);
//            System.out.println("here it is");
//            root.printLevel(rootx);
//           //node copyroot= root.maketree(a,0,a.length-1);
//        node root5=new node(1);
//        root5.right=new node(2);
//        root5.right.right=new node(3);
//        
        //System.out.println("mid depth is"+root5.mindepth(root5));
        
        
        
          //root.cal_HD(root, 0);
          // System.out.println(" min hd is"+root.min_hd);
           //System.out.println(" max hd is"+root.max_hd);
            //copyroot.itraverse(copyroot);
            //root.printvert_sum(root);
            //root.printLevel(root);
            //root.itraverse(root);
            
    }
    
}
