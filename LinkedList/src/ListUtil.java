/**
 * Created by Prit Sheth on 13-03-2017.
 */
public class ListUtil {
    public static void printAll(ListNode head) {
        if (head == null)
            return;
        System.out.println(head.getData());
        printAll(head.next);
    }

    public static ListNode getLast(ListNode head) {
        if (head.next == null)
            return head;
        return getLast(head.next);
    }

}
