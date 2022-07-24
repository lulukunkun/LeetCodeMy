package com.chuanxi_java.day1;

import java.util.HashMap;

/**
 * @ClassName ArrayDemo
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/14 19:55
 * @Version 1.0
 */
public class ArrayDemo {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x=map.getOrDefault(nums[i],-1);
            if (x!=-1){
                return new int[]{x,i};
            }else {
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}
