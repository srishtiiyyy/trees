/*
Question: Binary Tree Preorder Traversal

LeetCode 144

Problem Statement:

Given the root of a binary tree,
return the preorder traversal of its nodes' values.

Preorder Traversal Order:

Root -> Left -> Right

--------------------------------------------------

Example:

Input:

        1
       / \
      2   3
     / \
    4   5

Output:

[1, 2, 4, 5, 3]

--------------------------------------------------

Approach 1: Recursive DFS

Key Idea:

Visit current node first,
then recursively traverse left subtree,
followed by right subtree.

Traversal Order:

Root
Left
Right

--------------------------------------------------

Recursive Algorithm

preorder(node)

1. If node == null
      return

2. Visit node

3. Traverse left subtree

4. Traverse right subtree

--------------------------------------------------

Approach 2: Iterative DFS Using Stack

Key Idea:

Recursion internally uses a stack.

We can simulate it explicitly.

Important Trick:

Push Right Child First
Push Left Child Second

Because stack follows LIFO.

This ensures left subtree gets processed first.

--------------------------------------------------

Dry Run

Tree:

        1
       / \
      2   3
     / \
    4   5

Stack:

[1]

Pop 1

Answer:

[1]

Push 3
Push 2

Stack:

[3,2]

Pop 2

Answer:

[1,2]

Push 5
Push 4

Stack:

[3,5,4]

Pop 4

Answer:

[1,2,4]

Pop 5

Answer:

[1,2,4,5]

Pop 3

Answer:

[1,2,4,5,3]

--------------------------------------------------

Revision Notes

Problem:

Return preorder traversal
of a binary tree.

-----------------------------------------

Traversal Order

Root

Left

Right

-----------------------------------------

Visualization

        1
       / \
      2   3
     / \
    4   5

Preorder:

1 → 2 → 4 → 5 → 3

-----------------------------------------

Recursive Formula

preorder(node)

{
    visit(node);

    preorder(node.left);

    preorder(node.right);
}

-----------------------------------------

Iterative Trick

Push:

Right First

Left Second

Because:

Stack = LIFO

-----------------------------------------

Pattern Recognition

Keywords:

✔ DFS Traversal
✔ Root First
✔ Tree Traversal

Think:

Preorder

Root Left Right

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

1. Pushing left child before right child.
2. Forgetting null checks.
3. Confusing preorder with inorder.
4. Visiting node after recursion.
5. Missing stack empty condition.

--------------------------------------------------

Complexity Analysis

Recursive:

Time Complexity: O(n)

Space Complexity: O(h)

h = height of tree

--------------------------------------------------

Iterative:

Time Complexity: O(n)

Space Complexity: O(h)

Worst Case:

O(n)

Skewed Tree

Best Case:

O(log n)

Balanced Tree

--------------------------------------------------

Related Questions

1. Binary Tree Preorder Traversal (LeetCode 144)
2. Binary Tree Inorder Traversal (LeetCode 94)
3. Binary Tree Postorder Traversal (LeetCode 145)
4. Binary Tree Level Order Traversal (LeetCode 102)
5. Path Sum (LeetCode 112)
6. Binary Tree Right Side View (LeetCode 199)
7. Flatten Binary Tree to Linked List (LeetCode 114)

--------------------------------------------------

Company Tags

Deloitte
Ernst & Young
Micron Technology
JPMorgan Chase
Bloomberg
Western Digital
Ubisoft
Roblox
HCL Technologies
Square
ARM
Medtronic
Uber
Target
Boston Consulting Group
Swiggy
Shopify
Chewy
Wayfair
Broadcom
Mastercard
Nutanix
Rockstar Games
Salesforce
Epic Systems
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

    TreeNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

/* =====================================================
   APPROACH 1 : RECURSIVE PREORDER
   ===================================================== */

class RecursiveSolution {

    private void helper(TreeNode root,
                        List<Integer> ans) {

        if (root == null)
            return;

        ans.add(root.data);

        helper(root.left, ans);

        helper(root.right, ans);
    }

    public List<Integer> preorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }
}

/* =====================================================
   APPROACH 2 : ITERATIVE PREORDER
   ===================================================== */

class IterativeSolution {

    public List<Integer> preorder(TreeNode root) {

        List<Integer> preorder = new ArrayList<>();

        if (root == null)
            return preorder;

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {

            TreeNode node = st.pop();

            preorder.add(node.data);

            // Push right first
            if (node.right != null) {
                st.push(node.right);
            }

            // Push left second
            if (node.left != null) {
                st.push(node.left);
            }
        }

        return preorder;
    }
}

/* =====================================================
   DRIVER CLASS
   ===================================================== */

public class Binary_Tree_Preorder_Traversal {

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                 / \
                4   5

            Preorder:
            1 2 4 5 3
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
                "Recursive Preorder : "
                + recursive.preorder(root));

        System.out.println(
                "Iterative Preorder : "
                + iterative.preorder(root));
    }
}