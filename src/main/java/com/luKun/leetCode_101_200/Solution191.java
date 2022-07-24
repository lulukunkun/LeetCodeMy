package com.luKun.leetCode_101_200;

/**
 * @ClassName Solution191
 * @Description
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位
 * 数为 '1' 的个数（也被称为汉明重量）。
 * @Author LuKun
 * @Date 2022/7/22 14:43
 * @Version 1.0
 */
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        if(n==0)return 0;
        if (n>0) while (n!=0){
                if (n%2==1)count++;
                n>>=1;
            }
        else{
            n=~n;
            while (n!=0) {
                if (n % 2 == 1) count++;
                n >>= 1;
            }
            count=32-count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(~(-3));
    }

}
/*
* 我们可以直接循环检查给定整数n的二进制位的每一位是否为1。
具体代码中，当检查第i位时，我们可以让n与2进行与运算，当且仅当n的第i位为1时，运算结果不为0。
*/
class Solution_top1 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}

/*
* 观察这个运算：n&(n−1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
如：6&(6-1) = 4, 6 = (110), 4 = (100)
 ，运算结果 4 即为把 6 的二进制位中的最低位的 1变为 0 之后的结果。
这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 n 与 n - 1 做与运算，直到 n 变为 0 即可。
* 因为每次运算会使得 n 的最低位的 1 被翻转，因此运算次数就等于 n 的二进制位中 1 的个数。
*/
class Solution_top2 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


}
