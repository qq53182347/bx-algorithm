package com.banxian.leetcode;

import java.util.HashMap;
import java.util.Map;

/**

 136. 只出现一次的数字
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4


 */
public class Test136 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,2,3,3,4,4};
        System.out.println(singleNumber( nums));
    }


    /**

     异或解法：异或运算满足交换律，a^b^a=a^a^b=b,因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
     然后再根据交换律把相等的合并到一块儿进行异或（结果为0），然后再与只出现过一次的元素进行异或，
     这样最后的结果就是，只出现过一次的元素（0^任意值=任意值）

     异或有交换律定理，相当于将相同的数字先异或，这样两两异或就只剩0了
     然后0再和最后的一个数字异或得到最终值
     * @param nums
     * @return
     */
    public  static int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }


}
