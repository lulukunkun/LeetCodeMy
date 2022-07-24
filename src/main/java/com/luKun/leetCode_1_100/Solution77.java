package com.luKun.leetCode_1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution77
 * @Description
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * @Author LuKun
 * @Date 2022/7/21 16:57
 * @Version 1.0
 */
public class Solution77 {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> tmp=new ArrayList<>();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        dist(1);
        return lists;
    }
    public void dist(int cur){
        if (tmp.size()+n-cur+1<k)return;
        if (tmp.size()==k){
            lists.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(cur);
        dist(cur+1);
        tmp.remove(tmp.size()-1);
        dist(cur+1);
    }
}
class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }
/*回溯法（递归）
* 当前位置是 cur，原序列总长度为 n
* */
    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
/*
非递归、字典序法
* */
class Solution_nan {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i) {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }
}


