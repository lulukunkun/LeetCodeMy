package com.luKun.leetCode_1_100;

import java.util.HashMap;

/**
 * @ClassName Solution3
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/10 8:45
 * @Version 1.0
 */
public class Solution3 {
    //197ms
    public static int lengthOfLongestSubstring(String s) {
        String s1="";
        int left=0;
        int max_size=0;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            s1=s.substring(left,i);
            if (s1.contains(s.substring(i,i+1))){
                left++;
                i=left;
                System.out.printf("left=%d,i=%d\n",left,i);
                count=1;
            }else {
                count++;
            }
            max_size= Math.max(count, max_size);
        }
        return max_size;
    }

    public static int  lengthOfLongestSubstring_top1(String s) {
        int fa = 0;
        int [] map = new int[128];
        char [] ch = s.toCharArray();
        for (int j = 0, i = 0; j < s.length(); j++) {
            i = Math.max(map[ch[j]],i);
            fa = Math.max(fa,j-i+1);
            map[ch[j]] = j + 1;
        }
        return fa;
    }

    public static int  lengthOfLongestSubstring_test1(String s) {
        int max_length = 0;
        int left=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            left=map.containsKey(s.charAt(i))?Math.max(map.get(s.charAt(i)),left):left;
            max_length=Math.max(max_length,i-left+1);
            map.put(s.charAt(i),i+1);
        }
        return max_length;
    }

    public static void main(String[] args) {
        //System.out.println("a".substring(1,2));
        //System.out.println(lengthOfLongestSubstring_top1("dvdf"));

    }
}
