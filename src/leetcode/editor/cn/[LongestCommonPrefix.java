  /**
编写一个函数来查找字符串数组中的最长公共前缀。 

 如果不存在公共前缀，返回空字符串 ""。 

 

 示例 1： 

 
输入：strs = ["flower","flow","flight"]
输出："fl"
 

 示例 2： 

 
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。 

 

 提示： 

 
 1 <= strs.length <= 200 
 0 <= strs[i].length <= 200 
 strs[i] 如果非空，则仅由小写英文字母组成 
 

 Related Topics 字典树 字符串 👍 3275 👎 0

*/
  /**
 * 最长公共前缀
 * @author sy
 * @date 2025-02-27 10:33:17
 */
  package leetcode.editor.cn;
   class LongestCommonPrefix{
      public static void main(String[] args) {
           Solution solution = new LongestCommonPrefix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        // 暴力解决一下吧 先比较
        for (int i = 1; i < n; i++) {
            int j = 0;
            for ( j = 0; j < prefix.length() && j < strs[i].length() ; j++) {
                    if(prefix.charAt(j) != strs[i].charAt(j)){
                        break;
                    }
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }