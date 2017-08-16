/**
 * Created by Prit Sheth on 12-03-2017.
 */
public class Main {
    public static void main(String[] args) {

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
//        reverser.reverseList(a1);
//        a1.next = null;
        ListNode listNode = reverser.reverseIterative(a1);
        ListUtil.printAll(listNode);


    }
}
