import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @date 2018/8/12 上午11:06
 * @description:
 */
public class Day12 {

    //112.Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //113.Path Sum2
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list, sum);
        return rlt;
    }

    List<List<Integer>> rlt = new ArrayList<List<Integer>>();

    private void dfs(TreeNode node, List<Integer> list, int sum) {
        if (node == null) return;
        list.add(node.val);
        if (sum - node.val == 0 && node.left == null && node.right == null) {
            rlt.add(new ArrayList<Integer>(list));
            return;
        }
        if (node.left != null) {
            dfs(node.left, list, sum - node.val);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, list, sum - node.val);
            list.remove(list.size() - 1);
        }
    }

}
