package com.luKun.leetCode_101_200;

/**
 * @ClassName Solution121
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/18 21:26
 * @Version 1.0
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int max_profit=0;
        int k=0;
        for (int i = 1; i < prices.length; i++) {
            int tmp=prices[i]-prices[k];
            if (tmp>0)max_profit=Math.max(max_profit,tmp);
            else k=i;
        }
        return max_profit;
    }
}
