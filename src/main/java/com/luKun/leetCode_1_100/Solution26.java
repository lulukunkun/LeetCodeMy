package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution26
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/8 17:06
 * @Version 1.0
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        if (nums.length==1)return 1;

        int p1=nums[0];
        int p2=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=p1){
                p1=nums[i];
                nums[p2]=nums[i];
                p2++;
            }
        }

        return p2;
    }
}

class test{
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] xx=new int[]{1, 1, 2};
        System.out.println(solution26.removeDuplicates(xx));
        for (int i : xx) {
            System.out.println(i);
        }
    }
}

