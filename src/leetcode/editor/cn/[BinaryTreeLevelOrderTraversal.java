  /**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。



 示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]


 示例 2：


输入：root = [1]
输出：[[1]]


 示例 3：


输入：root = []
输出：[]




 提示：


 树中节点数目在范围 [0, 2000] 内
 -1000 <= Node.val <= 1000


 Related Topics 树 广度优先搜索 二叉树 👍 2080 👎 0

*/
  /**
 * 二叉树的层序遍历
 * @author sy
 * @date 2025-02-27 11:20:08
 */
  package leetcode.editor.cn;

  import javax.swing.tree.TreeNode;
  import java.util.*;

  class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public int maxDepth = -1;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
       if(root != null){
          queue.add(root);
       }
       while(!queue.isEmpty()){
           List<Integer> tmp = new LinkedList<>();
           // 遍历队列 不明白为什么不可以直接写 while(queue.size() --)
         for(int i = queue.size(); i > 0; i --){
               TreeNode node = queue.poll();
               tmp.add(node.val);
               if(node.left != null){
                   queue.add(node.left);
               }
               if(node.right != null){
                   queue.add(node.right);
               }
           }
           ans.add(tmp);
       }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }