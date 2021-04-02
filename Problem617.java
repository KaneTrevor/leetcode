/*
617. Merge Two Binary Trees

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7

Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7


Note: The merging process must start from the root nodes of both trees.
*/


class Problem617 {
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

    public boolean addTreeNode(TreeNode parent, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return false;
        }

        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        if (addTreeNode(left, t1 == null ? null : t1.left, t2 == null ? null : t2.left)) {
            parent.left = left;
        }
        if (addTreeNode(right, t1 == null ? null : t1.right, t2 == null ? null : t2.right)) {
            parent.right = right;
        }

        parent.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        return true;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root = new TreeNode();
        addTreeNode(root, t1, t2);
        return root;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem617 pr = new Problem617();
        TreeNode a6 = pr.new TreeNode(6);
        TreeNode a5 = pr.new TreeNode(7, a6, null);
        TreeNode a4 = pr.new TreeNode(15);
        TreeNode a3 = pr.new TreeNode(20, a4, a5);
        TreeNode a2 = pr.new TreeNode(9);
        TreeNode a1 = pr.new TreeNode(3, a2, a3);

        TreeNode a23 = pr.new TreeNode(3);
        TreeNode a22 = pr.new TreeNode(2, null, a23);
        TreeNode a21 = pr.new TreeNode(1, null, a22);

        TreeNode ret = new Problem617().mergeTrees(a1, a21);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret.val);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
