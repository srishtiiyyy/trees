import java.util.*;

/*
Question: Binary Tree Maximum Path Sum

LeetCode 124

Problem Statement:

Given the root of a binary tree,
return the maximum path sum.

A path is a sequence of nodes where each pair
of adjacent nodes has an edge connecting them.

The path:

✔ Can start from any node
✔ Can end at any node
✔ Must contain at least one node
✔ Does not need to pass through the root

--------------------------------------------------

Example 1:

Input:

        1
       / \
      2   3

Output:

6

Explanation:

Path:

2 -> 1 -> 3

Sum = 6

--------------------------------------------------

Example 2:

Input:

         -10
         /  \
        9   20
           /  \
          15   7

Output:

42

Explanation:

Path:

15 -> 20 -> 7

Sum = 42

--------------------------------------------------

Approach:

Use Postorder DFS.

For every node:

Current Path Sum

=
leftGain + rightGain + node.data

Update the global maximum answer.

Return:

node.data + max(leftGain, rightGain)

because a parent can continue through
only one side.

Negative paths are ignored:

Math.max(0, subtreeGain)

--------------------------------------------------

Time Complexity:

O(N)

Space Complexity:

O(H)

H = Height of Tree

--------------------------------------------------

Related Questions:

1. Maximum Path Sum (LeetCode 124)
2. Diameter of Binary Tree (LeetCode 543)
3. Balanced Binary Tree (LeetCode 110)
4. Maximum Depth of Binary Tree (LeetCode 104)
*/

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

class Solution {

    // DFS function to calculate maximum gain
    private int findMaxPathSum(TreeNode root,
                               int[] maxi) {

        if (root == null)
            return 0;

        int leftMaxPath =
                Math.max(
                        0,
                        findMaxPathSum(root.left, maxi)
                );

        int rightMaxPath =
                Math.max(
                        0,
                        findMaxPathSum(root.right, maxi)
                );

        // Maximum path passing through current node
        maxi[0] = Math.max(
                maxi[0],
                leftMaxPath +
                rightMaxPath +
                root.data
        );

        // Return one side to parent
        return root.data +
                Math.max(
                        leftMaxPath,
                        rightMaxPath
                );
    }

    public int maxPathSum(TreeNode root) {

        int[] maxi = {
                Integer.MIN_VALUE
        };

        findMaxPathSum(root, maxi);

        return maxi[0];
    }
}

public class Binary_Tree_Maximum_Path_Sum {

    public static void main(String[] args) {

        /*
                    -10
                    /  \
                   9   20
                      /  \
                     15   7

            Maximum Path Sum:

            15 -> 20 -> 7

            Sum = 42
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution obj = new Solution();

        System.out.println(
                "Maximum Path Sum = "
                + obj.maxPathSum(root)
        );
    }
}