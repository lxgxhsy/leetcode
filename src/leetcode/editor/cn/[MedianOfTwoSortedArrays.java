  /**
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 

 算法的时间复杂度应该为 O(log (m+n)) 。 

 

 示例 1： 

 
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
 

 示例 2： 

 
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 

 

 

 提示： 

 
 nums1.length == m 
 nums2.length == n 
 0 <= m <= 1000 
 0 <= n <= 1000 
 1 <= m + n <= 2000 
 -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
 

 Related Topics 数组 二分查找 分治 👍 7417 👎 0

*/
  /**
 * 寻找两个正序数组的中位数
 * @author sy
 * @date 2025-03-04 22:15:04
 */
  package leetcode.editor.cn;
   class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
           Solution solution = new MedianOfTwoSortedArrays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public double findMedianSortedArrays(int[] nums1, int[] nums2) {
              int n = nums1.length;
              int m = nums2.length;
              int totalLength = n + m;
              int count = 1;

              // 求出 floor(log2(m + n)) + 1
              for (int i = 1; i <= totalLength; i *= 2) {
                  count++;
              }

              int l1 = 0, r1 = n - 1, l2 = 0, r2 = m - 1;

              while (l1 <= r1 && l2 <= r2 && count != 0) {
                  int mid1 = ((r1 - l1) >> 1) + l1;
                  int mid2 = ((r2 - l2) >> 1) + l2;

                  if (nums1[mid1] <= nums2[mid2]) {
                      if ((n + m) % 2 == 1) {
                          if (mid1 + mid2 == (n + m) / 2) {
                              return nums2[mid2];
                          }
                      } else {
                          if (mid1 + mid2 == (n + m) / 2 - 1) {
                              return (nums1[mid1] + nums2[mid2]) / 2.0;
                          }
                      }
                      l1 = mid1 + 1;
                  } else {
                      if ((n + m) % 2 == 1) {
                          if (mid1 + mid2 == (n + m) / 2) {
                              return nums1[mid1];
                          }
                      } else {
                          if (mid1 + mid2 == (n + m) / 2 - 1) {
                              return (nums1[mid1] + nums2[mid2]) / 2.0;
                          }
                      }
                      l2 = mid2 + 1;
                  }
                  count--;
              }

              // 如果一个数组已经遍历完，直接在另一个数组中找中位数
              if (l1 > r1) {
                  return findMedianSingleArray(nums2, l2, r2, totalLength);
              } else {
                  return findMedianSingleArray(nums1, l1, r1, totalLength);
              }
          }

          private double findMedianSingleArray(int[] nums, int left, int right, int totalLength) {
              int len = right - left + 1;
              if (len % 2 == 1) {
                  return nums[left + len / 2];
              } else {
                  return (nums[left + len / 2 - 1] + nums[left + len / 2]) / 2.0;
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }