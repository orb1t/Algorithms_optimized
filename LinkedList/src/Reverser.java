/**
 * Created by Prit Sheth on 12-03-2017.
 */
public class Reverser {

    /**
     * Using recursion : go to end of the list and then start reversing.
     *
     * @param node
     * @return
     */
    ListNode end;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        reverse(head);
        head.next = null;
        return end;
    }


    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            end = node;
            return node;
        }
        ListNode temp = reverse(node.next);
        temp.next = node;
        return node;
    }


    public ListNode reverseIterative(ListNode head) {

        ListNode first = head;
        ListNode second = head.next;
        first.next = null;


        while (second != null) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;

    }


}
