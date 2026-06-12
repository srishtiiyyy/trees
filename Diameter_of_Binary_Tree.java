/*
Question: Diameter of Binary Tree

LeetCode 543

Problem Statement:

Given the root of a binary tree,
return the diameter of the tree.

Diameter:

The length of the longest path between
any two nodes in the tree.

The path may or may not pass through the root.

Note:

Diameter is measured in terms of EDGES.

--------------------------------------------------

Example 1:

Input:

            1
           / \
          2   3
         / \
        4   5

Output:

3

Explanation:

Longest path:

4 → 2 → 1 → 3

Number of edges = 3

--------------------------------------------------

Example 2:

Input:

        1
       /
      2

Output:

1

--------------------------------------------------

Key Observation

For every node:

Longest path passing through that node

=

Height(Left Subtree)

+

Height(Right Subtree)

--------------------------------------------------

Visualization

            1
           / \
          2   3
         / \
        4   5

--------------------------------

At Node 2

Left Height = 1

Right Height = 1

Diameter Through Node 2

=

1 + 1

=

2

--------------------------------

At Node 1

Left Height = 2

Right Height = 1

Diameter Through Node 1

=

2 + 1

=

3

Maximum Diameter = 3

--------------------------------------------------

Optimal Approach

DFS Height Calculation

--------------------------------------------------

Algorithm

For every node:

1. Calculate left height.
2. Calculate right height.
3. Diameter through node:

      leftHeight + rightHeight

4. Update global diameter.
5. Return height of current node.

--------------------------------------------------

Recursive Formula

height(node)

{

leftHeight = height(left)

rightHeight = height(right)

diameter = max(
                diameter,
                leftHeight + rightHeight
              )

return

1 + max(leftHeight, rightHeight)

}

--------------------------------------------------

Dry Run

Tree:

            1
           / \
          2   3
         / \
        4   5

--------------------------------

Node 4

Height = 1

--------------------------------

Node 5

Height = 1

--------------------------------

Node 2

Diameter Through Node

=

1 + 1

=

2

Height = 2

--------------------------------

Node 3

Height = 1

--------------------------------

Node 1

Diameter Through Node

=

2 + 1

=

3

Maximum Diameter = 3

--------------------------------------------------

Revision Notes

Problem:

Find longest path
between any two nodes.

-----------------------------------------

Important Formula

Diameter Through Node

=

Left Height

+

Right Height

-----------------------------------------

Height Formula

Height

=

1 + max(

Left Height,

Right Height

)

-----------------------------------------

Key Observation

Every node can become
the turning point of
the longest path.

-----------------------------------------

Why Postorder DFS?

Need heights of children
before processing parent.

Therefore:

Bottom-Up DFS

-----------------------------------------

Pattern Recognition

Keywords:

✔ Longest Path
✔ Diameter
✔ Tree Height
✔ Maximum Distance

Think:

DFS + Height

-----------------------------------------

Memory Trick

Height

returns upward

--------------------------------

Diameter

updates globally

-----------------------------------------

Common Interview Mistakes

1. Assuming diameter passes through root.
2. Returning diameter instead of height.
3. Counting nodes instead of edges.
4. Forgetting global maximum update.
5. Using O(N²) approach.

--------------------------------------------------

Brute Force

For every node:

Compute left height

Compute right height

Time Complexity:

O(N²)

--------------------------------------------------

Optimal Solution

Single DFS Traversal

Time Complexity:

O(N)

Space Complexity:

O(H)

H = Height of Tree

--------------------------------------------------

Relationship With Other Problems

Maximum Depth

Uses:

1 + max(left,right)

--------------------------------

Diameter

Uses:

left + right

--------------------------------

Balanced Tree

Uses:

|left-right|

--------------------------------

Maximum Path Sum

Uses:

left + right + node.val

--------------------------------------------------

Related Questions

1. Diameter of Binary Tree (LeetCode 543)
2. Maximum Depth of Binary Tree (LeetCode 104)
3. Balanced Binary Tree (LeetCode 110)
4. Binary Tree Maximum Path Sum (LeetCode 124)
5. Longest Univalue Path (LeetCode 687)
6. Maximum Width of Binary Tree
7. Height of Binary Tree

--------------------------------------------------

Company Tags

Intel
Alibaba
Swiggy
Freshworks
Electronic Arts
Optum
Reddit
PayPal
Stripe
Visa
Qualcomm
Siemens Healthineers
Robinhood
Byju's
Deloitte
NVIDIA
Wayfair
Airbnb
Rakuten
Mastercard
Snowflake
OYO Rooms
Splunk
Bloomberg
GE Healthcare
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

    public int diameterOfBinaryTree(TreeNode root) {

        int[] diameter = new int[1];

        height(root, diameter);

        return diameter[0];
    }

    private int height(TreeNode node,
                       int[] diameter) {

        if (node == null) {
            return 0;
        }

        int leftHeight =
                height(node.left, diameter);

        int rightHeight =
                height(node.right, diameter);

        diameter[0] =
                Math.max(diameter[0],
                         leftHeight + rightHeight);

        return 1 +
                Math.max(leftHeight,
                         rightHeight);
    }
}

public class Diameter_of_Binary_Tree {

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                 / \
                4   5

            Longest Path:

            4 → 2 → 1 → 3

            Diameter = 3 Edges
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        System.out.println(
                "Diameter of Tree = "
                + obj.diameterOfBinaryTree(root));
    }
}