/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Prit Sheth
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

    node(int data) {
        this.data = data;
        left = right = random = null;
    }

    //clone it----1)using hahsmap and other using left link

    public node clone(node root) {

        copy_left(root);//it will genrate copy of it
        clone_map(root);//it will fix the random pointer
        node save = root.left;
        restore_clone(root, root.left);

        return save;
    }

    public void restore_clone(node tree_node, node clone_root) //not right
    {
        if (tree_node == null || tree_node.left == null || clone_root == null)
            return;

        if (clone_root.left != null) {
            node save = clone_root.left.left;
            tree_node.left = tree_node.left.left;
            clone_root.left = save;

        } else
            tree_node.left = null;


        restore_clone(tree_node.left, clone_root.left);
        restore_clone(tree_node.right, clone_root.right);

    }

    public node clone_map(node root) {

        if (root == null)
            return null;


        if (root.left != null && root.random != null)
            root.left.random = root.random.left;
        //root.left=root.left.left;


        clone_map(root.left.left);
        clone_map(root.right);


        return root;
    }

    public node copy_left(node root) //perfect
    {
        if (root == null)
            return null;

        node temp = root.left;
        node root1 = new node(root.data);
        root.left = root1;
        root1.left = temp;

        copy_left(root.left.left);


        root.left.right = copy_left(root.right);
        return root.left;


    }


    //make tree from level order and in order

    public int find_index(int arr[], int k, int strt, int end) {
        int index = -1;
        for (int i = strt; i <= end; i++)
            if (arr[i] == k)
                index = i;

        return index;
    }


    int level_index = 0;

    public node make_inlevel(int level[], int in[], int strt, int end)//nnot completed
    {
        if (level_index >= level.length) return null;

        node root = new node(level[level_index++]);

        if (strt == end)
            return root;

        if (strt > end)
            return null;


        int index = find_index(in, root.data, strt, end);

        root.left = make_inlevel(level, in, strt, index - 1);
        root.right = make_inlevel(level, in, index + 1, end);


        return root;

    }
    //http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

    int side = 0;
    int diff = 0;
    int dist_root = 0;


    public void find_diff(node root, node temp, int s, int level) {
        if (root == null)
            return;

        if (root == temp) {
            dist_root = level;
            side = s;
        }

        find_diff(root.left, temp, 1, level + 1);
        find_diff(root.right, temp, 2, level + 1);


    }

    //not completed
    public void kdist_away(node root, node temp, int k, int level) {

        if (root == null)
            return;

        if (level == k)
            System.out.println(" " + root.data);

        kdist_away(root, temp.left, k, level + 1);
        kdist_away(root, temp.right, k, level + 1);


    }

    //  public void kdist_up(node root,node temp)


    //for getting vertical print 

    int min_hd = Integer.MAX_VALUE, max_hd = Integer.MIN_VALUE;

    public void cal_HD(node root, int hd) //to calculate min height and max height
    {

        if (root == null)
            return;

        if (hd < min_hd)
            min_hd = hd;
        if (hd > max_hd)
            max_hd = hd;


        cal_HD(root.left, hd - 1);
        cal_HD(root.right, hd + 1);
    }


    public void printvert(node root)  //both vert down and vert up   also using hashmap
    {
        for (int line = min_hd; line <= max_hd; line++)
            print_vertup(root, line, 0);
    }

    public void printvert_sum(node root)  //both vert down and vert up for vertical sum
    {
        for (int line = min_hd; line <= max_hd; line++) {
            sum1 = 0;
            System.out.println("  " + print_vertsum(root, line, 0, 0));
        }
    }


    public void print_vertup(node root, int line, int hd)   //in upward direction
    {

        if (root == null)
            return;
        print_vertup(root.left, line, hd - 1);
        print_vertup(root.right, line, hd + 1);


        if (line == hd)
            System.out.println(" " + root.data);

    }


    public void print_vertdown(node root, int line, int hd)  //downwards
    {

        if (root == null)
            return;


        if (line == hd)
            System.out.println(" " + root.data);

        print_vertdown(root.left, line, hd - 1);
        print_vertdown(root.right, line, hd + 1);


    }

    int sum1 = 0;

    public int print_vertsum(node root, int line, int hd, int sum)  //downwards
    {

        if (root == null)
            return 0;

        if (line == hd)
            sum1 = sum1 + root.data;


        print_vertsum(root.left, line, hd - 1, sum1);
        print_vertsum(root.right, line, hd + 1, sum1);


        return sum1;
    }


    //end of vertical print


    public int Fheight(node root) //max height
    {
        if (root == null)
            return 0;

        return (1 + max(Fheight(root.left), Fheight(root.right)));
    }

    public int mindepth(node root)  //min height
    {
        if (root == null)
            return 0;


        return (1 + min(mindepth(root.left), mindepth(root.right)));


    }


    // traversal----------------------all ---types---------------------------------------------------------


    public void printLeftView(node root) //level order traversal using queue
    {
        Queue<node> s1 = new LinkedList<node>();
        s1.add(root);

        while (!s1.isEmpty()) {
            node temp = s1.remove();
            System.out.println(" " + temp.data);

            if (temp.left != null)
                s1.add(temp.left);

            else if (temp.right != null)
                s1.add(temp.right);
        }

    }


    public List<List<Integer>> levelOrder(node root) {


        return null;
    }


    public node leftmost(node root) {

        if (root == null)
            return null;

        if (root.left == null)
            return root;

        while (root.left != null)
            root = root.left;

        return root;

    }


    public int min(int val1, int val2)   // root=1 and root.left=2...mid depth sud be 2
    {
        if (val1 == 0)  //reson and analysis...in min of both 0 will alwz return dats y
            return val2;
        if (val2 == 0)
            return val1;
        if (val1 > val2)
            return val2;
        else
            return val1;
    }


    public int max(int val1, int val2) {
        if (val1 > val2)
            return val1;
        else
            return val2;
    }


    public Boolean isbal(node root) //wrong output  //corner cases for 1---right---2---right---3...wrong out put..
    {
        if (root == null)
            return true;
        int x = Fheight(root) - mindepth(root);

        System.out.println("diff is " + x);
        return (x <= 1);


    }


    // static int maxsum=0;

    public int maxsumPath(node root, int maxum[]) //wrong
    {
        if (root == null)
            return 0;

//Input:	{2,-1}   
//Output:	1
//Expected:	2

        //      Input:	{1,-2,3}
//Output:	3
//Expected:	4


        int left = maxsumPath(root.left, maxum);
        int right = maxsumPath(root.right, maxum);
        int cursum;
        if (root.left == null && root.right == null)//corner case if only one node =-3 then wrong ans =0 dats y
            cursum = root.data;
        else
            cursum = max(left + right + root.data, max(left, right));   //corner case here we have to consider left sum and right sum also
        if (cursum > maxum[0]) maxum[0] = cursum;


        return (root.data + max(left, right));


    }

    public int findmaxsum(node root) //wrong
    {
        int max[] = {Integer.MIN_VALUE};
        maxsumPath(root, max);
        return max[0];

    }


    public int kdist_leaf(node root) {


        return 0;
    }

    private int maxpathsum = Integer.MIN_VALUE;


    private int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= c)
            return b;
        else
            return c;
    }


    //-----------------------------new codes-------------


    public boolean isskewed(node root) {

        if (root.left != null)
            return false;

        return true && isskewed(root.right);

    }


    public void doubleit(node root) {
        if (root == null)
            return;


        node temp = root.left;
        node n1 = new node(root.data);
        root.left = n1;
        n1.left = temp;


        doubleit(root.left.left);
        doubleit(root.right);


    }


    //page 6

    //http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
    public node makeheap_in(int in[], int instart, int inend) {
        if (instart > inend)
            return null;

        int index = find_max(in, instart, inend);
        node root = new node(in[index]);


        if (instart == inend)
            return root;


        root.left = makeheap_in(in, instart, index - 1);
        root.right = makeheap_in(in, index + 1, inend);

        return root;

    }

    public int find_max(int in[], int instart, int inend) {
        int maxi = instart;
        for (int i = instart; i <= inend; i++) {
            if (in[maxi] < in[i])
                maxi = i;

        }
        return maxi;
    }


    public node maketree_pre(int pre[], int pflag[], int strt, int end) {
        if (strt > end) return null;
        node root = new node(pre[strt]);
        if (pflag[strt] == 1) {

            if (pflag[strt + 1] == 1) {
                int index = find_lastleaf(pflag, strt, end);
                root.left = maketree_pre(pre, pflag, strt + 1, index);

                root.right = maketree_pre(pre, pflag, index + 1, end);
            } else {
                root.left = new node(pre[strt + 1]);
                root.right = new node(pre[strt + 2]);

            }


        }

        return root;
    }

    public int find_lastleaf(int pflag[], int strt, int end) {
        int index = strt;
        for (int i = 0; i <= end; i++) {
            if (pflag[i] == 0)
                index = i;
        }
        return index;
    }

    //practice of all the codes ...lets start...


}



