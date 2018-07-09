import org.junit.Test;

/**
 * @author lin
 * @date 2018/7/6 上午9:43
 * @description:
 */
public class Day2 {


    //148. Sort List
    public ListNode sortList(ListNode head) {


        return null;
    }


    //79. Word Search
    private boolean isExist;

    private void dfs(char[][] board, int x, int y, boolean[][] vis, char[] word, int index) {
        if (!isExist && board[x][y] == word[index - 1]) {
            if (index == word.length) {
                isExist = true;
                return;
            }
            if (x + 1 < board.length && !vis[x + 1][y]) {
                vis[x + 1][y] = true;
                dfs(board, x + 1, y, vis, word, index + 1);
                vis[x + 1][y] = false;
            }
            if (x - 1 >= 0 && !vis[x - 1][y]) {
                vis[x - 1][y] = true;
                dfs(board, x - 1, y, vis, word, index + 1);
                vis[x - 1][y] = false;
            }
            if (y - 1 >= 0 && !vis[x][y - 1]) {
                vis[x][y - 1] = true;
                dfs(board, x, y - 1, vis, word, index + 1);
                vis[x][y - 1] = false;
            }
            if (y + 1 < board[x].length && !vis[x][y + 1]) {
                vis[x][y + 1] = true;
                dfs(board, x, y + 1, vis, word, index + 1);
                vis[x][y + 1] = false;
            }
        }
    }

    //79. Word Search
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        isExist = false;
        boolean[][] vis = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                vis[i][j] = true;
                dfs(board, i, j, vis, chars, 1);
                vis[i][j] = false;
            }
        }
        return isExist;
    }

    //100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null != p && q != null && p.val == q.val) {
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
        return false;
    }

    @Test
    public void tt() {
        System.out.println('A');
        char a = 'A' ^ 256;
        System.out.println(a);
    }
}
