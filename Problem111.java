/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.


Example 1:

      3
     / \
    9   20
       / \
      15  7


Input: root = [3,9,20,null,null,15,7]
Output: 2


Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 10^5].
-1000 <= Node.val <= 1000

*/


class Problem111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left > 0 && right > 0)
            return Math.min(left, right) + 1;
        else if (left > 0)
            return left + 1;
        else
            return right + 1;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem111 pr = new Problem111();
        //TreeNode a9 = pr.new TreeNode(2);
        //TreeNode a8 = pr.new TreeNode(7);
        //TreeNode a7 = pr.new TreeNode(11, a8, a9);

        TreeNode a6 = pr.new TreeNode(7);
        TreeNode a5 = pr.new TreeNode(6, a6, null);
        TreeNode a4 = pr.new TreeNode(5, a5, null );
        TreeNode a3 = pr.new TreeNode(4, a4, null );
        TreeNode a2 = pr.new TreeNode(3, a3, null );
        TreeNode a1 = pr.new TreeNode(2, a2, null);

        //TreeNode a2 = pr.new TreeNode(2);
        //TreeNode a1 = pr.new TreeNode(1, a2, null);
        int ret = new Problem111().minDepth(a1);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
