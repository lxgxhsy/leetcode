  /**
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 

 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 

 

 示例 1： 

 
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 

 示例 2： 

 
输入：nums = [0]
输出：[[],[0]]
 

 

 提示： 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 nums 中的所有元素 互不相同 
 

 Related Topics 位运算 数组 回溯 👍 2440 👎 0

*/
  /**
 * 子集
 * @author sy
 * @date 2025-02-27 11:11:55
 */
  package leetcode.editor.cn;

  import java.util.LinkedList;
  import java.util.List;

  class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0;i < (1 << n); i ++){
            List<Integer> tmp = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if(((i >> j) & 1) == 1) tmp.add(nums[j]);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }