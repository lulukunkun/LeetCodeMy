package com.luKun.leetCode_101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution167
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/9 21:07
 * @Version 1.0
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0,j=numbers.length-1; i < numbers.length && j>=0; i++,j--) {
            if (map.containsKey(numbers[i]))return new int[]{map.get(numbers[i])+1,i+1};
            else map.put(target-numbers[i], i);
            if (map1.containsKey(numbers[j]))return new int[]{j+1,map1.get(numbers[j])+1};
            else map1.put(target-numbers[j], j);
        }
        return null;
    }
}
