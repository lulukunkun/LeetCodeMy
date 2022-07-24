package com.luKun.leetCode_901_1000;

/**
 * @ClassName Solution977
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/11 11:19
 * @Version 1.0
 */
public class Solution977 {
    public static int[] sortedSquares(int[] nums) {
        if (nums.length==1){
            nums[0]*=nums[0];
            return nums;
        }
        int left =0;
        int right = nums.length-1;
        int[] results=new int[nums.length];
        int i=results.length-1;
        while (left<=right){
            while (left<=right&&Math.pow(nums[left],2)>Math.pow(nums[right],2) &&i>=0){
                results[i]=nums[left]*nums[left];
                left++;
                i--;
            }
            while (left<=right&&Math.pow(nums[left],2)<=Math.pow(nums[right],2)&&i>=0){
                results[i]=nums[right]*nums[right];
                right--;
                i--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i : sortedSquares(new int[]{0,2})) {
            System.out.println(i);
        }
    }
}
