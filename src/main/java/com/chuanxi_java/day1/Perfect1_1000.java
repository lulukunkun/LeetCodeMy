package com.chuanxi_java.day1;

/**
 * @ClassName Perfect1_1000
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/13 20:41
 * @Version 1.0
 */
public class Perfect1_1000 {
    public static void main(String[] args) {
        int sum=0;
        for (int i = 2; i <= 1000; i++) {
            for (int j = 1; j <= Math.pow(i,0.5); j++) {
                if (i%j==0){
                    sum+=j+i/j;
                }
            }
            if (sum==(i*2)) System.out.println(i);
            sum=0;
        }
    }
}
