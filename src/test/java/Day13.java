import org.junit.Test;

/**
 * @author lin
 * @date 2018/8/18 下午3:02
 * @description:
 */
public class Day13 {
    //141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode node = new ListNode(0);
        int code = node.hashCode();
        ListNode tmp;
        while (head != null) {
            if (code == head.hashCode()) {
                return true;
            }
            tmp = head;
            head = head.next;
            tmp.next = node;
        }
        return false;
    }

    //142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                break;
            }
        }
        if (first == null || second == null || second.next == null) return null;
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        node1.next = node;
        System.out.println(hasCycle(node));
    }
}
