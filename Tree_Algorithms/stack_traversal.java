/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Stack;

/**
 * @author Prit Sheth
 */
public class stack_traversal {


    //normal traverse using stack wihtout recursion---------------------------------------------


    public void stk_preorder(node root) {


        Stack<node> s1 = new Stack<node>();
        s1.push(root);

        while (!s1.empty()) {
            node temp = s1.peek();
            System.out.println("--> " + temp.data);
            s1.pop();

            if (temp.right != null) {
                s1.push(temp.right);
            }

            if (temp.left != null) {
                s1.push(temp.left);
            }


        }

    }

    public void stk_inorder(node root) {
        Stack<node> s1 = new Stack<node>();
        s1.push(root);

        while (!s1.empty()) {
            node temp = s1.peek();
            if (!temp.visited)

            {
                temp.visited = true;

                s1.pop();

                if (temp.right != null) {
                    s1.push(temp.right);
                }

                s1.push(temp);

                if (temp.left != null) {
                    s1.push(temp.left);
                }

            } else
                System.out.println("--> " + s1.pop().data);

        }


    }

    public void stk_postorder(node root) {
        Stack<node> s1 = new Stack<node>();
        s1.push(root);


        while (!s1.empty()) {
            node temp = s1.peek();
            if (!temp.visited)

            {
                temp.visited = true;
                if (temp.right != null) {
                    s1.push(temp.right);
                }


                if (temp.left != null) {
                    s1.push(temp.left);
                }

            } else
                System.out.println("--> " + s1.pop().data);

        }


    }

    public void postorder_visit(node root) //not using visited property but using another stack
    {

        Stack<node> s1 = new Stack<node>();
        Stack<Boolean> flag = new Stack<Boolean>();
        s1.push(root);
        flag.push(false);


        while (!s1.empty()) {
            node temp = s1.peek();
            if (!flag.peek())

            {
                flag.pop();
                flag.push(true);
                //temp.visited=true;
                if (temp.right != null) {
                    s1.push(temp.right);
                    flag.push(false);
                }


                if (temp.left != null) {
                    s1.push(temp.left);
                    flag.push(false);
                }

            } else {
                flag.pop();
                System.out.println("--> " + s1.pop().data);
            }
        }


    }


    ///end of stack traversal


}
