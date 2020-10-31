package com.banxian.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**

 139. 单词拆分
 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

 说明：

 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。
 示例 1：

 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 示例 2：

 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 输出: true
 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
      注意你可以重复使用字典中的单词。
 示例 3：

 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-break
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Test139 {


    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak2("leetcode",wordDict));
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <dp.length ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                dp[i]=dp[j]&&wordDict.contains(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }






    /*


    作者：RED_DEVIL
    链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-ju-jue-zhuang-xcong-jian-dan-de-xi/

        动态规划算法，dp[i]表示s前i个字符能否拆分
        转移方程：dp[j] = dp[i] && check(s[i+1, j]);
        check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
        其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
        这个举个例子就很容易理解。
        假如wordDict=["apple", "pen", "code"],s = "applepencode";
        dp[8] = dp[5] + check("pen")
        翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
        （注意：i的顺序是从j-1 -> 0哦~
    */

    static HashMap<String, Boolean> hash = new HashMap<>();


    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        //方便check，构建一个哈希表
        for(String word : wordDict){
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for(int j = 1; j <= s.length(); j++){
            for(int i = j-1; i >= 0; i--){
                dp[j] = dp[i] && check(s.substring(i, j));
                if(dp[j])   break;
            }
        }

        return dp[s.length()];
    }

    public static boolean check(String s){
        //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
        return hash.getOrDefault(s, false);
    }


}
