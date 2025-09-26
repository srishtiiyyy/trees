/*
====================================================================
LeetCode 199: Binary Tree Right Side View
====================================================================

📝 Problem Statement:
Given the root of a binary tree, imagine yourself standing on the 
right side of it. Return the values of the nodes you can see ordered 
from top to bottom.

--------------------------------------------------------------------
Example 1:
Input: [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: [1,null,3]
Output: [1,3]

Example 3:
Input: []
Output: []

--------------------------------------------------------------------
💡 Approach:
We want the last node of each level in a level-order traversal (BFS).
1. Perform BFS using a queue.
2. For each level, process all nodes.
   - Push their children into the queue.
   - Track the last node of the level.
3. Add the last node’s value into the result.
4. Return the result vector.

Time Complexity: O(n)  where n = number of nodes
Space Complexity: O(n)  for the queue

====================================================================
*/

#include <bits/stdc++.h>
using namespace std;

// -------------------- BINARY TREE NODE DEFINITION --------------------
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// -------------------- FUNCTION TO GET RIGHT VIEW --------------------
vector<int> rightSideView(TreeNode* root) {
    if (root == NULL) return {};
    
    queue<TreeNode*> q;
    vector<int> ans;
    q.push(root);

    while (!q.empty()) {
        int n = q.size();
        TreeNode* node = NULL;

        while (n--) {
            node = q.front();
            q.pop();

            if (node->left != NULL) q.push(node->left);
            if (node->right != NULL) q.push(node->right);
        }

        // Last node of this level
        ans.push_back(node->val);
    }

    return ans;
}

// -------------------- HELPER FUNCTION TO PRINT VECTOR --------------------
void printVector(vector<int>& v) {
    for (int x : v) cout << x << " ";
    cout << endl;
}

// -------------------- MAIN FUNCTION --------------------
int main() {
    /*
        Construct the following binary tree:
                1
               / \
              2   3
               \    \
                5    4
        Expected Right Side View = [1, 3, 4]
    */

    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->right = new TreeNode(5);
    root->right->right = new TreeNode(4);

    vector<int> result = rightSideView(root);

    cout << "Right Side View of the Tree: ";
    printVector(result);  // Expected Output: 1 3 4

    return 0;
}
