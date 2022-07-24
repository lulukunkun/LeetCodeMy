package com.luKun.bean;

import lombok.Data;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/17 18:43
 * @Version 1.0
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
