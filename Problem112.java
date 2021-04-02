/*
112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/


class Problem112 {
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

    int target;
    boolean hasPathSum = false;

    public void addNodeSum(TreeNode root, int sum) {
        if (root == null || hasPathSum)
            return;

        if (root.left == null && root.right == null && root.val + sum == target) {
            hasPathSum = true;
            return;
        }

        addNodeSum(root.left, root.val + sum);
        addNodeSum(root.right, root.val + sum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        this.target = sum;
        addNodeSum(root, 0);
        return hasPathSum;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem112 pr = new Problem112();
        TreeNode a9 = pr.new TreeNode(2);
        TreeNode a8 = pr.new TreeNode(7);
        TreeNode a7 = pr.new TreeNode(11, a8, a9);

        TreeNode a6 = pr.new TreeNode(1);
        TreeNode a5 = pr.new TreeNode(4, a6, null);
        TreeNode a4 = pr.new TreeNode(13);
        TreeNode a3 = pr.new TreeNode(8, a4, a5);
        TreeNode a2 = pr.new TreeNode(4, a7 ,null);
        TreeNode a1 = pr.new TreeNode(5, a2, a3);

        //TreeNode a2 = pr.new TreeNode(2);
        //TreeNode a1 = pr.new TreeNode(1, a2, null);
        boolean ret = new Problem112().hasPathSum(a1, 22);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
