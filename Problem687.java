/*
687. Longest Univalue Path

Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value.
This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.


Example 1:


Input: root = [5,4,5,1,1,5]
Output: 2
Example 2:


Input: root = [1,4,5,4,4,5]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.
*/


class Problem687 {
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

    int maxTreeEdges = 0;

    private int travelAndCount(TreeNode root) {
        if (root == null)
            return 0;

        int leftNodes = 0, rightNodes = 0;
        if (root.left != null && root.val == root.left.val)
            leftNodes = travelAndCount(root.left) + 1;

        if (root.right != null && root.val == root.right.val)
            rightNodes = travelAndCount(root.right) + 1;

        return Math.max(leftNodes, rightNodes);
    }

    private void travelTree(TreeNode root) {
        if (root == null)
            return;

        int leftNodes = 0, rightNodes = 0;
        if (root.left != null && root.val == root.left.val)
            leftNodes = travelAndCount(root.left) + 1;

        if (root.right != null && root.val == root.right.val)
            rightNodes = travelAndCount(root.right) + 1;

        if (leftNodes + rightNodes > maxTreeEdges)
            maxTreeEdges = leftNodes + rightNodes;

        travelTree(root.left);
        travelTree(root.right);
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        travelTree(root);
        return maxTreeEdges;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem687 pr = new Problem687();

        //TreeNode a7 = pr.new TreeNode(1);
        //TreeNode a6 = pr.new TreeNode(1);
        //TreeNode a5 = pr.new TreeNode(1);
        //TreeNode a4 = pr.new TreeNode(1);
        //TreeNode a3 = pr.new TreeNode(1, a4, a5 );
        //TreeNode a2 = pr.new TreeNode(1, a6, a7 );
        //TreeNode a1 = pr.new TreeNode(1, a2, a3);
        //TreeNode a0 = pr.new TreeNode(1, null, a1);

        TreeNode a6 = pr.new TreeNode(5);
        TreeNode a5 = pr.new TreeNode(1);
        TreeNode a4 = pr.new TreeNode(1);
        TreeNode a3 = pr.new TreeNode(5, a4, a5);
        TreeNode a2 = pr.new TreeNode(5, a6, null);
        TreeNode a0 = pr.new TreeNode(5, a2, a3);
        int ret = new Problem687().longestUnivaluePath(a0);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
