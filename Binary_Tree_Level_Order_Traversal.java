/*
Question: Binary Tree Level Order Traversal

LeetCode 102

Problem Statement:

Given the root of a binary tree,
return the level order traversal of its nodes' values.

(Level by level traversal from left to right)

--------------------------------------------------

Example:

Input:

                1
              /   \
             2     3
            / \   / \
           4   5 6   7

Output:

[
 [1],
 [2,3],
 [4,5,6,7]
]

--------------------------------------------------

Approach: Breadth First Search (BFS)

Key Idea:

Nodes on the same level should be processed together.

A Queue naturally processes nodes
in First-In-First-Out (FIFO) order,
making it perfect for BFS.

--------------------------------------------------

Algorithm

1. Create an empty queue.
2. Push root into queue.
3. While queue is not empty:

      a) Store current queue size.

      b) Process exactly 'size' nodes.

      c) Add all node values
         into current level list.

      d) Push left child.

      e) Push right child.

4. Add current level to answer.

--------------------------------------------------

Visualization

Tree:

                1
              /   \
             2     3
            / \   / \
           4   5 6   7

--------------------------------

Queue:

[1]

Level 0

Process 1

Queue:

[2,3]

Answer:

[[1]]

--------------------------------

Level 1

Process 2,3

Queue:

[4,5,6,7]

Answer:

[[1],
 [2,3]]

--------------------------------

Level 2

Process 4,5,6,7

Queue:

[]

Answer:

[[1],
 [2,3],
 [4,5,6,7]]

--------------------------------------------------

Dry Run

Input:

        1
       / \
      2   3

Queue:

[1]

Process level:

[1]

Queue:

[2,3]

----------------

Process level:

[2,3]

Queue:

[]

Answer:

[
 [1],
 [2,3]
]

--------------------------------------------------

Revision Notes

Problem:

Traverse tree level by level.

-----------------------------------------

Traversal Type

Breadth First Search (BFS)

Uses Queue

-----------------------------------------

Why Queue?

Queue follows FIFO.

Nodes are processed
in the same order they appear.

-----------------------------------------

Important Trick

Before processing a level:

Store:

size = q.size()

This tells how many nodes belong
to the current level.

-----------------------------------------

Pattern Recognition

Keywords:

✔ Level Order Traversal
✔ Level Wise Traversal
✔ Breadth First Search
✔ Tree Levels

Think:

QUEUE + BFS

-----------------------------------------

Memory Trick

DFS

Uses Stack / Recursion

--------------------------------

BFS

Uses Queue

-----------------------------------------

Common Interview Mistakes

1. Using stack instead of queue.
2. Not storing level size.
3. Mixing nodes from different levels.
4. Forgetting null checks.
5. Adding children before processing node.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(n)

Every node visited once.

--------------------------------------------------

Space Complexity:

O(n)

Queue may contain
an entire level of nodes.

--------------------------------------------------

DFS vs BFS

DFS:

Preorder
Inorder
Postorder

Uses:

Stack / Recursion

--------------------------------

BFS:

Level Order

Uses:

Queue

--------------------------------------------------

Related Questions

1. Binary Tree Level Order Traversal (LeetCode 102)
2. Binary Tree Zigzag Level Order Traversal (LeetCode 103)
3. Binary Tree Right Side View (LeetCode 199)
4. Average of Levels in Binary Tree (LeetCode 637)
5. Maximum Depth of Binary Tree (LeetCode 104)
6. Minimum Depth of Binary Tree (LeetCode 111)
7. Vertical Order Traversal

--------------------------------------------------

Company Tags

Walmart
Morgan Stanley
Freshworks
Texas Instruments
Bloomberg
Deloitte
Square
Chewy
Zoho
Electronic Arts
KPMG
Bungie
Unity Technologies
Etsy
Optum
Wayfair
Nutanix
Pinterest
Western Digital
MongoDB
Roche
Roblox
Teladoc Health
Mastercard
Salesforce
Google
Microsoft
Amazon
Meta
Apple
Netflix
Adobe
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Tree Node Definition
class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {

    // Level Order Traversal using BFS
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                level.add(node.data);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            ans.add(level);
        }

        return ans;
    }
}

public class Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {

        /*
                        1
                      /   \
                     2     3
                    / \   / \
                   4   5 6   7

            Level Order:

            [
              [1],
              [2,3],
              [4,5,6,7]
            ]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution obj = new Solution();

        List<List<Integer>> result =
                obj.levelOrder(root);

        System.out.println(
                "Level Order Traversal:");

        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}