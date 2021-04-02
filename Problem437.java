/*
437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

*/

//HashSet<String> pathSet;
//private void countList(ArrayList<Pair<Integer, String>> list) {
//    for (int i = 0; i < list.size(); i++) {
//        int sum = 0;
//
//        for (int j = i; j < list.size(); j++) {
//            sum += list.get(j).getKey();
//
//            if (sum == target) {
//                StringBuilder base = new StringBuilder();
//
//                for (int k = 0; k < i; k++) {
//                    base.append(list.get(k).getValue());
//                }
//                base.append(" ");
//
//                StringBuilder path = new StringBuilder();
//                for (int k = i; k <= j; k++) {
//                    path.append(list.get(k).getValue());
//                }
//                base.append(path);
//
//                if (!pathSet.contains(base.toString())) {
//                    pathSumNum++;
//                    System.out.println(path.toString());
//                    pathSet.add(base.toString());
//                }
//            }
//        }
//    }
//}
//
//private void addPathSum(TreeNode root, String c, ArrayList<Pair<Integer, String>> list) {
//    list.add(new Pair<>(root.val, c));
//
//    if (root.left == null && root.right == null) {
//        countList(list);
//        return;
//    }
//
//    if (root.left != null) {
//        ArrayList<Pair<Integer, String>> sumList = new ArrayList<>(list);
//        addPathSum(root.left, "l", sumList);
//    }
//
//    if (root.right != null) {
//        ArrayList<Pair<Integer, String>> sumList = new ArrayList<>(list);
//        addPathSum(root.right, "r", sumList);
//    }
//}


//public int pathSum2(TreeNode root, int sum) {
//    if (root == null) return 0;
//    int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    return ret;
//}
//
//private int pathSumStartWithRoot(TreeNode root, int sum) {
//    if (root == null) return 0;
//    int ret = 0;
//    if (root.val == sum) ret++;
//    ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
//    return ret;
//}


class Problem437 {
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
    int pathSumNum = 0;

    public void treeTravel(TreeNode root, int sum, int pathCount) {
        if (root == null)
            return;

        if (root.val + sum == target) {
            pathSumNum++;
        }

        if (root.left != null) {
            treeTravel(root.left, root.val + sum, pathCount + 1);

            if (pathCount == 0)
                treeTravel(root.left, 0, 0);
        }

        if (root.right != null) {
            treeTravel(root.right, root.val + sum, pathCount + 1);

            if (pathCount == 0)
                treeTravel(root.right, 0, 0);
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        this.target = sum;
        treeTravel(root, 0, 0);
        return pathSumNum;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem437 pr = new Problem437();
        int sum = 0;

        //sum=8, ret= 3
        //TreeNode a9 = pr.new TreeNode(1);
        //TreeNode a8 = pr.new TreeNode(-2);
        //TreeNode a7 = pr.new TreeNode(3);
        //TreeNode a6 = pr.new TreeNode(11);
        //TreeNode a5 = pr.new TreeNode(2, a9, null);
        //TreeNode a4 = pr.new TreeNode(3, a7, a8);
        //TreeNode a3 = pr.new TreeNode(-3, a6 ,null);
        //TreeNode a2 = pr.new TreeNode(5, a4, a5);
        //TreeNode a1 = pr.new TreeNode(10, a2, a3);
        //sum = 8;

        //sum=-2, ret=4
        //TreeNode a7 = pr.new TreeNode(-1);
        //TreeNode a6 = pr.new TreeNode(-2);
        //TreeNode a5 = pr.new TreeNode(3);
        //TreeNode a4 = pr.new TreeNode(1, a7, null);
        //
        //TreeNode a3 = pr.new TreeNode(-3, a6 ,null);
        //TreeNode a2 = pr.new TreeNode(-2, a4, a5);
        //TreeNode a1 = pr.new TreeNode(1, a2, a3);
        //sum = -2;

        ////sum=1, ret=4
        //TreeNode a8 = pr.new TreeNode(1);
        //TreeNode a7 = pr.new TreeNode(1);
        //TreeNode a1 = pr.new TreeNode(0, a7, a8);
        //sum = 1;

        //sum=6, ret=3
        //TreeNode a6 = pr.new TreeNode(4);
        //TreeNode a5 = pr.new TreeNode(5);
        //TreeNode a4 = pr.new TreeNode(3);
        //TreeNode a3 = pr.new TreeNode(1, a5 ,a6);
        //TreeNode a2 = pr.new TreeNode(2, a4, null);
        //TreeNode a1 = pr.new TreeNode(1, a2, a3);
        //sum = 6;

        //sum=-1, ret=4
        TreeNode a7 = pr.new TreeNode(-1);
        TreeNode a6 = pr.new TreeNode(-2);
        TreeNode a5 = pr.new TreeNode(3);
        TreeNode a4 = pr.new TreeNode(1, a7, null);
        TreeNode a3 = pr.new TreeNode(-3, a6, null);
        TreeNode a2 = pr.new TreeNode(-2, a4, a5);
        TreeNode a1 = pr.new TreeNode(1, a2, a3);
        sum = -1;

        int ret = new Problem437().pathSum(a1, sum);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
