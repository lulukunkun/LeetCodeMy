package com.luKun.leetCode_1_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution20
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/8 8:33
 * @Version 1.0
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.size() == 0)
                list.add(s.charAt(i));
            else if (is_match(list.get(list.size() - 1), s.charAt(i))) {

                list.remove(list.size() - 1);
            }else {
                list.add(s.charAt(i));
            }
        }
        return list.size()==0;
    }

    public boolean is_match(Character c1, Character c2) {
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;
        if (c1 == '{' && c2 == '}') return true;
        return false;

    }
    public boolean isValid_top1(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> box = new Stack<>();

        for (int i = 0;i < chs.length;i ++) {
            if (chs[i] == '(') {
                box.push(')');
            } else if(chs[i] == '[') {
                box.push(']');
            } else if(chs[i] == '{') {
                box.push('}');
            } else {
                if (box.empty() || box.pop() != chs[i]) {
                    return false;
                }
            }
        }
        if (box.size() == 0) {
            return true;
        }
        return false;


    }

}

class tes {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();


    }
}
