import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lin
 * @date 2018/7/15 下午4:00
 * @description:
 */
public class Day7 {

    //103. Binary Tree Zigzag Level Order Traversal
    private void dfs(List<List<Integer>> result, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (result.size() < depth) {
            result.add(new LinkedList<Integer>());
        }
        if ((depth & 1) == 0) {
            result.get(depth-1).add(0, node.val);
        } else {
            result.get(depth-1).add(node.val);
        }
        dfs(result, node.left, depth+1);
        dfs(result, node.right, depth+1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, root, 1);
        return result;
    }


    //130. Surrounded Regions
    public void solve(char[][] board) {
        if (board.length < 1) return ;
        int bound = board[0].length-1;
        int len = board.length-1;
        boolean[][] vis = new boolean[len+1][bound+1];
        for (int i = 0; i < board.length; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(board, vis, i, 0);
            }
            if (!vis[i][bound] && board[i][bound] == 'O') {
                dfs(board, vis, i, bound);
            }
        }
        for (int i = 0; i <= bound; i++) {
            if (!vis[len][i] && board[len][i] == 'O') {
                dfs(board, vis, len, i);
            }
            if (!vis[0][i] && board[0][i] == 'O') {
                dfs(board, vis, 0, i);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < bound; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, boolean[][] vis,  int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && !vis[i][j] && board[i][j] == 'O') {
            vis[i][j] = true;
            dfs(board, vis, i+1, j);
            dfs(board, vis, i-1, j);
            dfs(board, vis, i, j+1);
            dfs(board, vis, i, j-1);
        }
    }

    @Test
    public void test() {
        boolean[] a = new boolean[2];
        System.out.println(a[0]);
    }
}
