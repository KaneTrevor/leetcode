/*
226. Invert Binary Tree

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a
whiteboard so f*** off.
*/


class Problem226 {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode r = root.right;
        root.right = root.left;
        root.left = r;
        return root;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem226 pr = new Problem226();
        TreeNode a6 = pr.new TreeNode(6);
        TreeNode a5 = pr.new TreeNode(7, a6, null);
        TreeNode a4 = pr.new TreeNode(15);
        TreeNode a3 = pr.new TreeNode(20, a4, a5);
        TreeNode a2 = pr.new TreeNode(9);
        TreeNode a1 = pr.new TreeNode(3, a2, a3);

        TreeNode ret = new Problem226().invertTree(a1);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret.val);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
