import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerry on 19-08-2017.
 */
public class CloneList {

    public static void main(String[] args) {

        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);


        a1.next = a2;
        a1.random = a2;
        a2.next = a3;
        a2.random = a4;

        a3.next = a4;
        a3.random = a1;
        a4.next = a5;
        a4.random = a3;

        copyRandomList(a1);
    }

    // without space
    public static RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode answerHead = new RandomListNode(head.label);
        RandomListNode pre = answerHead;
        RandomListNode originalHead = head;
        //head = head.next;

// First pass: copy of the next pointer

        while (head != null) {
            RandomListNode copy = new RandomListNode(head.label);
            copy.random = head;
            RandomListNode temp = head.next;  // saving next pointer because we have to change it
            head.next = copy;
            pre.next = copy;

            // next node in original linked list
            pre = pre.next;
            head = temp;
        }

        answerHead = answerHead.next;
        RandomListNode answerNode = answerHead;

        ListUtil.printAll(originalHead);

        // Store random pointer in hashmap:
        while (answerHead != null) {
            RandomListNode resetNextLink = answerHead.random;

            if (answerHead.random.random != null)
                answerHead.random = answerHead.random.random.next;
            else
                answerHead.random = null;

            resetNextLink.next = answerHead.next;
            answerHead = answerHead.next;
        }

        ListUtil.printAll(answerNode);
        ListUtil.printAll(originalHead);

        return answerNode;
    }

    //with Order of N space
    public static RandomListNode copyRandomListWithSpace(RandomListNode head) {
        RandomListNode temp = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = head;

        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

}
