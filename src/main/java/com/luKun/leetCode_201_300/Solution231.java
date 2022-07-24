package com.luKun.leetCode_201_300;

/**
 * @ClassName Solution231
 * @Description
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 * @Author LuKun
 * @Date 2022/7/22 11:13
 * @Version 1.0
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        while (n%2==0&&n!=1&&n!=0) n/=2;
        if (n==1) return true;
        else return false;
    }
    public boolean isPowerOfTwo_test1(int n) {
        while (n%2==0&&n!=1&&n!=0) n>>=1;
        if (n==1) return true;
        else return false;
    }

    /*
    仙术：3
    return n > 0 && (n & (n - 1)) == 0;
    return n > 0 && (n & -n) == n;

    static final int BIG = 1 << 30;
    return n > 0 && BIG % n == 0;


    * */
}
