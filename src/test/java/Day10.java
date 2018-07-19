import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lin
 * @date 2018/7/19 上午10:01
 * @description:
 */
public class Day10 {
    //144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            if (tmp != null) {
                list.add(tmp.val);
                stack.push(tmp.right);
                stack.push(tmp.left);
            }
        }
        return list;
    }

    //145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        TreeNode tmp;
//        while (!stack.isEmpty()) {
//            tmp = stack.pop();
//            if (tmp != null) {
//                list.add(0, tmp.val);
//                stack.push(tmp.right);
//                stack.push(tmp.left);
//            }
//        }
        return list;
    }
}
