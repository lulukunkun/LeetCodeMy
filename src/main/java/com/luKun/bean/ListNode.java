package com.luKun.bean;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/5 9:13
 * @Version 1.0
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(val).append(",");

        while (next != null) {
            buffer.append(next.val).append(",");
            next=next.next;
        }
        return buffer.toString();
    }
}
