package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution27
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/9 10:24
 * @Version 1.0
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        return index ;
    }
}
