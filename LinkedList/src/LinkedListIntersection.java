/**
 * Created by Jerry on 19-08-2017.
 */
public class LinkedListIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        int counter = Math.abs(lengthA - lengthB);

        if (lengthA > lengthB)
            headA = updateHead(headA, counter);
        else if (lengthA < lengthB)
            headB = updateHead(headB, counter);

        while (headA != headB) {

            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private ListNode updateHead(ListNode head, int counter) {
        while (counter-- > 0)
            head = head.next;
        return head;
    }

    private int getLength(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }
}
