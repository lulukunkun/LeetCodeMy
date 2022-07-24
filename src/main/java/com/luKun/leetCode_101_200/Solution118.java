package com.luKun.leetCode_101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution118
 * @Description
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Author LuKun
 * @Date 2022/7/22 10:47
 * @Version 1.0
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        int[][] tmp=new int[numRows][numRows];
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int y=0; y <= i; y++) {
                if (y==0||y==i) tmp[i][y]=1;
                else tmp[i][y]=tmp[i-1][y]+tmp[i-1][y-1];
                list.add(tmp[i][y]);
            }
            lists.add(list);
        }

        return lists;
    }
    public List<List<Integer>> generate_test1(int numRows) {
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int y=0; y <= i; y++) {
                if (y==0||y==i) list.add(1);
                else {
                    List<Integer> integers = lists.get(i - 1);
                    list.add(integers.get(y)+integers.get(y-1));
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
