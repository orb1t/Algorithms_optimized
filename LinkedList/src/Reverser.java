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
    ListNode temp;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        reverse(head);
        head.next = null;
        return temp;
    }


    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            temp = node;
            return node;
        }
        ListNode temp = reverse(node.next);
        temp.next = node;
        return node;
    }

}
