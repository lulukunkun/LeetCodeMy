package com.luKun.leetCode_801_900;

/**
 * @ClassName Solution876
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/13 10:33
 * @Version 1.0
 */

import com.luKun.bean.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode v1=head,v2=head;
        while (v2!=null&&v2.next!=null){
            v1=v1.next;
            v2=v2.next.next;
        }
        return v1;
    }
}
