/*
404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

*/


class Problem404 {
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

    int sumOfLeft = 0;

    private void travelTree(TreeNode root) {
        if (root == null)
            return;

        sumOfLeftLeaves(root.left);
        travelTree(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        sumOfLeftLeaves(root.left);
        travelTree(root.right);

        if (root.left == null && root.right == null) {
            sumOfLeft += root.val;
            return 0;
        }
        return sumOfLeft;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem404 pr = new Problem404();

        TreeNode a5 = pr.new TreeNode(7);
        TreeNode a4 = pr.new TreeNode(15);
        TreeNode a3 = pr.new TreeNode(20, a4, a5 );
        TreeNode a2 = pr.new TreeNode(9 );
        TreeNode a1 = pr.new TreeNode(3, a2, a3);

        //TreeNode a2 = pr.new TreeNode(2);
        //TreeNode a1 = pr.new TreeNode(5);
        int ret = new Problem404().sumOfLeftLeaves(a1);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
