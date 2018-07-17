import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lin
 * @date 2018/7/17 下午10:05
 * @description:
 */
public class Day9 {
    //116. Populating Next Right Pointers in Each Node
    //还有更好的方法
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int cnt = 0;
        int index = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode tmp = queue.poll();
            if (tmp != null && tmp.left != null) {
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
            ++cnt;
            if (cnt == (1<<index)) {
                cnt = 0;
                ++index;
            } else {
                tmp.next = queue.peek();
            }
        }
    }

    @Test
    public void test() {
        System.out.println(1<<0);
    }
}
