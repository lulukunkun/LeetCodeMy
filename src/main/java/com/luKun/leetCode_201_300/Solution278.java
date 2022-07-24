package com.luKun.leetCode_201_300;

/**
 * @ClassName Solution278
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/11 10:19
 * @Version 1.0
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
*/
public class Solution278 {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int right = n;
        int left = 1;
        int middle = 0;
        while (right >= left) {
            middle = (right - left) / 2 + left;
            if (isBadVersion(middle)) right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }

    public int firstBadVersion_official(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }
}
