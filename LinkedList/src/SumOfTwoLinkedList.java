import java.util.Stack;

/**
 * Created by Jerry on 21-08-2017.
 */
public class SumOfTwoLinkedList {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumLinkedList(l1, l2);
    }

    private ListNode sumLinkedList(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        Stack<ListNode> s1 = new Stack();
        Stack<ListNode> s2 = new Stack();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum1=0,sum2 =0;

            if(!s1.isEmpty()) sum1 = s1.pop().data;
           if(!s2.isEmpty())  sum2 = s2.pop().data;

           ListNode newNode = new ListNode((sum1+sum2+carry)%10);
           newNode.next = head;
           head = newNode;
           carry = (sum1+sum2)/10;
        }
        if(carry>0)
        {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

}
