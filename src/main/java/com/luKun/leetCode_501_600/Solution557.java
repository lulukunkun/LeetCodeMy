package com.luKun.leetCode_501_600;

/**
 * @ClassName Solution557
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/12 20:03
 * @Version 1.0
 */
public class Solution557 {
    StringBuffer sb=new StringBuffer();
    public String reverseWords(String s) {
        StringBuffer sb1=new StringBuffer();
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            sb1.append(reverseString(s2)).append(" ");
        }
        sb1.setLength(sb1.length()-1);
        return sb1.toString();
    }
    public String reverseString(String s1) {
        char[] s=s1.toCharArray();
        int left=0;
        int right=s.length-1;
        char temp=0;
        while (left<right){
            temp=s[left];
            s[left++]=s[right];
            s[right--]=temp;
        }
        sb.setLength(0);
        for (char c : s) {
            sb.append(c);
        }
        return sb.toString();
    }
    public String reverseWords_test1(String s) {
        int left=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i]==' '){
                reverseString(chars,left,i-1);
                left=i+1;
            }
        }
        reverseString(chars,left,s.length()-1);
        return new String(chars);
    }
    public void reverseString(char[] s,int start ,int end) {
        int left=start;
        int right=end;
        char temp=0;
        while (left<right){
            temp=s[left];
            s[left++]=s[right];
            s[right--]=temp;
        }
    }
}
