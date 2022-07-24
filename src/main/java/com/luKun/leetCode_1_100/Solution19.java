package com.luKun.leetCode_1_100;

import com.luKun.bean.ListNode;

/**
 * @ClassName Solution19
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/13 11:06
 * @Version 1.0
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null)return null;
        ListNode cul=head;
        int sz=0;
        while (true){
            if (cul==null){
                break;
            }
            if (cul.next==null){
                sz++;
                break;
            }
            cul=cul.next.next;
            sz+=2;
        }

        if ((sz-n)==0)return head.next;
        cul=head;
        for (int i = 0; i < sz-n; i++) {
            cul=cul.next;
        }
        cul.next=cul.next.next;
        return head;
    }
}
