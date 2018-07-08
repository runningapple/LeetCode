import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @date 2018/7/5 下午7:04
 * @description:
 */
public class Day1 {

    //136. Single Number
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


    //118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j - 2));
                }
            }
            result.add(list);
        }
        return result;
    }

    //119. Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {

        return null;
    }

    //137. Single Number II
    public int singleNumber2(int[] nums) {
        int result = nums[0];
        return result;
    }

    //Triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        List<Integer> list = triangle.get(triangle.size() - 1);
        for (int i = 0; i < dp.length; i++) {
            dp[i] = list.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[i] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
        /**
         for (int i = triangle.size() - 2; i >= 0; i--) {
         for (int j = 0; j < triangle.get(i).size(); j++) {
         int a = triangle.get(i + 1).get(j);
         int b = triangle.get(i + 1).get(j + 1);
         int c = triangle.get(i).get(j);
         triangle.get(i).set(j, c + Math.min(a, b));
         }
         }
         return triangle.get(0).get(0);
         */
    }

    @Test
    public void test() {
//        System.out.println(1 ^ 1);
//        System.out.println(1 ^ 1 ^ 2);
    }
}
