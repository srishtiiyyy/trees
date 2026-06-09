/*
Question: Binary Tree Inorder Traversal

LeetCode 94

Problem Statement:

Given the root of a binary tree,
return the inorder traversal of its nodes' values.

Inorder Traversal Order:

Left -> Root -> Right

--------------------------------------------------

Example 1:

Input:

      1
       \
        2
       /
      3

Output:

[1,3,2]

Explanation:

Inorder:

1 -> 3 -> 2

--------------------------------------------------

Example 2:

Input:

      1

Output:

[1]

--------------------------------------------------

Example 3:

Input:

      1
     / \
    2   3

Output:

[2,1,3]

--------------------------------------------------

Approach: Recursive DFS

Key Idea:

For every node:

1. Visit Left Subtree
2. Visit Current Node
3. Visit Right Subtree

This naturally follows Inorder Traversal.

--------------------------------------------------

Algorithm

inorder(node):

1. If node is null:
      return

2. Traverse left subtree

3. Process current node

4. Traverse right subtree

--------------------------------------------------

Dry Run

Tree:

        1
       / \
      2   3

Call:

inorder(1)

Step 1:

Go Left

inorder(2)

Go Left -> null

Add 2

Go Right -> null

Answer:

[2]

----------------

Back to 1

Add 1

Answer:

[2,1]

----------------

Go Right

inorder(3)

Add 3

Answer:

[2,1,3]

--------------------------------------------------

Revision Notes

Problem:

Return inorder traversal
of a binary tree.

-----------------------------------------

Traversal Order

Inorder

Left
Root
Right

-----------------------------------------

Visualization

        1
       / \
      2   3

Traversal:

2 -> 1 -> 3

-----------------------------------------

Recursive Formula

inorder(node)

{
    inorder(node.left);

    visit(node);

    inorder(node.right);
}

-----------------------------------------

Base Condition

If node == null

return

-----------------------------------------

Important Observation

Inorder Traversal of a BST
always produces sorted order.

This is one of the most important BST properties.

-----------------------------------------

Pattern Recognition

Keywords:

✔ Inorder Traversal
✔ BST Sorted Output
✔ DFS Traversal
✔ Left Root Right

Think:

Recursion

-----------------------------------------

Memory Trick

PREORDER

Root Left Right

INORDER

Left Root Right

POSTORDER

Left Right Root

-----------------------------------------

Common Interview Mistakes

1. Forgetting base condition.
2. Visiting root before left subtree.
3. Confusing preorder and inorder.
4. Missing null checks.
5. Creating new list inside recursion.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(n)

Every node visited once.

Space Complexity:

O(h)

h = height of tree

Worst Case:

O(n)

Skewed Tree

Best Case:

O(log n)

Balanced Tree

--------------------------------------------------

Related Questions

1. Binary Tree Inorder Traversal (LeetCode 94)
2. Binary Tree Preorder Traversal (LeetCode 144)
3. Binary Tree Postorder Traversal (LeetCode 145)
4. Binary Tree Level Order Traversal (LeetCode 102)
5. Validate BST (LeetCode 98)
6. Kth Smallest Element in BST (LeetCode 230)
7. Recover Binary Search Tree (LeetCode 99)

--------------------------------------------------

Company Tags

Broadcom
ARM
Seagate Technology
Rockstar Games
Freshworks
Johnson & Johnson
PayPal
HashiCorp
Medtronic
Goldman Sachs
Epic Games
Flipkart
Wayfair
Snowflake
Intel
AMD
Morgan Stanley
Uber
Airbnb
Target
Swiggy
MongoDB
Boston Consulting Group
Reddit
Bloomberg
Google
Microsoft
Amazon
Meta
Apple
Netflix
Adobe
*/

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val,
             TreeNode left,
             TreeNode right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private void helper(TreeNode root,
                        List<Integer> ans) {

        if (root == null)
            return;

        helper(root.left, ans);

        ans.add(root.val);

        helper(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }
}

public class Binary_Tree_Inorder_Traversal {

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5

        Inorder:
        4 2 5 1 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        List<Integer> ans =
                obj.inorderTraversal(root);

        System.out.println("Inorder Traversal: "
                + ans);
    }
}