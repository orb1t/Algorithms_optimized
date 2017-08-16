/**
 * Created by Jerry on 16-08-2017.
 */
public class CycleDetection {

    public boolean isCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }


}
