/*
Question: Preorder, Inorder and Postorder Traversal in One Traversal

Problem Statement:

Given the root of a binary tree,
return:

1. Inorder Traversal
2. Preorder Traversal
3. Postorder Traversal

using a SINGLE traversal of the tree.

Return:

[
   inorder,
   preorder,
   postorder
]

--------------------------------------------------

Example:

Input:

                1
              /   \
             2     3
            / \
           4   5

Output:

Inorder:

[4,2,5,1,3]

Preorder:

[1,2,4,5,3]

Postorder:

[4,5,2,3,1]

--------------------------------------------------

Brute Force

Perform:

1. Preorder Traversal
2. Inorder Traversal
3. Postorder Traversal

separately.

Time Complexity:

O(3N)

--------------------------------------------------

Optimal Approach

Perform all three traversals
in a single DFS traversal.

--------------------------------------------------

Key Idea

Every node is visited 3 times:

First Time:
Preorder Position

Second Time:
Inorder Position

Third Time:
Postorder Position

We simulate recursion using a stack.

--------------------------------------------------

Node States

State = 1

Node visited first time

Process:

Preorder

Move Left

----------------------------

State = 2

Node visited second time

Process:

Inorder

Move Right

----------------------------

State = 3

Node visited third time

Process:

Postorder

Finished

--------------------------------------------------

Visualization

Tree:

                1
              /   \
             2     3
            / \
           4   5

--------------------------------

Visit 1

State 1

Preorder:

[1]

--------------------------------

Visit 2

State 1

Preorder:

[1,2]

--------------------------------

Visit 4

State 1

Preorder:

[1,2,4]

--------------------------------

State 2

Inorder:

[4]

--------------------------------

State 3

Postorder:

[4]

--------------------------------

Continue similarly

Final

Preorder:

[1,2,4,5,3]

Inorder:

[4,2,5,1,3]

Postorder:

[4,5,2,3,1]

--------------------------------------------------

Approach

Use Stack<Pair<Node, State>>

State Meaning:

1 -> Preorder

2 -> Inorder

3 -> Postorder

--------------------------------

When state = 1

Add to preorder

Push same node with state 2

Push left child

--------------------------------

When state = 2

Add to inorder

Push same node with state 3

Push right child

--------------------------------

When state = 3

Add to postorder

--------------------------------------------------

Revision Notes

Problem:

Generate all three traversals
using one traversal.

-----------------------------------------

Most Important Idea

Every node participates in:

Preorder
Inorder
Postorder

at different moments.

-----------------------------------------

State Mapping

State 1

Preorder

--------------------------------

State 2

Inorder

--------------------------------

State 3

Postorder

-----------------------------------------

Why Does It Work?

It perfectly simulates
recursive function calls.

-----------------------------------------

Recursive View

preorder(root)

inorder(root)

postorder(root)

occur at different stages
of recursion.

State variable tracks those stages.

-----------------------------------------

Pattern Recognition

Keywords:

✔ All Traversals Together
✔ Single Traversal
✔ Simulate Recursion
✔ Iterative DFS

Think:

Stack + State

-----------------------------------------

Memory Trick

1

PRE

----------------

2

IN

----------------

3

POST

-----------------------------------------

Common Interview Mistakes

1. Forgetting to reinsert node.
2. Incorrect state transition.
3. Pushing right child before state 3.
4. Returning traversals in wrong order.
5. Using separate traversals.

--------------------------------------------------

Complexity Analysis

Time Complexity:

O(N)

Each node processed exactly 3 times.

--------------------------------------------------

Space Complexity:

O(N)

Stack + Traversal Lists

--------------------------------------------------

Why Is This Better?

Separate Traversals:

O(3N)

Single Traversal:

O(N)

One DFS pass.

--------------------------------------------------

Related Questions

1. Binary Tree Preorder Traversal (LeetCode 144)
2. Binary Tree Inorder Traversal (LeetCode 94)
3. Binary Tree Postorder Traversal (LeetCode 145)
4. Morris Traversal
5. Binary Tree Level Order Traversal (LeetCode 102)
6. Iterative Postorder Traversal
7. BST Iterator

--------------------------------------------------

Company Tags

Optum
Philips Healthcare
Activision Blizzard
Micron Technology
Riot Games
Cerner
Broadcom
Square
Nutanix
Siemens Healthineers
Docker
KPMG
HashiCorp
Red Hat
Robinhood
McKinsey & Company
Zoho
Qualcomm
Freshworks
Byju's
Texas Instruments
Unity Technologies
Epic Systems
Dropbox
Visa
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

// Helper Class
class NodeState {

    TreeNode node;
    int state;

    NodeState(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

class Solution {

    public List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) {
            return Arrays.asList(in, pre, post);
        }

        Stack<NodeState> st = new Stack<>();

        st.push(new NodeState(root, 1));

        while (!st.isEmpty()) {

            NodeState top = st.pop();

            TreeNode node = top.node;
            int state = top.state;

            // PREORDER
            if (state == 1) {

                pre.add(node.data);

                st.push(new NodeState(node, 2));

                if (node.left != null) {
                    st.push(new NodeState(node.left, 1));
                }
            }

            // INORDER
            else if (state == 2) {

                in.add(node.data);

                st.push(new NodeState(node, 3));

                if (node.right != null) {
                    st.push(new NodeState(node.right, 1));
                }
            }

            // POSTORDER
            else {

                post.add(node.data);
            }
        }

        return Arrays.asList(in, pre, post);
    }
}

public class Preorder_Inorder_Postorder_In_One_Traversal {

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                 / \
                4   5

            Preorder:
            [1,2,4,5,3]

            Inorder:
            [4,2,5,1,3]

            Postorder:
            [4,5,2,3,1]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution obj = new Solution();

        List<List<Integer>> result =
                obj.treeTraversal(root);

        System.out.println("Inorder   : "
                + result.get(0));

        System.out.println("Preorder  : "
                + result.get(1));

        System.out.println("Postorder : "
                + result.get(2));
    }
}