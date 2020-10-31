package com.banxian.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 128. 最长连续序列
 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

  

 进阶：

 你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
  

 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 示例 2：

 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 输出：9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 */
public class Test128 {

    public static void main(String[] args) {

        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    /**

     哈希表+动态规划
     本题目要求时间复杂度为O(n)O(n)，因此我们在遍历的过程中查找是否有与当前相连的数字需要用到哈希表，
     这样才能保证每次查找都是O(1)O(1)复杂度，
     核心思想就是拿当前数字去找与其左右相连的数字集合看看能否组成一个更大的集合，
     并更新两端的最长值，过程中遇到哈希表中已存在的值就跳过，并且维护一个最大值用于返回。
     链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/javaliang-chong-fang-fa-luo-ji-qing-xi-yi-kan-jiu-/
     * @param nums
     * @return
     */

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);
            int len = left + right + 1;
            max = Math.max(max, len);
            map.put(nums[i], len);
            map.put(nums[i] - left, len);
            map.put(nums[i] + right, len);
        }
        return max;
    }

}
