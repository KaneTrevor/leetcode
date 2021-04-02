/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
*/


class Problem110 {
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
    boolean balanceTree = true;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        if (Math.abs(lDepth - rDepth) > 1) {
            balanceTree = false;
        }

        return Math.max(lDepth, rDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        maxDepth(root);
        return balanceTree;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem110 pr = new Problem110();

        //TreeNode a6 = pr.new TreeNode(8);
        //TreeNode a5 = pr.new TreeNode(7, a6, null);
        //TreeNode a4 = pr.new TreeNode(15);
        //TreeNode a3 = pr.new TreeNode(20, a4, a5);
        //TreeNode a2 = pr.new TreeNode(9);
        //TreeNode a1 = pr.new TreeNode(3, a2, a3);

        //TreeNode a3 = pr.new TreeNode(3);
        //TreeNode a2 = pr.new TreeNode(2, null, a3);
        //TreeNode a1 = pr.new TreeNode(1, null, a2);

        TreeNode a8 = pr.new TreeNode(8);
        TreeNode a6 = pr.new TreeNode(6);
        TreeNode a5 = pr.new TreeNode(5);
        TreeNode a4 = pr.new TreeNode(4, a8, null);
        TreeNode a3 = pr.new TreeNode(3, a6, null);
        TreeNode a2 = pr.new TreeNode(2, a4, a5);
        TreeNode a1 = pr.new TreeNode(1, a2, a3);

        boolean ret = new Problem110().isBalanced(a1);

        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
