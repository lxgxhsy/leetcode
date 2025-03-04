  /**
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 

 求在该柱状图中，能够勾勒出来的矩形的最大面积。 

 

 示例 1: 

 

 
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
 

 示例 2： 

 

 
输入： heights = [2,4]
输出： 4 

 

 提示： 

 
 1 <= heights.length <=10⁵ 
 0 <= heights[i] <= 10⁴ 
 

 Related Topics 栈 数组 单调栈 👍 2878 👎 0

*/
  /**
 * 柱状图中最大的矩形
 * @author sy
 * @date 2025-03-04 22:43:30
 */
  package leetcode.editor.cn;

  import java.util.Stack;

  class LargestRectangleInHistogram{
      public static void main(String[] args) {
           Solution solution = new LargestRectangleInHistogram().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int largestRectangleArea(int[] heights) {
           // 思路就是记录最左边第一个比自己小的地方 记录最右边第一个比自己大的地方 width = r - l + 1
           int n = heights.length;
           int[] l = new int[n];
           int[] r = new int[n];

           Stack<Integer> stack = new Stack<>();
           for(int index = 0; index < n;index ++){
               while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]){
                   stack.pop();
               }
              l[index] = stack.isEmpty() ? -1 : stack.peek();
               stack.push(index);
           }
           stack.clear();

              for(int index = n - 1; index >= 0;index --){
                  while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]){
                      stack.pop();
                  }
                  r[index] = stack.isEmpty() ? n : stack.peek();
                  stack.push(index);
              }

              //计算面积
              int maxV = 0;
              int area = 0;
              for (int i = 0; i < n; i++) {
                  int width = r[i] - l[i] - 1;
                  area = width * heights[i];
                  maxV = Math.max(area,maxV);
              }
              return maxV;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }