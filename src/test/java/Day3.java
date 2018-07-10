import org.junit.Test;

import java.util.*;

/**
 * @author lin
 * @date 2018/7/10 上午9:09
 * @description:
 */
public class Day3 {

    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int max = 0;
        int min_in = 1 << 30;
        for (int price : prices) {
            if (max < price - min_in) {
                max = price - min_in;
            }
            if (price < min_in) {
                min_in = price;
            }
        }
        return max;
    }

    //94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            if (tmp == null) continue;
            if (tmp.left == null && tmp.right == null) {
                result.add(tmp.val);
            } else {
                if (null != tmp.right) {
                    stack.push(tmp.right);
                }
                TreeNode left = tmp.left;
                tmp.left = null;
                tmp.right = null;
                stack.push(tmp);
                if (null != left) {
                    stack.push(left);
                }
            }
        }
        return result;
    }

    @Test
    public void tt() {
        System.out.println(1 << 29);
        System.out.println(Integer.MAX_VALUE);
    }
}
