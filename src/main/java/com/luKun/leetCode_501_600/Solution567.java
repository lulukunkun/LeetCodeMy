package com.luKun.leetCode_501_600;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.HashMap;

/**
 * @ClassName Solution567
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/11 19:01
 * @Version 1.0
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        boolean flag=true;
        int[] s1_nums=new int[26];//模板数组
        int[] s2_nums=new int[26];//滑动窗口数组
        for (int i = 0; i < s1.length(); i++) {
            s1_nums[s1.charAt(i)-97]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s1.length() > s2.substring(i).length()) return false;
            String tmp = s2.substring(i, i + s1.length());
            for (int j = 0; j < tmp.length(); j++) {
                s2_nums[tmp.charAt(j)-97]++;
            }
            for (int j = 0; j < 26; j++) {
                if (s1_nums[j]!=s2_nums[j]){
                    flag=false;
                    break;
                }
            }
            s2_nums=new int[26];
            if (flag)return true;
            else flag=true;
        }
        return false;
    }

    public boolean checkInclusion_wlg(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),1+map.getOrDefault(s1.charAt(i),0));
        }
        int left = 0,index = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))){
                if (map.get(s2.charAt(i))>0){
                    map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                    index++;
                }else {
                    if (s2.charAt(left)==s2.charAt(i)){
                        left++;
                    }else{
                        while (s2.charAt(left)!=s2.charAt(i)){
                            map.put(s2.charAt(left),map.get(s2.charAt(left))+1);
                            index--;
                            left++;
                        }
                        left++;
                    }
                }
            }else{
                while (left<i){
                    map.put(s2.charAt(left),map.get(s2.charAt(left))+1);
                    left++;
                }
                left++;
                index=0;
            }
            if (index == s1.length())
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("12",12);
        System.out.println(map.clone());
    }

}
