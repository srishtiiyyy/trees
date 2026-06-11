/*
Question: Balanced Binary Tree

LeetCode 110

Problem Statement:

Given the root of a binary tree,
determine whether it is height-balanced.

A binary tree is balanced if:

For every node,

| Height(Left Subtree) - Height(Right Subtree) | ≤ 1

Return true if the tree is balanced,
otherwise return false.

--------------------------------------------------

Example 1:

Input:

            1
           / \
          2   3
         / \
        4   5

Output:

true

Explanation:

Every node satisfies:

|leftHeight - rightHeight| ≤ 1

--------------------------------------------------

Example 2:

Input:

                1
               /
              2
             /
            3
           /
          4

Output:

false

Explanation:

Root becomes unbalanced.

Difference > 1

--------------------------------------------------

Brute Force Approach

For every node:

1. Compute left subtree height.
2. Compute right subtree height.
3. Check balance condition.
4. Repeat for every node.

Time Complexity:

O(N²)

--------------------------------------------------

Optimal Approach

DFS + Height Calculation

--------------------------------------------------

Key Observation

While calculating height,
we can simultaneously check balance.

Instead of returning height only,

Return:

-1 → Tree is unbalanced

Otherwise:

Height of subtree

--------------------------------------------------

Magic Value

Return:

-1

whenever an unbalanced subtree
is found.

This allows early termination.

--------------------------------------------------

Algorithm

dfsHeight(node)

1. If node == null

      return 0

2. Get left height

3. If left height == -1

      return -1

4. Get right height

5. If right height == -1

      return -1

6. Check balance condition

      |left-right| > 1

      return -1

7. Otherwise return height

      1 + max(left,right)

--------------------------------------------------

Dry Run

Balanced Tree

            1
           / \
          2   3

--------------------------------

Height(2) = 1

Height(3) = 1

--------------------------------

Root

|1 - 1| = 0

Balanced

Height = 2

Answer = true

--------------------------------------------------

Unbalanced Tree

                1
               /
              2
             /
            3

--------------------------------

Height(3) = 1

Height(2) = 2

--------------------------------

Root

|2 - 0| = 2

Not Balanced

Return -1

Answer = false

--------------------------------------------------

Revision Notes

Problem:

Check whether tree is height-balanced.

-----------------------------------------

Balance Condition

For every node

| Left Height - Right Height |

≤ 1

-----------------------------------------

Most Important Trick

Return:

-1

for unbalanced subtree.

-----------------------------------------

Why Return -1?

It propagates failure upward.

No need to calculate
remaining heights.

-----------------------------------------

Recursive Formula

Height

=

1 + max(

Left Height,

Right Height

)

-----------------------------------------

Pattern Recognition

Keywords:

✔ Balanced Tree
✔ Height Difference
✔ Tree Height
✔ DFS Height

Think:

Bottom-Up DFS

-----------------------------------------

Memory Trick

Height Problem

=

DFS

--------------------------------

Balance Check

=

Height Difference ≤ 1

--------------------------------

Unbalanced

=

Return -1

-----------------------------------------

Common Interview Mistakes

1. Recomputing height repeatedly.
2. Using O(N²) approach.
3. Forgetting early termination.
4. Using >= instead of >.
5. Not checking child imbalance.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(N)

Every node visited once.

--------------------------------------------------

Space Complexity:

O(H)

H = Height of Tree

Worst Case:

O(N)

Skewed Tree

Best Case:

O(log N)

Balanced Tree

--------------------------------------------------

Why Optimal?

Brute Force:

O(N²)

--------------------------------

Optimized DFS:

O(N)

Single traversal

--------------------------------------------------

Related Questions

1. Balanced Binary Tree (LeetCode 110)
2. Maximum Depth of Binary Tree (LeetCode 104)
3. Diameter of Binary Tree (LeetCode 543)
4. Maximum Path Sum (LeetCode 124)
5. Check Completeness of Binary Tree
6. Symmetric Tree (LeetCode 101)
7. Validate Binary Search Tree (LeetCode 98)

--------------------------------------------------

Company Tags

Cerner
Micron Technology
Alibaba
Etsy
Stripe
Splunk
Epic Systems
Mastercard
Rakuten
Byju's
Reddit
Nutanix
Texas Instruments
Walmart
Johnson & Johnson
PwC
Twilio
Epic Games
Roblox
Boston Consulting Group
Unity Technologies
Ernst & Young
Siemens Healthineers
eBay
Swiggy
Google
Microsoft
Amazon
Meta
Apple
Netflix
Adobe
*/

import java.util.*;

// Tree Node Definition
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    public boolean isBalanced(TreeNode root) {

        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);

        if (leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight(root.right);

        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight,
                        rightHeight) + 1;
    }
}

public class Balanced_Binary_Tree {

    public static void main(String[] args) {

        /*
                    Balanced Tree

                          1
                         / \
                        2   3
                       / \
                      4   5

                    Output: true
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        System.out.println(
                "Is Balanced Tree? : "
                + obj.isBalanced(root));

        /*
                    Unbalanced Tree

                          1
                         /
                        2
                       /
                      3
                     /
                    4

                    Output: false
        */

        TreeNode unbalanced =
                new TreeNode(1);

        unbalanced.left =
                new TreeNode(2);

        unbalanced.left.left =
                new TreeNode(3);

        unbalanced.left.left.left =
                new TreeNode(4);

        System.out.println(
                "Is Balanced Tree? : "
                + obj.isBalanced(unbalanced));
    }
}