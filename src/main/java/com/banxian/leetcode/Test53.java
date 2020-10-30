package com.banxian.leetcode;

/**
 * Created by liughl on 2020/10/29.
 */
public class Test53 {

    public static void main(String[] args) {
        int [] num = new int[]{-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(maxSubArray(num));
    }


    /**
     * 从第一位开始加，变负就置为0，重新开始累加，每次迭代保留最大值
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i < nums.length;++i) {
            sum += nums[i];
            max = Math.max(sum,max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }


    public  static  int maxSubArray1(int[] nums) {
        //当前最大连续子序列和为 sum，结果为 ans
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            //如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
            if(sum > 0) {
                sum += num;
            }
            //如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
            else {
                sum = num;
            }
            //每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
