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
            if (prices[i] > min && maxPrice < prices[i] - min) {
                maxPrice = prices[i] - min;
            }
        }
        return maxPrice;
    }

    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            int a = getMax(prices, 0, i);
            int b = getMax(prices, i + 1, prices.length - 1);
            if (a + b > maxPrice) {
                maxPrice = a + b;
            }
        }
        return maxPrice;
    }

    @Test
    public void tt() {
        int[] pr = {2, 1, 4, 5, 2, 9, 7};//[1,2,4,2,5,7,2,4,9,0]
        System.out.println(maxProfit(pr));
    }
}
