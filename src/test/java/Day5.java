import org.junit.Test;

import java.util.Arrays;

/**
 * @author lin
 * @date 2018/7/12 上午9:08
 * @description:
 */
public class Day5 {

    //123. Best Time to Buy and Sell Stock III
    private int getMax(int[] prices, int begin, int end) {
        int maxPrice = 0;
        int min = 1 << 30;
        for (int i = begin; i <= end; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (maxPrice < prices[i] - min) {
                maxPrice = prices[i] - min;
            }
        }
        return maxPrice;
    }

    //还有更好的方法
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int a = getMax(prices, 0, i);
//            int b = getMax(prices, i + 1, prices.length - 1);
//            if (a + b > maxPrice) {
//                maxPrice = a + b;
//            }
//        }
        int[] max_before = new int[prices.length];
        int[] max_after = new int[prices.length];
        int min = 1 << 30;
        int max = 0;
        int maxPri = 0;
        int maxPP = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            if (maxPri < prices[i] - min) {
                maxPri = prices[i] - min;
            }
            max_before[i] = maxPri;
            if (max < prices[prices.length - i - 1]) {
                max = prices[prices.length - i - 1];
            }
            if (maxPP < max - prices[prices.length - i - 1]) {
                maxPP = max - prices[prices.length - i - 1];
            }
            max_after[prices.length - i - 1] = maxPP;
        }
        for (int i = 0; i < prices.length; i++) {
            if (maxPrice < max_before[i] + max_after[i]) {
                maxPrice = max_before[i] + max_after[i];
            }
        }
        return maxPrice;
    }

    @Test
    public void tt() {
        int[] pr = {1, 2, 3, 4};//[1,2,4,2,5,7,2,4,9,0]
        System.out.println(maxProfit(pr));
    }
}
