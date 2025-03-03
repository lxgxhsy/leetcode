  /**
给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 

 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 

 返回被除数 dividend 除以除数 divisor 得到的 商 。 

 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231
 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 

 

 示例 1: 

 
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 

 示例 2: 

 
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 

 

 提示： 

 
 -2³¹ <= dividend, divisor <= 2³¹ - 1 
 divisor != 0 
 

 Related Topics 位运算 数学 👍 1276 👎 0

*/
  /**
 * 两数相除
 * @author sy
 * @date 2025-03-03 22:24:04
 */
  package leetcode.editor.cn;
   class DivideTwoIntegers{
      public static void main(String[] args) {
           Solution solution = new DivideTwoIntegers().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int divide(int dividend, int divisor) {
              //记录数位 符号
              boolean flag = false;
              long INF = Integer.MAX_VALUE;
              long a = dividend, b = divisor;
              if((a < 0 && b > 0 ) || (a > 0 && b < 0)) flag = true;
              if(a < 0) a = - a;
              if(b < 0)b = - b;
              long l = 0, r = a;
              while(l <= r) {
                  long mid = l + ((r - l) >> 1);
                  if (mul(mid, b) <= a) l = mid + 1;
                  else r = mid - 1;
              }
                  r = flag ? -r : r;
                  if (r > INF || r < -INF - 1) return (int)INF;
                  return (int)r;

          }


          //10 8  1
          private long mul(long a, long k){
              long ans = 0;
              while(k > 0){
                  if((k & 1) == 1) ans += a;
                  k = k >> 1;
                  a += a;
              }
              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }