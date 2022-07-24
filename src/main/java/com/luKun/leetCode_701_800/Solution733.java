package com.luKun.leetCode_701_800;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution733
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/14 10:27
 * @Version 1.0
 */
public class Solution733 {
    /*深度优先搜索
     * 下、右、左、上
     *
     * 思路及算法
     * 我们从给定的起点开始，进行深度优先搜索。每次搜索到一个方格时，如果其与初始位置的方格颜色相同，
     * 就将该方格的颜色更新，以防止重复搜索；如果不相同，则进行回溯。
     * 注意：因为初始位置的颜色会被修改，所以我们需要保存初始位置的颜色，以便于之后的更新操作。
     * */
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor=image[sr][sc];
        if (currColor!=newColor) dfs(image,sr,sc,currColor,newColor);
        return image;
    }
    public void dfs(int[][] image,int x,int y,int currColor,int newColor){
        if (image[x][y]==currColor){
            image[x][y]=newColor;
            for (int i = 0; i < 4; i++) {
                int mx=x+dx[i],my=y+dy[i];
                if (mx>=0 && mx< image.length && my>=0 && my<image[0].length )
                    dfs(image,mx,my,currColor,newColor);
            }
        }
    }
}
/*广度优先搜索
* 下、右、左、上
*
* 我们从给定的起点开始，进行广度优先搜索。每次搜索到一个方格时，
* 如果其与初始位置的方格颜色相同，就将该方格加入队列，并将该方格的颜色更新，以防止重复入队。
* 注意：因为初始位置的颜色会被修改，所以我们需要保存初始位置的颜色，以便于之后的更新操作。
* */
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}

