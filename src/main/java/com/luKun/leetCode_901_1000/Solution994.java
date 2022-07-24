package com.luKun.leetCode_901_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution994
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/19 20:09
 * @Version 1.0
 */
public class Solution994 {
    int system_time = 0;

    public int orangesRotting(int[][] grid) {
        int count=0;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if (grid[i][j]==1){
                    count++;
                }
            }
        }
        int[] dx=new int[]{1,-1,0,0};
        int[] dy=new int[]{0,0,1,-1};
        boolean flag=false;
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int t = 0; t < size; t++) {
                int[] tmp= queue.poll();
                int i=tmp[0],j=tmp[1];
                for (int k = 0; k < 4; k++) {
                    int mx=i+dx[k];
                    int my=j+dy[k];
                    if (mx>=0&&mx<grid.length &&my>=0 &&my<grid[0].length&&grid[mx][my]==1){
                        flag=true;
                        grid[mx][my]=2;
                        queue.offer(new int[]{mx,my});
                        count--;
                    }
                }

            }
            system_time=flag?system_time+1:system_time;
            flag=false;

        }
        if (count==0)
        return system_time;
        else return -1;
    }
}
