/**
 * @author lin
 * @date 2018/7/13 上午8:49
 * @description:
 */
public class Day6 {

    //80. Remove Duplicates from Sorted Array II
    public int removeDuplicates(int[] nums) {
        int len = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[len-2]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    //19. Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode node = result.next;
        while (head != null) {
            if (cnt > n) {
                node = node.next;
            }
            ++cnt;
            head = head.next;
        }
        if (cnt != n) {
            node.next = node.next.next;
        } else {
            result.next = result.next.next;
        }
        return result.next;
    }

    //82. Remove Duplicates from Sorted List II

    /**
     * 新增一个头结点，再符合条件的结点放到头结点的下一个结点之后
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode cc = result;
        ListNode node;
        while (head != null) {
            if ((head.next != null && head.val != head.next.val) || head.next == null) {
                cc.next = head;
                cc = cc.next;
                head = head.next;
            } else {
                node = head;
                do {
                    head = head.next;
                } while (head != null && node.val == head.val);
            }
        }
        cc.next = null;//将末尾结点的下一个结点置为 null，因为我们用 new 方式创建结点而是用赋值形式，所以最后一个结点的 next 结点可能是有值的。
        return result.next;
    }

    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next != null && tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
