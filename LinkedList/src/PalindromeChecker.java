/**
 * Created by Jerry on 17-08-2017.
 */
public class PalindromeChecker {


    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != head) {
            if (temp.data != head.data)
                return false;
        }

        return true;
    }

}
