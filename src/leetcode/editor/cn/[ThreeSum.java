  /**
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 

 注意：答案中不可以包含重复的三元组。 

 

 

 示例 1： 

 
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
 

 示例 2： 

 
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
 

 示例 3： 

 
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 

 

 提示： 

 
 3 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 

 Related Topics 数组 双指针 排序 👍 7304 👎 0

*/
  /**
 * 三数之和
 * @author sy
 * @date 2025-02-26 22:34:47
 */
  package leetcode.editor.cn;

  import java.util.Arrays;
  import java.util.LinkedList;
  import java.util.List;


  class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();

        for(int i = 0; i < nums.length; i ++){
            // 不能有重复的三元组
            if(i > 0 && nums[i] == nums[i - 1])continue;
            // 找出nums[i] + nums[j] == -nums[k]
            int l = i + 1, r = nums.length - 1;
            int target = - nums[i];
            // 两数之和
            while(l < r){
                //如果小于的话
                int res = nums[l] + nums[r];
                if(res == target){
                   // 找到了 存进去
                   ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                   r --;
                   l ++;
                   //往后走
                  while(l < r && nums[l] == nums[l - 1]) l ++;
                  while(l < r && nums[r] == nums[r + 1]) r --;
                }else if(res > target){
                    r --;
                }else{
                    l ++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }