package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution28
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/9 11:03
 * @Version 1.0
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle.trim()) || needle == null) return 0;
        int index = 0;
        int flag = 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            index = i;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(index)) flag++;
                index++;
            }
            if (flag == needle.length()) return i;
            else flag = 0;
        }
        return -1;
    }
    public int strStr_top1(String haystack, String needle) {
        if(needle=="") return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            boolean flag=true;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
    public int strS(String haystack, String needle) {
        if(needle=="") return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,needle.length()+i).equals(needle))return i;
        }
        return -1;
    }
}
