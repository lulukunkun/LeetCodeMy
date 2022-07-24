package com.luKun.leetCode_301_400;

/**
 * @ClassName Solution344
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/12 19:59
 * @Version 1.0
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        char temp=0;
        while (left<right){
            temp=s[left];
            s[left++]=s[right];
            s[right--]=temp;
        }
    }
}
