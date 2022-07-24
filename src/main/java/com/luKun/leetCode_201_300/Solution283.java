package com.luKun.leetCode_201_300;

/**
 * @ClassName Solution283
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/12 14:48
 * @Version 1.0
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[++index];
                nums[index] = temp;
            }
        }
    }
}
