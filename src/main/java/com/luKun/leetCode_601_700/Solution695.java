package com.luKun.leetCode_601_700;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Solution695
 * @Description 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须
 * 在水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0。
 * @Author LuKun
 * @Date 2022/7/16 10:45
 * @Version 1.0
 */
public class Solution695 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max_size = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    int temp=dist(grid, i, j);
                    System.out.printf("temp=%d\n",temp);
                    max_size = Math.max(temp, max_size);
                }
            }
        }
        return max_size;
    }

    public int dist(int[][] grid, int i, int j) {
        //下、右、左、上
        int sum = 1;
        for (int k = 0; k < 4; k++) {
            int mx = i + dx[k];
            int my = j + dy[k];
            if (mx >= 0 && my >= 0 && mx < m && my < n && grid[mx][my] == 1) {

                grid[mx][my] = 2;
                sum += dist(grid, mx, my) ;
                System.out.printf("mx=%d,my=%d,sum=%d\n",mx,my,sum);
            }
        }
        return sum;
    }
}
class Solution {//深度优先+栈
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Deque<Integer> stacki = new LinkedList<Integer>();
                Deque<Integer> stackj = new LinkedList<Integer>();
                stacki.push(i);
                stackj.push(j);
                while (!stacki.isEmpty()) {
                    int cur_i = stacki.pop(), cur_j = stackj.pop();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}

class test {
    public static void main(String[] args) {
        Solution695 solution695 = new Solution695();
        int[][] ints = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(solution695.maxAreaOfIsland(ints));
    }
}