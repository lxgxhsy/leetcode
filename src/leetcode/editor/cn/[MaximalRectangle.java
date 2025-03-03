  /**
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 

 

 示例 1： 
 
 
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],[
"1","0","0","1","0"]]
输出：6
解释：最大矩形如上图所示。
 

 示例 2： 

 
输入：matrix = [["0"]]
输出：0
 

 示例 3： 

 
输入：matrix = [["1"]]
输出：1
 

 

 提示： 

 
 rows == matrix.length 
 cols == matrix[0].length 
 1 <= row, cols <= 200 
 matrix[i][j] 为 '0' 或 '1' 
 

 Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1716 👎 0

*/
  /**
 * 最大矩形
 * @author sy
 * @date 2025-02-27 10:55:33
 */
  package leetcode.editor.cn;
   class MaximalRectangle{
      public static void main(String[] args) {
           Solution solution = new MaximalRectangle().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                }
            }
        }

        // 求面积
        int area = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '0') continue;
                int len = dp[i][j];
                // 求高
                for (int k = i; k >= 0 && matrix[k][j] == '1'; k --) {
                    len = Math.min(dp[k][j], len);
                    area = Math.max(len * (i - k + 1) , area);
                }
            }
        }
          return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }



