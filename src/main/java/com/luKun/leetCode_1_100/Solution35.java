package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution35
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/9 16:02
 * @Version 1.0
 */
public class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;
        int middle=0;

        while (left<=right){
            middle =(right-left)/2+left;
            System.out.printf("left=%d,right=%d,middle=%d\n",left,right,middle);
            if (nums[middle]==target)return middle;
            else if(nums[middle]<target) left=middle+1;
            else right=middle-1;

        }
        return left;
    }
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }
}
