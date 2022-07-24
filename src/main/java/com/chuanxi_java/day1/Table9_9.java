package com.chuanxi_java.day1;

/**
 * @ClassName Table9_9
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/13 20:25
 * @Version 1.0
 */
public class Table9_9 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d\t",i*j);
            }
            System.out.println();
        }
    }
}
