package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution53
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/11 9:22
 * @Version 1.0
 */
public class Solution53 {
    /*
    *贪心实现
    * */
    public static int maxSubArray(int[] nums) {
        int max_val=nums[0];
        int sum=0;
        for (int num : nums) {
            /*
            * num>0&&sum>0 sum+=num
            * sum<0  sum=num
            * sum>0 num<=0 sum+=num
            * */
            if (sum<0)sum=num;
            else sum+=num;
            max_val=Math.max(max_val,sum);
        }
        return max_val;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
