package com.luKun.leetCode_301_400;

import java.util.*;

/**
 * @ClassName Solution350
 * @Description
给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致
（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *@Author LuKun
 * @Date 2022/7/18 20:10
 * @Version 1.0
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            int tmp= map.getOrDefault(i,0);
            if (tmp!=0){
                list.add(i);
                map.put(i,tmp-1);
            }
        }
        int i=list.size();
        int[] ints = new int[i];
        for (Integer integer : list) {
            ints[--i]=integer;
        }
//        Arrays.copyOfRange(new int[0],0,9);
        return ints;
    }
}
