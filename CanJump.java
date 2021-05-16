package com.test.week04;

public class CanJump {


    /**
     * 暴力贪心：从第一个位置开始起跳，把每一步能跳的最大值保存起来，若最大值小于当前要跳到的位置，则不可以跳到最后
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
            if (k >= nums.length) {
                return true;
            }
        }
        return true;
    }
}
