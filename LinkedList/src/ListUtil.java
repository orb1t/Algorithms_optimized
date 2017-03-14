/**
 * Created by Jerry on 13-03-2017.
 */
public class ListUtil {
    public void printAll(ListNode head) {
        if (head == null)
            return;
        System.out.println(head.getData());
        printAll(head.next);
    }

    public ListNode getLast(ListNode head) {
        if (head.next == null)
            return head;
        return getLast(head.next);
    }

}
