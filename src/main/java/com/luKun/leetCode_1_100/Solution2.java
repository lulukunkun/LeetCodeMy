package com.luKun.leetCode_1_100;

import com.luKun.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution2
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/3 20:00
 * @Version 1.0
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x1=-1;
        int x2=-1;
        int num1=0;
        int num2=0;
        int su=0;
        int count=0;
        int flag=0;
        ListNode listNode = new ListNode();
        ListNode listNode1=listNode;
        List<String> sum=new ArrayList<>();
        while (true){
            if (count==0){
                sum.add(String.valueOf(l1.val+ l2.val));
                count++;
            }else {
                sum.add(String.valueOf(su));
            }
            if (l1.next==null)x1=0;
            if (l2.next==null)x2=0;
            if (x1+x2==-2)continue;
            if (x1==-1){
                su=l1.next.val;
            }
            if (x2==-1){
                su=l2.next.val;
            }

            if(x1+x2==0)break;

        }
        for (String s : sum) {
            if (s.length()==1) {
                int ss=Integer.parseInt(s)+flag;
                if (ss>10){
                    ss=ss%10;
                    flag=1;
                }
                listNode1.val=ss;
                flag=0;
            }else {
                flag=1;
                s=s.substring(1);
                int ss=Integer.parseInt(s)+flag;
                if (ss>10){
                    ss=ss%10;
                    flag=1;
                }
                listNode1.val=ss;

            }
            listNode1=listNode1.next;
        }
        return listNode;
    }

    public static void main(String[] args) {
        String tt="123";
    }

    public ListNode addTwoNumbers_Top1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 辅助节点
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            pre.next = new ListNode(sum % 10);
            carry = sum / 10;

            pre = pre.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) pre.next = new ListNode(carry);

        return dummy.next;
    }

    public ListNode test(ListNode l1, ListNode l2){
        ListNode listNode = new ListNode();
        ListNode newList=listNode;
        int num1=0;
        int num2=0;
        int sum=0;
        int count10=0;
        while (l1 !=null || l2 !=null){
            num1=l1==null?0:l1.val;
            num2=l2==null?0: l2.val;
            sum=num1+num2+count10;
            count10=sum/10;
            newList.next=new ListNode(sum%10);
            newList=newList.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if (count10!=0)newList.next=new ListNode(count10);
        return listNode.next;
    }

}

