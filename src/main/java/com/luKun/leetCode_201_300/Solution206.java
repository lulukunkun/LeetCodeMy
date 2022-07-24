package com.luKun.leetCode_201_300;

import com.luKun.bean.ListNode;

/**
 * @ClassName Solution206
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/13 14:16
 * @Version 1.0
 */
public class Solution206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head, nextNode = head.next;
        tmp.next = null;
        while (nextNode != null) {
            head = nextNode;
            nextNode = nextNode.next;
            head.next = tmp;
            tmp = head;
        }
        return head;
    }

    public static ListNode reverseList_test1(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next=null;
            head.next = tmp;
            return head;
        } else{
            ListNode tmp=head.next;
            tmp=reverseList_test1(tmp);
            ListNode test=tmp;
            while (test.next!=null){
                test=test.next;
            }
            head.next=null;
            test.next=head;
            return tmp;
        }
    }
    public ListNode reverseList_top1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_top1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(6);
        node.next.next = new ListNode(7);
        node.next.next.next = new ListNode(8);

        System.out.println(reverseList_test1(node));
    }
}
