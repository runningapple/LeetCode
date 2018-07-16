/**
 * @author lin
 * @date 2018/7/16 下午11:36
 * @description:
 */
public class Day8 {
    //70. Climbing Stairs
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int[] step = new int[n];
        step[0] = 1;
        step[1] = 2;
        int index = 2;
        int cnt = 1;
        while (index < n) {
            step[index] = step[index - 1] + step[index - 2];
            index++;
        }
        return step[n - 1];
    }

    //111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        mindepth = 1 << 30;
        dfs(root, 1);
        return mindepth;
    }

    private int mindepth;

    private void dfs(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            mindepth = mindepth > level ? level : mindepth;
            return;
        }
        if (level > mindepth) return;
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }


    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxdepth = -1<<30;
        dfsMax(root, 1);
        return maxdepth;
    }

    private int maxdepth;
    private void dfsMax(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            maxdepth = maxdepth < level ? level : maxdepth;
            return;
        }
        if (node.left != null) {
            dfsMax(node.left, level + 1);
        }
        if (node.right != null) {
            dfsMax(node.right, level + 1);
        }
    }
}
