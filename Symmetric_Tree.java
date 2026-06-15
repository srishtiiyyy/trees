/*
Question: Symmetric Tree

LeetCode 101

Problem Statement:

Given the root of a binary tree,
check whether it is symmetric around its center.

A tree is symmetric if the left subtree is
a mirror reflection of the right subtree.

Return true if the tree is symmetric,
otherwise return false.

--------------------------------------------------

Example 1:

Input:

            1
          /   \
         2     2
        / \   / \
       3   4 4   3

Output:

true

--------------------------------------------------

Example 2:

Input:

            1
          /   \
         2     2
          \     \
           3     3

Output:

false

--------------------------------------------------

Approach: Recursive Mirror Check

Key Idea:

Instead of comparing:

Left ↔ Left
Right ↔ Right

For symmetry we compare:

Left ↔ Right
Right ↔ Left

Mirror Condition:

1. Values must match.
2. Left subtree of first tree should match
   right subtree of second tree.
3. Right subtree of first tree should match
   left subtree of second tree.

--------------------------------------------------

Algorithm

isSame(p, q)

1. If either node is NULL:
      return p == q

2. Values must be equal

3. Check:

      p.left  ↔ q.right

      p.right ↔ q.left

--------------------------------------------------

Dry Run

Tree:

            1
          /   \
         2     2
        / \   / \
       3   4 4   3

--------------------------------

Compare:

2 ↔ 2

Equal

--------------------------------

Compare:

3 ↔ 3

Equal

--------------------------------

Compare:

4 ↔ 4

Equal

--------------------------------

All mirror pairs match

Answer = true

--------------------------------------------------

Revision Notes

Problem:

Check whether a binary tree
is mirror symmetric.

-----------------------------------------

Mirror Rule

Normal Same Tree:

Left ↔ Left

Right ↔ Right

-----------------------------------------

Symmetric Tree:

Left ↔ Right

Right ↔ Left

-----------------------------------------

Recursive Formula

Mirror(p, q)

=

(p.val == q.val)

AND

Mirror(p.left, q.right)

AND

Mirror(p.right, q.left)

-----------------------------------------

Base Case

NULL ↔ NULL

true

--------------------------------

NULL ↔ Node

false

--------------------------------

Node ↔ NULL

false

-----------------------------------------

Visualization

            1
          /   \
         2     2
        / \   / \
       3   4 4   3

Mirror Pairs:

3 ↔ 3

4 ↔ 4

-----------------------------------------

Pattern Recognition

Keywords:

✔ Symmetric Tree
✔ Mirror Tree
✔ Reflection
✔ Foldable Tree

Think:

Mirror DFS

-----------------------------------------

Memory Trick

Same Tree

Left ↔ Left

Right ↔ Right

--------------------------------

Symmetric Tree

Left ↔ Right

Right ↔ Left

-----------------------------------------

Common Interview Mistakes

1. Comparing left-left and right-right.
2. Missing null checks.
3. Forgetting mirror comparison.
4. Not checking values.
5. Calling recursion on wrong children.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(N)

Every node visited once.

--------------------------------------------------

Space Complexity:

O(H)

H = Height of Tree

Recursive stack space.

Worst Case:

O(N)

Best Case:

O(log N)

--------------------------------------------------

Approach 2: Iterative BFS

Can also be solved using:

Queue<TreeNode>

Store mirror pairs:

(left, right)

Compare them level by level.

--------------------------------------------------

Related Questions

1. Symmetric Tree (LeetCode 101)
2. Same Tree (LeetCode 100)
3. Invert Binary Tree (LeetCode 226)
4. Balanced Binary Tree (LeetCode 110)
5. Subtree of Another Tree (LeetCode 572)
6. Leaf Similar Trees (LeetCode 872)
7. Flip Equivalent Binary Trees (LeetCode 951)

--------------------------------------------------

Company Tags

Snowflake
Uber
Optum
Epic Systems
Byju's
Boston Consulting Group
Micron Technology
NVIDIA
Western Digital
Robinhood
MongoDB
IBM
PwC
PayPal
Teladoc Health
Oracle
Flipkart
Ubisoft
Electronic Arts
Dropbox
eBay
AMD
DoorDash
Epic Games
Alibaba
Google
Microsoft
Amazon
Meta
Apple
Netflix
Adobe
*/

import java.util.*;

// Definition for Binary Tree Node
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode p,
                           TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        return (p.val == q.val)
                && isSame(p.left, q.right)
                && isSame(p.right, q.left);
    }
}

public class Symmetric_Tree {

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     2
                / \   / \
               3   4 4   3

            Output: true
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution obj = new Solution();

        System.out.println(
                "Is Symmetric Tree? : "
                + obj.isSymmetric(root)
        );
    }
}