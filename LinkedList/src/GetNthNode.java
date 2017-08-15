/**
 * Created by Jerry on 16-08-2017.
 */
public class GetNthNode {

    public static void main(String[] args) {
        ListNode node = getDummyLinkedList();
        getNthNodeFromEnd(node, 3);
        ListNode middleOfList = getMiddleOfList(node);
        System.out.println("middle of the list is " + middleOfList.data);
    }

    private static ListNode getDummyLinkedList() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        return a1;
    }

    public static ListNode getNthNodeFromEnd(ListNode head, int N) {

        ListNode end = head;
        while (end.next != null && N != 1) {
            end = end.next;
            N--;
        }

        while (end.next != null) {
            head = head.next;
            end = end.next;
        }
        System.out.println("Nth node is" + head.data);
        return head;
    }

    public static ListNode getMiddleOfList(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // odd list
        if (fastPointer.next == null)
            return slowPointer;
        //even list
//        else if(fastPointer.next.next == null)
        return new ListNode((slowPointer.data + slowPointer.next.data) / 2);
    }

}
