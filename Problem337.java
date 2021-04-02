/*
337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the
"root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that
"all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses
were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/


class Problem337 {
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

    //public int rob2(TreeNode root) {
    //    if (root == null)
    //        return 0;
    //
    //    int sum1 = root.val;
    //
    //    if (root.left != null)
    //        sum1 += rob2(root.left.left) + rob2(root.left.right);
    //    if (root.right != null)
    //        sum1 += rob2(root.right.left) + rob2(root.right.right);
    //
    //    int sum2 = rob2(root.left) + rob2(root.right);
    //    return Math.max(sum1, sum2);
    //}

    private int[] robSum(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;

        int[] left = robSum(root.left);
        int[] right = robSum(root.right);

        //res[0]: the sum of childs
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //res[1]: the root adds child's children
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int[] value = robSum(root);
        return Math.max(value[0], value[1]);
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        Problem337 pr = new Problem337();

        //TreeNode a7 = pr.new TreeNode(1);
        //TreeNode a6 = pr.new TreeNode(9);
        //TreeNode a5 = pr.new TreeNode(1);
        //TreeNode a4 = pr.new TreeNode(1);
        //TreeNode a3 = pr.new TreeNode(1, a6, a7);
        //TreeNode a2 = pr.new TreeNode(9, a4, a5);
        //TreeNode a1 = pr.new TreeNode(1, a2, a3);

        TreeNode a11 = pr.new TreeNode(20);
        TreeNode a10 = pr.new TreeNode(18);
        TreeNode a9 = pr.new TreeNode(15);
        TreeNode a8 = pr.new TreeNode(1);
        TreeNode a7 = pr.new TreeNode(28);
        TreeNode a6 = pr.new TreeNode(22);
        TreeNode a5 = pr.new TreeNode(19, a10, a11);
        TreeNode a4 = pr.new TreeNode(4, a8, a9);
        TreeNode a3 = pr.new TreeNode(24, a6, a7);
        TreeNode a2 = pr.new TreeNode(17, a4, a5);
        TreeNode a1 = pr.new TreeNode(21, a2, a3);

        int ret = pr.rob(a1);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        //System.out.println("stackCount:" + test.stackCount);
        System.out.println("Run Time:" + (end - start) + " ms");
    }

    //[41,6,8469,0,22,6336,9177,null,3,15,31,5734,6509,8770,9379,2,4,10,20,28,39,1490,5775,6410,6986,8493,8823,9298,9975,1,null,null,5,8,12,16,21,26,29,34,40,506,4491,5737,6034,6384,6434,6853,8178,8492,8503,8779,9106,9283,9339,9774,9982,null,null,null,null,7,9,11,13,null,17,null,null,23,27,null,30,32,35,null,null,176,837,3317,5715,5735,5743,5944,6310,6338,6398,6425,6436,6802,6917,7473,8397,8472,null,8494,8711,8776,8782,9009,9153,9210,9289,9336,9371,9400,9953,9980,9993,null,null,null,null,null,null,null,14,null,18,null,25,null,null,null,null,null,33,null,36,53,316,739,1409,3011,3924,4845,5730,null,5736,5741,5754,5807,5968,6056,6329,6337,6345,6387,6400,6420,6428,6435,6467,6575,6814,6911,6970,7111,7761,8283,8461,8470,8473,null,8496,8674,8722,8773,8778,8780,8803,8924,9078,9111,9172,9185,9270,9285,9296,9307,9337,9369,9376,9391,9633,9933,9967,9979,9981,9989,9994,null,null,null,19,24,null,null,null,null,37,46,140,199,505,669,814,1281,1430,1976,3096,3627,3934,4646,5455,5719,5733,null,null,5740,5742,
}
