package com.luKun.leetCode_1_100;

/**
 * @ClassName Solution14
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/6 17:01
 * @Version 1.0
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0)return "";
        if (strs.length==1)return strs[0];
        String temStrs=strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j=0;
            for (; j < temStrs.length(); j++) {
                if (j>=strs[i].length()-1)break;
                if (temStrs.charAt(j)!=strs[i].charAt(j))break;
            }
            try {
                temStrs=strs[i].substring(0,j-1);
                return temStrs;
            }catch (Exception e){
                return "";
            }

        }
        return "";
    }
    public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

}
