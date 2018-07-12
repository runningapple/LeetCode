import apple.laf.JRSUIUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @date 2018/7/11 上午9:15
 * @description:
 */
public class Day4 {

    //102. Binary Tree Level Order Traversal
    private void dfs(TreeNode node, List<List<Integer>> lists, int depth) {
        if (null != node) {
            if (lists.size() < depth + 1) {
                List<Integer> list = new LinkedList<Integer>();
                lists.add(list);
            }
            lists.get(depth).add(node.val);
            if (null != node.left) {
                dfs(node.left, lists, depth + 1);
            }
            if (null != node.right) {
                dfs(node.right, lists, depth + 1);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        dfs(root, lists, 0);
        return lists;
    }

    //101. Symmetric Tree
    private boolean dfsTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return dfsTree(root1.left, root2.right) && dfsTree(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || dfsTree(root.left, root.right);
    }

    //122. Best Time to Buy and Sell Stock II
    //这种写法太糟糕
    public int maxProfit(int[] prices) {
        int profit = 0;
        int index = 0;
        int buyIn = 1 << 30;
        while (index < prices.length) {
            if (buyIn >= prices[index]) {
                buyIn = prices[index];
                index += 1;
            } else {
                while (true) {
                    if (index + 1 == prices.length) {
                        if (buyIn < prices[index]) {
                            profit += prices[index] - buyIn;
                        }
                        index += 1;
                        break;
                    }
                    if (prices[index] > prices[index + 1]) {
                        profit += prices[index] - buyIn;
                        buyIn = prices[index + 1];
                        index += 1;
                        break;
                    }
                    index += 1;
                }
            }
        }
        return profit;
    }
}
