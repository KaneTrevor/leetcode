/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Follow up: Solve it both recursively and iteratively.

*/


class Problem101 {
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

    public boolean checkSubTree(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        else if (l == null || r == null || l.val != r.val)
            return false;

        return checkSubTree(l.left, r.right) && checkSubTree(r.left, l.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkSubTree(root.left, root.right);
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem101 pr = new Problem101();

        TreeNode a7 = pr.new TreeNode(5);
        TreeNode a6 = pr.new TreeNode(4);
        TreeNode a5 = pr.new TreeNode(4);
        TreeNode a4 = pr.new TreeNode(5);
        TreeNode a3 = pr.new TreeNode(2, a6, a7);
        TreeNode a2 = pr.new TreeNode(2, a4, a5);
        TreeNode a1 = pr.new TreeNode(1, a2, a3);

        boolean ret = new Problem101().isSymmetric(a1);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
