/*
Question: Binary Tree Postorder Traversal

LeetCode 145

Problem Statement:

Given the root of a binary tree,
return the postorder traversal of its nodes' values.

Postorder Traversal Order:

Left -> Right -> Root

--------------------------------------------------

Example:

Input:

        1
       / \
      2   3
     / \
    4   5

Output:

[4, 5, 2, 3, 1]

--------------------------------------------------

Approach 1: Recursive DFS

Key Idea:

For every node:

1. Traverse Left Subtree
2. Traverse Right Subtree
3. Visit Current Node

This naturally follows postorder traversal.

--------------------------------------------------

Recursive Algorithm

postorder(node)

1. If node == null
      return

2. Traverse left subtree

3. Traverse right subtree

4. Visit current node

--------------------------------------------------

Approach 2: Iterative Traversal (Single Stack + Reverse)

Observation:

Postorder:

Left Right Root

If we perform:

Root Right Left

and reverse the answer,

we get:

Left Right Root

which is exactly Postorder.

--------------------------------------------------

Iterative Algorithm

1. Push root into stack.
2. Pop node and store in answer.
3. Push left child.
4. Push right child.
5. Continue until stack becomes empty.
6. Reverse the answer list.

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

Push 2
Push 3

Stack:

[2,3]

Pop 3

Answer:

[1,3]

Pop 2

Answer:

[1,3,2]

Push 4
Push 5

Answer:

[1,3,2,5,4]

Reverse

[4,5,2,3,1]

--------------------------------------------------

Revision Notes

Problem:

Return Postorder Traversal
of a Binary Tree.

-----------------------------------------

Traversal Order

Left

Right

Root

-----------------------------------------

Visualization

        1
       / \
      2   3
     / \
    4   5

Postorder:

4 → 5 → 2 → 3 → 1

-----------------------------------------

Recursive Formula

postorder(node)

{
    postorder(node.left);

    postorder(node.right);

    visit(node);
}

-----------------------------------------

Iterative Trick

Postorder

Left Right Root

Reverse of

Root Right Left

-----------------------------------------

Stack Trick

Normal Preorder:

Root Left Right

Modified Preorder:

Root Right Left

Reverse Answer

= Postorder

-----------------------------------------

Pattern Recognition

Keywords:

✔ Tree Traversal
✔ DFS
✔ Left Right Root

Think:

Postorder Traversal

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

1. Writing Left Root Right (Inorder).
2. Writing Root Left Right (Preorder).
3. Forgetting to reverse iterative answer.
4. Pushing children in wrong order.
5. Missing base case.

--------------------------------------------------

Complexity Analysis

Recursive:

Time Complexity: O(n)

Space Complexity: O(h)

--------------------------------------------------

Iterative:

Time Complexity: O(n)

Space Complexity: O(n)

--------------------------------------------------

Related Questions

1. Binary Tree Postorder Traversal (LeetCode 145)
2. Binary Tree Preorder Traversal (LeetCode 144)
3. Binary Tree Inorder Traversal (LeetCode 94)
4. Binary Tree Level Order Traversal (LeetCode 102)
5. Binary Tree Zigzag Level Order Traversal
6. Flatten Binary Tree to Linked List
7. Path Sum Problems

--------------------------------------------------

Company Tags

Twilio
Johnson & Johnson
McKinsey & Company
Zoho
Micron Technology
PwC
Shopify
Zynga
Riot Games
Bain & Company
Flipkart
Square
Reddit
Walmart
Intel
Lyft
Etsy
Cloudflare
DoorDash
Freshworks
Goldman Sachs
Philips Healthcare
KPMG
MongoDB
PayPal
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

/* =====================================================
   APPROACH 1 : RECURSIVE POSTORDER
   ===================================================== */

class RecursiveSolution {

    private void helper(TreeNode root,
                        List<Integer> ans) {

        if (root == null)
            return;

        helper(root.left, ans);

        helper(root.right, ans);

        ans.add(root.data);
    }

    public List<Integer> postorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }
}

/* =====================================================
   APPROACH 2 : ITERATIVE POSTORDER
   (Root Right Left + Reverse)
   ===================================================== */

class IterativeSolution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {

            TreeNode node = nodeStack.pop();

            result.add(node.data);

            // Push left first
            if (node.left != null) {
                nodeStack.push(node.left);
            }

            // Push right second
            if (node.right != null) {
                nodeStack.push(node.right);
            }
        }

        Collections.reverse(result);

        return result;
    }
}

/* =====================================================
   DRIVER CLASS
   ===================================================== */

public class Binary_Tree_Postorder_Traversal {

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                 / \
                4   5

            Postorder:
            4 5 2 3 1
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
                "Recursive Postorder : "
                + recursive.postorder(root));

        System.out.println(
                "Iterative Postorder : "
                + iterative.postorderTraversal(root));
    }
}