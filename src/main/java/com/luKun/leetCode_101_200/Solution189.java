package com.luKun.leetCode_101_200;

/**
 * @ClassName Solution189
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/11 15:04
 * @Version 1.0
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        if (nums.length==1)return;
        if (k%nums.length==0)return;
        int[] nums1=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i]=nums[i];
        }
        int count=k% nums.length;
        for (int i = 0; i < nums1.length; i++) {
            if (count== nums.length)count=0;
            nums[count++]=nums1[i];
        }
    }
    public void rotate_test1(int[] nums, int k) {
        if (nums.length==1)return;
        if (k%nums.length==0)return;
        int[] nums1=new int[nums.length];
        for (int i = 0; i < nums.length; i++) nums1[i]=nums[i];
        for (int i = 0; i < nums1.length; i++) nums[(i+k)% nums.length]=nums1[i];
    }

    public void rotate_test2(int[] nums, int k) {
        k=k%nums.length;
        if (nums.length==1)return;
        if (k==0)return;
        for (int i = 0; i < nums.length/2; i++) {
            nums[i]+=nums[nums.length-1-i];
            nums[nums.length-1-i]=nums[i]-nums[nums.length-1-i];
            nums[i]-=nums[nums.length-1-i];
        }
        for (int i = 0; i < k/2; i++) {
            nums[i]+=nums[k-1-i];
            nums[k-1-i]=nums[i]-nums[k-1-i];
            nums[i]-=nums[k-1-i];
        }

        for (int i = 0; i < (nums.length-k)/2; i++) {
            nums[i+k]+=nums[nums.length-1-i];
            nums[nums.length-1-i]=nums[i+k]-nums[nums.length-1-i];
            nums[i+k]-=nums[nums.length-1-i];
        }
    }
    public static void reverse(int nums[],int start,int end){
        while (start<end){
            nums[start]+=nums[end];
            nums[end]=nums[start]-nums[end];
            nums[start++]-=nums[end--];
        }
    }
    public static void rotate_test3(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6,7};
        rotate_test3(nums,3);
        for (int num : nums) {
            System.out.print(num+"   ");
        }
    }
}
