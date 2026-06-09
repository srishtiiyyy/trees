/*
Question: Binary Tree Inorder Traversal (Iterative)

Problem Statement:

Given the root of a binary tree,
return its inorder traversal.

Inorder Traversal Order:

Left -> Root -> Right

The challenge is to perform the traversal
without using recursion.

--------------------------------------------------

Example:

Input:

        1
       / \
      2   3
     / \
    4   5

Output:

[4, 2, 5, 1, 3]

--------------------------------------------------

Approach: Iterative Inorder Traversal

Key Idea:

Recursion uses the call stack internally.

To perform inorder traversal iteratively,
we explicitly use a Stack.

--------------------------------------------------

Algorithm

1. Initialize an empty stack.
2. Start from root node.
3. Keep moving left and push nodes into stack.
4. When NULL is reached:
      a) Pop node from stack.
      b) Process node.
      c) Move to right child.
5. Repeat until:
      current node = NULL
      AND
      stack becomes empty.

--------------------------------------------------

Visualization

Tree:

        1
       / \
      2   3
     / \
    4   5

--------------------------------

Push Path

Push 1
Push 2
Push 4

Stack:

[1, 2, 4]

--------------------------------

Pop 4

Answer:

[4]

--------------------------------

Pop 2

Answer:

[4, 2]

Move to 5

Push 5

Pop 5

Answer:

[4, 2, 5]

--------------------------------

Pop 1

Answer:

[4, 2, 5, 1]

Move to 3

Push 3

Pop 3

Answer:

[4, 2, 5, 1, 3]

--------------------------------------------------

Dry Run

Input:

        1
       / \
      2   3

Stack:

[]

Push 1

Push 2

Pop 2

Answer:

[2]

Pop 1

Answer:

[2,1]

Move Right -> 3

Pop 3

Answer:

[2,1,3]

--------------------------------------------------

Revision Notes

Problem:

Perform inorder traversal
without recursion.

-----------------------------------------

Traversal Order

Left

Root

Right

-----------------------------------------

Key Idea

Keep going left.

Push every node encountered.

When NULL reached:

Pop

Visit

Move Right

-----------------------------------------

Stack Meaning

Stack stores nodes whose:

Left subtree has not been fully processed.

-----------------------------------------

Important Observation

Recursive inorder:

inorder(left)
visit(root)
inorder(right)

Iterative inorder simulates
the recursion stack manually.

-----------------------------------------

Pattern Recognition

Keywords:

✔ Iterative Tree Traversal
✔ No Recursion Allowed
✔ DFS using Stack

Think:

Explicit Stack

-----------------------------------------

Memory Trick

Go Left

Push Push Push

NULL?

Pop

Visit

Go Right

Repeat

-----------------------------------------

Common Interview Mistakes

1. Forgetting to move right after pop.
2. Visiting node before left subtree.
3. Using queue instead of stack.
4. Loop condition mistakes.
5. Missing stack empty check.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(n)

Every node is:

Pushed once
Popped once

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

Recursive vs Iterative

Recursive:

✔ Easy to write
✔ Cleaner

✖ Uses recursion stack

-----------------------------------------

Iterative:

✔ No recursion
✔ Better interview follow-up

✔ Explicit stack control

--------------------------------------------------

Related Questions

1. Binary Tree Inorder Traversal (LeetCode 94)
2. Binary Tree Preorder Traversal (LeetCode 144)
3. Binary Tree Postorder Traversal (LeetCode 145)
4. Binary Tree Level Order Traversal (LeetCode 102)
5. Morris Inorder Traversal
6. BST Iterator (LeetCode 173)
7. Validate BST (LeetCode 98)

--------------------------------------------------

Company Tags

Google
Microsoft
Amazon
Meta
Apple
Netflix
Adobe
Bloomberg
Uber
Airbnb
Stripe
Goldman Sachs
Morgan Stanley
Intel
AMD
NVIDIA
Reddit
PayPal
Twilio
Oracle
Salesforce
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    // Iterative Inorder Traversal
    public List<Integer> inorder(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        List<Integer> inorder = new ArrayList<>();

        while (true) {

            if (node != null) {

                st.push(node);

                node = node.left;
            }

            else {

                if (st.isEmpty()) {
                    break;
                }

                node = st.pop();

                inorder.add(node.data);

                node = node.right;
            }
        }

        return inorder;
    }
}

public class Binary_Tree_Inorder_Traversal_Iterative {

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

        List<Integer> ans = obj.inorder(root);

        System.out.println("Inorder Traversal: "
                + ans);
    }
}