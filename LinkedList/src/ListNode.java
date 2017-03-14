/**
 * Created by Jerry on 12-03-2017.
 */
public class ListNode {
    int data;

    public ListNode(int data) {
        this.data = data;
    }

    ListNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
