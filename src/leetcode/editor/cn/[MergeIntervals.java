  /**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 

 

 示例 1： 

 
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 

 示例 2： 

 
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

 

 提示： 

 
 1 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= starti <= endi <= 10⁴ 
 

 Related Topics 数组 排序 👍 2515 👎 0

*/
  /**
 * 合并区间
 * @author sy
 * @date 2025-02-26 13:26:14
 */
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Comparator;

  class MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] pre = intervals[0];
        int idx = 0;
        for (int i = 1; i < intervals.length; i ++) {
            int[] a = intervals[i];
            //下一个区间左端点小于老区间右端点 合并
            if (a[0] <= pre[1]){
                // 可以合并
                int res = Math.max(a[1],pre[1]);
                pre = new int[]{pre[0],res};
            }else {
               // 不能合并将pre加到集合里面
                intervals[idx ++] = pre;
                pre = a;
            }
        }
        // 记录最后一个区间
        intervals[idx ++] = pre;
        //最后一个合并区间,判断条件防止list为空
        return Arrays.copyOfRange(intervals,0, idx);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }