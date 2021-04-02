/*
572. Subtree of Another Tree

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.


Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

*/


class Problem572 {
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

    public boolean checkSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;

        if (s.val == t.val)
            return checkSubTree(s.left, t.left) && checkSubTree(s.right, t.right);
        else
            return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (checkSubTree(s, t))
            return true;

        return (s.left != null && isSubtree(s.left, t)) ||
                (s.right != null && isSubtree(s.right, t));
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem572 pr = new Problem572();

        //TreeNode a6 = pr.new TreeNode(1);
        //TreeNode a5 = pr.new TreeNode(2);
        //TreeNode a4 = pr.new TreeNode(1);
        //TreeNode a3 = pr.new TreeNode(5);
        //TreeNode a2 = pr.new TreeNode(4, a4, a5);
        //TreeNode a1 = pr.new TreeNode(3, a2, a3);
        //
        //TreeNode a31 = pr.new TreeNode(2);
        //TreeNode a21 = pr.new TreeNode(1);
        //TreeNode b1 = pr.new TreeNode(4, a21, a31);

        TreeNode a9 = pr.new TreeNode(2);
        TreeNode a8 = pr.new TreeNode(1, a9, null);
        TreeNode a7 = pr.new TreeNode(1, null, a8);
        TreeNode a6 = pr.new TreeNode(1, null, a7);
        TreeNode a5 = pr.new TreeNode(1, null, a6);
        TreeNode a4 = pr.new TreeNode(1, null, a5);
        TreeNode a3 = pr.new TreeNode(1, null, a4);
        TreeNode a2 = pr.new TreeNode(1, null, a3);
        TreeNode a1 = pr.new TreeNode(1, null, a2);

        TreeNode b4 = pr.new TreeNode(2);
        TreeNode b3 = pr.new TreeNode(1, b4, null);
        TreeNode b2 = pr.new TreeNode(1, null, b3);
        TreeNode b1 = pr.new TreeNode(1,null, b2);

        boolean ret = new Problem572().isSubtree(a1, b1);

        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
