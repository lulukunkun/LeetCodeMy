package com.luKun.leetCode_101_200;

import com.luKun.bean.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution116
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/17 21:17
 * @Version 1.0
 */
public class Solution116 {
    public Node connect(Node root) {
        if (root==null)return null;
        Queue<Node> queue=new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            //每一层的所有节点数
            int size=queue.size();
            //遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                //从队首取出元素
                Node node = queue.poll();
                //连接
                if (i<size-1) {
                    node.next = queue.peek();
                }
                //扩展下一次节点
                if (node.left!=null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

            }
        }
        return root;
    }
    /*
    * 使用已建立的 next 指针
    * 算法：
    * 第 N层节点之间建立 next 指针后，再建立第 N+1 层节点的 next 指针。可以通过 next 指针访问同一层的所有节点，
    * 因此可以使用第 N 层的 next 指针，为第 N+1 层节点建立 next 指针。
    * */
    public Node connect_test1(Node root) {
        Node result=root;
        if (root==null)return null;
        while (root.left!=null){
            Node left_head=root.left;
            while (root.next!=null){
                root.left.next=root.right;
                root.right.next=root.next.left;
                root=root.next;
            }
            root.left.next=root.right;
            root=left_head;
        }
        return result;
    }
/*
* 递归
上面两种方式是属于横向的视角，而递归则像是一个深度的视角。
以从上往下的方向看，1，2，3，5，6这几个节点在位置上都是紧挨着的，
* 同时这几个节点都是左右串联的。
* 我们以当前节root点为起始，左右节点不断的深入下面，left节点不断往右走，right节点不断往左走，当这两个节点走到底后，整个纵深这段就完成了串联。
递归函数实现如下：

终止条件：当前节点为空时
函数内：以当前节点为起始，完成从上往下的纵深串联，再递归的调用当前节点left和right
时间复杂度：O(n)O(n)
空间复杂度：O(h)O(h)，hh 是树的高度
*/
    public Node connect_test2(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root==null)return;
        Node left=root.left;
        Node right=root.right;
        while (left!=null){
            left.next=right;
            left=left.right;
            right=right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
