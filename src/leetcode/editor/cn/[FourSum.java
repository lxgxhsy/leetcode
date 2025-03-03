  /**
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b],
 nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 

 
 0 <= a, b, c, d < n 
 a、b、c 和 d 互不相同 
 nums[a] + nums[b] + nums[c] + nums[d] == target 
 

 你可以按 任意顺序 返回答案 。 

 

 示例 1： 

 
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 

 示例 2： 

 
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
 

 

 提示： 

 
 1 <= nums.length <= 200 
 -10⁹ <= nums[i] <= 10⁹ 
 -10⁹ <= target <= 10⁹ 
 

 Related Topics 数组 双指针 排序 👍 2034 👎 0

*/
  /**
 * 四数之和
 * @author sy
 * @date 2025-03-03 21:15:36
 */
  package leetcode.editor.cn;

  import java.util.Arrays;
  import java.util.LinkedList;
  import java.util.List;

  class FourSum{
      public static void main(String[] args) {
           Solution solution = new FourSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        if(nums.length < 4){
            return ans;
        }
        int a,b,c,d;
         // a + b + c + d = target
        for( a = 0 ; a < nums.length - 3; a ++){
            // 不能有重复的四元组
            if(a > 0 && nums[a] == nums[a - 1])continue;
            for(b = a + 1; b < nums.length - 2; b ++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                // 找出nums[c] + nums[d] = target - nums[a] - nums[b]
                c = b + 1;
                d = nums.length - 1;
                long tmp = (long)target - nums[a] - nums[b];
                // 两数之和
                while (c < d) {
                    //如果小于的话
                    int res = nums[c] + nums[d];
                    if (res == tmp) {
                        // 找到了 存进去
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c ++;
                        d --;
                        //往后走
                        while (c < d && nums[c] == nums[c - 1]) c ++;
                        while (c < d && nums[d] == nums[d + 1]) d --;
                    } else if (res > tmp) {
                        d --;
                    } else {
                        c ++;
                    }
                }
            }
            }
            return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }