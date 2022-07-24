package com.luKun.leetCode_201_300;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Solution217
 * @Description 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Author LuKun
 * @Date 2022/7/15 16:21
 * @Version 1.0
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.get(num)>1)return true;
        }
        return false;
    }
}
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
//插入排序
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            // 保存当前值
            int tmp = nums[i];
            int j = i-1;
            // 小的往左边移，大的往右边移
            for(; j >= 0; j--) {
                // 比较当前值与上一个值情况
                if(nums[j] > tmp) {
                    // 上一个值大，则移向右边
                    nums[j+1] = nums[j];
                } else if(nums[j] == tmp) {
                    // 相等则跳出（若是排序这是跳出当前循环）
                    return true;
                } else {
                    break;
                }
            }
            nums[j+1] = tmp;
        }
        return false;
    }
}

