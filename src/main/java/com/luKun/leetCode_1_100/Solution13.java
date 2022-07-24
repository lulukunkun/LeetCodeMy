package com.luKun.leetCode_1_100;

import java.util.HashMap;

/**
 * @ClassName Solution13
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/6 8:18
 * @Version 1.0
 */
public class Solution13 {
    static HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }
    /*
    递归方法实现,效率不够高，用时5ms
     */
    public int romanToInt(String s) {
        if (s==null||"".equals(s.trim()))return 0;
        String s1=null;
        String s2=null;
        if (s.length()==1){
            return map.get(s);
        }else {
            switch (s.substring(0,2)){
                case "IV":return 4+romanToInt(s.substring(2));
                case "IX":return 9+romanToInt(s.substring(2));
                case "XL":return 40+romanToInt(s.substring(2));
                case "XC":return 90+romanToInt(s.substring(2));
                case "CD":return 400+romanToInt(s.substring(2));
                case "CM":return 900+romanToInt(s.substring(2));
                default:return map.get(s.substring(0,1))+romanToInt(s.substring(1));
            }
        }
    }
    /*
    遍历方式，用时4ms
     */
    public int romanToInt1(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            int a = map.get(s.substring(i,i+1));
            if(i != s.length()-1){
                int b = map.get(s.substring(i+1,i+2));
                if(a<b){
                    a = -a;
                }
            }
            num = num + a;
        }
        return num;
    }
    /*
    用时2ms,事实证明查询map所需要的时间大于调用函数做if判断
     */
    public int romanToInt2(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            int a = romanNum(s.charAt(i));
            if(i != s.length()-1){
                int b = romanNum(s.charAt(i+1));
                if(a<b){
                    a = -a;
                }
            }
            num = num + a;
        }
        return num;
    }

    public int romanNum(char a){
        if(a == 'I'){
            a = 1;
        }
        else if(a=='V'){
            a = 5;
        }
        else if(a=='X'){
            a=10;
        }
        else if(a=='L'){
            a = 50;
        }
        else if(a=='C'){
            a = 100;
        }
        else if(a=='D'){
            a = 500;
        }
        else if(a=='M'){
            a = 1000;
        }
        return a;
    }
}
