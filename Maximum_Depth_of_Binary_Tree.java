/*
Question: Maximum Depth of Binary Tree

LeetCode 104

Problem Statement:

Given the root of a binary tree,
return its maximum depth.

Maximum Depth:

The number of nodes along the longest path
from the root node down to the farthest leaf node.

--------------------------------------------------

Example:

Input:

                1
              /   \
             2     3
            / \
           4   5

Output:

3

Explanation:

Longest Path:

1 → 2 → 4

or

1 → 2 → 5

Depth = 3

--------------------------------------------------

Approach 1: Recursive DFS

Key Idea:

For every node:

Depth

=
1 + max(left subtree depth,
        right subtree depth)

--------------------------------------------------

Recursive Formula

maxDepth(node)

If node == null

return 0

Otherwise

return

1 + max(
        maxDepth(node.left),
        maxDepth(node.right)
       )

--------------------------------------------------

Dry Run

Tree:

                1
              /   \
             2     3
            / \
           4   5

--------------------------------

Depth(4)

1

--------------------------------

Depth(5)

1

--------------------------------

Depth(2)

1 + max(1,1)

= 2

--------------------------------

Depth(3)

1

--------------------------------

Depth(1)

1 + max(2,1)

= 3

--------------------------------------------------

Approach 2: Iterative BFS (Level Order)

Key Idea:

Every level processed
increases depth by 1.

Use Queue.

--------------------------------------------------

Algorithm

1. Push root into queue.
2. Process one level at a time.
3. After completing a level:
      depth++
4. Continue until queue becomes empty.

--------------------------------------------------

Visualization

Tree:

                1
              /   \
             2     3
            / \
           4   5

Queue:

[1]

Depth = 1

----------------

Queue:

[2,3]

Depth = 2

----------------

Queue:

[4,5]

Depth = 3

----------------

Queue Empty

Answer = 3

--------------------------------------------------

Revision Notes

Problem:

Find height/depth
of binary tree.

-----------------------------------------

Most Important Formula

Depth(node)

=

1 + max(

Depth(left),

Depth(right)

)

-----------------------------------------

Base Case

Depth(NULL)

=

0

-----------------------------------------

Why Recursion Works?

Every node asks:

"What is the maximum depth
of my children?"

Then adds 1 for itself.

-----------------------------------------

BFS Observation

Every level processed

=

Depth + 1

-----------------------------------------

Pattern Recognition

Keywords:

✔ Height of Tree
✔ Maximum Depth
✔ Longest Root to Leaf Path

Think:

DFS Recursion

-----------------------------------------

Memory Trick

Height

=

1 + max(

Left Height,

Right Height

)

-----------------------------------------

Common Interview Mistakes

1. Returning -1 for NULL.
2. Using min instead of max.
3. Counting edges instead of nodes.
4. Forgetting +1.
5. Missing null check.

--------------------------------------------------

Complexity Analysis

Recursive DFS

Time Complexity:

O(N)

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

Iterative BFS

Time Complexity:

O(N)

Space Complexity:

O(N)

--------------------------------------------------

DFS vs BFS

DFS

✔ Cleaner
✔ Most preferred

Uses:

Recursion

--------------------------------

BFS

✔ Level-wise calculation

Uses:

Queue

--------------------------------------------------

Related Questions

1. Maximum Depth of Binary Tree (LeetCode 104)
2. Minimum Depth of Binary Tree (LeetCode 111)
3. Diameter of Binary Tree (LeetCode 543)
4. Balanced Binary Tree (LeetCode 110)
5. Binary Tree Level Order Traversal (LeetCode 102)
6. Path Sum (LeetCode 112)
7. Maximum Width of Binary Tree

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

/* =====================================================
   APPROACH 1 : RECURSIVE DFS
   ===================================================== */

class RecursiveSolution {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}

/* =====================================================
   APPROACH 2 : ITERATIVE BFS
   ===================================================== */

class IterativeSolution {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            level++;
        }

        return level;
    }
}

/* =====================================================
   DRIVER CLASS
   ===================================================== */

public class Maximum_Depth_of_Binary_Tree {

    public static void main(String[] args) {

        /*
                        1
                      /   \
                     2     3
                    / \
                   4   5

            Maximum Depth = 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        RecursiveSolution recursive =
                new RecursiveSolution();

        IterativeSolution iterative =
                new IterativeSolution();

        System.out.println(
                "Recursive DFS Depth : "
                + recursive.maxDepth(root));

        System.out.println(
                "Iterative BFS Depth : "
                + iterative.maxDepth(root));
    }
}