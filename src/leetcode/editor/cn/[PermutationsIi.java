  /**
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 

 

 示例 1： 

 
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 

 示例 2： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 

 提示： 

 
 1 <= nums.length <= 8 
 -10 <= nums[i] <= 10 
 

 Related Topics 数组 回溯 排序 👍 1685 👎 0

*/
  /**
 * 全排列 II
 * @author sy
 * @date 2025-03-03 23:02:22
 */
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          boolean[] st;
          public List<List<Integer>> permuteUnique(int[] nums) {
              List<List<Integer>> ans = new ArrayList<>();
              Arrays.sort(nums);
              st = new boolean[nums.length];
              dfs(nums, new ArrayList<>(), ans ,st);
              return ans;
          }

          public void dfs(int[] nums, List<Integer> path, List<List<Integer>> ans, boolean[] st) {
              if (path.size() == nums.length) {
                  ans.add(new ArrayList<>(path));
                  return;
              }
              for (int i = 0; i < nums.length; i ++) {
                  if (st[i]) continue;
                  if (i > 0 && nums[i] == nums[i - 1] && !st[i - 1]) continue; // 去重
                  st[i] = true;
                  path.add(nums[i]);
                  dfs(nums, path, ans,st);
                  path.remove(path.size() - 1);
                  st[i] = false;
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }