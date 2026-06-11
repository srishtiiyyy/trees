/*
Question: Same Tree

LeetCode 100

Problem Statement:

Given the roots of two binary trees p and q,
determine whether they are identical.

Two binary trees are considered the same if:

1. They are structurally identical.
2. Corresponding nodes contain the same value.

Return true if both trees are identical,
otherwise return false.

--------------------------------------------------

Example 1:

Input:

Tree 1:          Tree 2:

    1               1
   / \             / \
  2   3           2   3

Output:

true

--------------------------------------------------

Example 2:

Input:

Tree 1:          Tree 2:

    1               1
   /                 \
  2                   2

Output:

false

Explanation:

Structure is different.

--------------------------------------------------

Example 3:

Input:

Tree 1:          Tree 2:

    1               1
   / \             / \
  2   1           1   2

Output:

false

Explanation:

Node values are different.

--------------------------------------------------

Approach: Recursive DFS

Key Idea:

For two trees to be identical:

1. Current nodes must exist together.
2. Current node values must match.
3. Left subtrees must be identical.
4. Right subtrees must be identical.

--------------------------------------------------

Recursive Formula

isSameTree(p, q)

If either node is NULL:

return p == q

Otherwise:

return

(p.data == q.data)

AND

isSameTree(p.left, q.left)

AND

isSameTree(p.right, q.right)

--------------------------------------------------

Dry Run

Tree 1:

        1
       / \
      2   3

Tree 2:

        1
       / \
      2   3

--------------------------------

Compare 1 and 1

Equal

--------------------------------

Compare 2 and 2

Equal

--------------------------------

Compare NULL and NULL

true

--------------------------------

Compare NULL and NULL

true

--------------------------------

Compare 3 and 3

Equal

--------------------------------

All comparisons succeed

Answer = true

--------------------------------------------------

Revision Notes

Problem:

Check whether two binary trees
are exactly identical.

-----------------------------------------

Conditions for Same Tree

1. Same Structure

2. Same Values

Both conditions must hold.

-----------------------------------------

Base Case

If either node is NULL

return p == q

Cases:

NULL NULL

true

----------------

NULL Node

false

----------------

Node NULL

false

-----------------------------------------

Recursive Logic

Current Value Match

AND

Left Trees Match

AND

Right Trees Match

-----------------------------------------

Visualization

        1
       / \
      2   3

Compare

        1
       / \
      2   3

Every node position
must contain same value.

-----------------------------------------

Pattern Recognition

Keywords:

✔ Compare Two Trees
✔ Identical Trees
✔ Same Structure
✔ Same Values

Think:

DFS Comparison

-----------------------------------------

Memory Trick

Same Tree

=

Same Root

AND

Same Left

AND

Same Right

-----------------------------------------

Common Interview Mistakes

1. Comparing only values.
2. Ignoring tree structure.
3. Missing NULL checks.
4. Using OR instead of AND.
5. Forgetting recursive subtree checks.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(N)

N = Number of Nodes

Every node is visited once.

--------------------------------------------------

Space Complexity:

O(H)

H = Height of Tree

Recursive stack space.

Worst Case:

O(N)

Skewed Tree

Best Case:

O(log N)

Balanced Tree

--------------------------------------------------

Approach 2: Iterative BFS

Can also be solved using:

Queue<Pair<Node1, Node2>>

Compare nodes level by level.

Time Complexity:

O(N)

Space Complexity:

O(N)

--------------------------------------------------

Related Questions

1. Same Tree (LeetCode 100)
2. Symmetric Tree (LeetCode 101)
3. Subtree of Another Tree (LeetCode 572)
4. Balanced Binary Tree (LeetCode 110)
5. Invert Binary Tree (LeetCode 226)
6. Maximum Depth of Binary Tree (LeetCode 104)
7. Leaf-Similar Trees (LeetCode 872)

--------------------------------------------------

Company Tags

Teladoc Health
Deloitte
Wayfair
Siemens Healthineers
Broadcom
Optum
PayPal
Chewy
Rakuten
McKinsey & Company
Activision Blizzard
Rockstar Games
Snowflake
Western Digital
AMD
Swiggy
Epic Games
Etsy
Target
Electronic Arts
DoorDash
NVIDIA
Boston Consulting Group
Robinhood
Riot Games
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

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

class Solution {

    public boolean isSameTree(TreeNode p,
                              TreeNode q) {

        // If one or both nodes are null
        if (p == null || q == null) {
            return p == q;
        }

        return (p.data == q.data)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

public class Same_Tree {

    public static void main(String[] args) {

        /*
                Tree 1

                    1
                   / \
                  2   3

                Tree 2

                    1
                   / \
                  2   3
        */

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        Solution obj = new Solution();

        System.out.println(
                "Are Trees Same? : "
                + obj.isSameTree(p, q));
    }
}