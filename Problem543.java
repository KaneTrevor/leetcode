/*
543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the
length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/


class Problem543 {
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

    int maxDiameter = 0;

    public int sumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = sumDepth(root.left);
        int rDepth = sumDepth(root.right);

        if (lDepth + rDepth > maxDiameter) {
            maxDiameter = lDepth + rDepth;
        }

        return Math.max(lDepth, rDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sumDepth(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem543 pr = new Problem543();
        TreeNode a6 = pr.new TreeNode(6);
        TreeNode a5 = pr.new TreeNode(7, a6, null);
        TreeNode a4 = pr.new TreeNode(15);
        TreeNode a3 = pr.new TreeNode(20, a4, a5);
        TreeNode a2 = pr.new TreeNode(9);
        TreeNode a1 = pr.new TreeNode(3, a2, a3);

        int ret = new Problem543().diameterOfBinaryTree(a1);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
