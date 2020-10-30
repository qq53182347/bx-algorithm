package com.banxian.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 1. 两数之和
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 */
public class Test1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 12, 11, 7};
        System.out.println(Arrays.toString(twoSum2(nums,9)));
    }

    public static int[] twoSum2(int[] nums, int target) {
        return  null;
    }

//
//    public  static int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        if(nums == null || nums.length < 2){
//            return null;
//        }
//        for(int i = 0;i < nums.length-1;i++){
//            for(int j = i+1;j < nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//            }
//        }
//        return null;
//    }
//
//    public static int[] twoSum2(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(target-nums[i])){
//                return new int[] {map.get(target-nums[i]),i};
//            }
//            map.put(nums[i],i);
//        }
//        return  null;
//    }

}
