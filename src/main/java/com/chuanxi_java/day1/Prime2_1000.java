package com.chuanxi_java.day1;

/**
 * @ClassName Prime2_1000
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/13 20:30
 * @Version 1.0
 */
public class Prime2_1000 {
    public static void main(String[] args) {
        boolean flag=true;
        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= Math.pow(i,0.5); j++) {
                if (i%j==0){
                    flag=false;
                    break;
                }
            }
            if (flag) System.out.println(i);
            flag=true;
        }
    }
}
