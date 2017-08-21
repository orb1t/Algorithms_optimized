/**
 * Created by Jerry on 21-08-2017.
 */
public class DeleteDuplicate {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode listNode = deleteDuplicates(a1);
ListUtil.printAll(listNode);

    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;
        ListNode pre = new ListNode(100);
        ListNode answer = pre;
        while (temp != null && temp.next !=null) {
            if (temp.data == temp.next.data) {
                ListNode nextUniqueNode= getNextNode(temp);
                pre.next = nextUniqueNode;
                temp = nextUniqueNode;
            } else {
                pre.next = temp;
                pre = pre.next;
                temp = temp.next;
            }
        }

        return answer;
    }

    public static ListNode getNextNode(ListNode node) {

        if (node == null || node.next == null)
            return null;

        if (node.data == node.next.data)
          return  getNextNode(node.next);

        ListNode next = node.next;
        return next;

    }

}
