package com.luKun.leetCode_1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution1
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/3 19:14
 * @Version 1.0
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    int[] results={i,j};
                    return results;
                }
            }
        }
        return null;
    }

    public int[] twoSum_Top1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum_Top0(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);

        while (left <= right) {
            int leftNum = nums[left];
            int rightNum = nums[right];


            if (map.containsKey(leftNum)) {
                int leftIndex = map.get(leftNum);
                result[0] = leftIndex > left ? left : leftIndex;
                result[1] = leftIndex > left ? leftIndex : left;
                break;
            } else {
                map.put(target - leftNum, left);
            }

            if (map.containsKey(rightNum)) {
                int rightIndex = map.get(rightNum);
                result[0] = rightIndex > right ? right : rightIndex;
                result[1] = rightIndex > right ? rightIndex : right;
                break;
            } else {
                map.put(target - rightNum, right);
            }
            left++;
            right--;
        }
        return result;
    }


}
