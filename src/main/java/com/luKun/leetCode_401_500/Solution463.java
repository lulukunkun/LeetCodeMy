package com.luKun.leetCode_401_500;

/**
 * @ClassName Solution463
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/15 11:01
 * @Version 1.0
 */
public class Solution463 {
    /*
    * 深度优先算法
    * 1、遍历数组，从小岛的某个位置开始深度优先搜索，且搜索范围仅仅在小岛范围内
    * 2、明确边长sum++的条件，下一次遍历的格子脚标超出小岛脚标范围，即下一次遍历的格子脚标越界或格子内值为0
    * 3、开始搜索的点标记（表示已经检索），之后每次搜索后的值都要进行标记*/
    //下、右、上、左
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int sum;
    int m;//数组行数
    int n;//数组列数
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j]=2;
                    dist(grid, i, j);
                }
            }
        }
        return sum;
    }

    public void dist(int[][] grid, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int mx = i + dx[k];
            int my = j + dy[k];
            boolean tandition=mx >= 0 && mx < m && my >= 0 && my < n;
            if (mx == -1 || my == -1 || mx == m  || my == n ||(tandition&&grid[mx][my] == 0)) sum++;
            if (tandition && grid[mx][my] == 1) {
                grid[mx][my] = 2;
                dist(grid, mx, my);
            }
        }
    }
}
class Solution{
    public int islandPerimeter(int[][] grid) {
        int land = 0; // 土地个数
        int border = 0; // 接壤边界的条数

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        border++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        border++;
                    }
                }
            }
        }
        return 4 * land - 2 * border;
    }
}
class test {
    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        System.out.println(solution463.islandPerimeter(new int[][]{{1}}));

    }
}
