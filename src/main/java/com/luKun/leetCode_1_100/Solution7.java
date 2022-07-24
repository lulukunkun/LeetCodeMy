package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution7
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/14 20:20
 * @Version 1.0
 */
public class Solution7 {
    public static int reverse(int x) {
//        if(x==1534236469)return 0;
//        if(x==-2147483648)return 0;
        return x>0?revInt(x):-revInt(-x);
    }
    public static int revInt(int x){
        int sum=0;
        while (x!=0){
            if (sum>(Integer.MAX_VALUE)||sum>(Integer.MAX_VALUE)/10)return 0;
            sum*=10;
            sum+=x%10;
            x/=10;
            System.out.println(sum);
        }
        return sum>0?sum:0;
    }

    public static void main(String[] args) {
        reverse(1534236469);
        //1056389759
        //2147483647
        System.out.println(Integer.MAX_VALUE);
    }
}
