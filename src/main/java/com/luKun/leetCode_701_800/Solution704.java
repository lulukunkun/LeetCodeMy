package com.luKun.leetCode_701_800;

import java.util.Arrays;

/**
 * @ClassName Solution704
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/11 10:44
 * @Version 1.0
 */
public class Solution704 {
    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (left>=right)break;
            int mid = left + (right - left) / 2;
            if (nums[mid]==target)return mid;
            System.out.printf("left=%d,right=%d,mid=%d,num=%d\n",left,right,mid,nums[mid]);
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        //Arrays.binarySearch(nums, target);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},13));
    }
}
