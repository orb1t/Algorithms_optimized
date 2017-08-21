import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jerry on 19-08-2017.
 */
public class ReverserTest {
    @Test
    public void reverseList() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;


        Reverser reverser = new Reverser();
        ListNode reverseListNode = reverser.reverseIterative(a1);

        a5.next = a4;
        a4.next = a3;
        a3.next = a2;
        a2.next = a1;
        a1.next = null;

        ListNode expected = a5;
        while (expected.next != null && reverseListNode.next != null) {
            Assert.assertEquals(expected.data, reverseListNode.data);
            expected = expected.next;
            reverseListNode = reverseListNode.next;
        }

        Assert.assertFalse(expected.next != null || reverseListNode.next != null);
    }

}