/*
====================================================================
LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
====================================================================

📝 Problem Statement:
Given two integer arrays `preorder` and `inorder` where `preorder` is 
the preorder traversal of a binary tree and `inorder` is the inorder 
traversal of the same tree, construct and return the binary tree.

--------------------------------------------------------------------
Example 1:
Input:
    preorder = [3,9,20,15,7]
    inorder  = [9,3,15,20,7]

Output:
    The constructed binary tree is:
            3
           / \
          9   20
             /  \
            15   7

Example 2:
Input:
    preorder = [-1]
    inorder  = [-1]
Output:
    Tree with single node (-1)

--------------------------------------------------------------------
💡 Approach:
1. The first element in preorder is always the root of the tree.
2. Use a hash map (`inMap`) to store indices of inorder elements for O(1) lookup.
3. Find the root’s index in inorder, which divides the tree into left and right subtrees.
4. Recursively construct left and right subtrees using the divided ranges.
5. Return the constructed root.

Time Complexity: O(n)  
Space Complexity: O(n)  (hash map + recursion stack)

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

// -------------------- HELPER FUNCTION TO BUILD TREE --------------------
TreeNode* buildTreeHelper(vector<int>& preorder, int preStart, int preEnd,
                          vector<int>& inorder, int inStart, int inEnd,
                          unordered_map<int, int>& inMap) {
    if (preStart > preEnd || inStart > inEnd) return nullptr;

    // Root is always the first element in preorder
    TreeNode* root = new TreeNode(preorder[preStart]);

    // Get index of root in inorder
    int inRoot = inMap[root->val];
    int numsLeft = inRoot - inStart;

    // Recursively build left and right subtrees
    root->left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft,
                                 inorder, inStart, inRoot - 1, inMap);
    root->right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd,
                                  inorder, inRoot + 1, inEnd, inMap);

    return root;
}

// -------------------- MAIN FUNCTION TO BUILD TREE --------------------
TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    unordered_map<int, int> inMap;
    for (int i = 0; i < inorder.size(); i++) {
        inMap[inorder[i]] = i;
    }
    return buildTreeHelper(preorder, 0, preorder.size() - 1,
                           inorder, 0, inorder.size() - 1, inMap);
}

// -------------------- HELPER FUNCTION TO PRINT TREE (INORDER) --------------------
void printInorder(TreeNode* root) {
    if (!root) return;
    printInorder(root->left);
    cout << root->val << " ";
    printInorder(root->right);
}

// -------------------- MAIN FUNCTION --------------------
int main() {
    vector<int> preorder = {3, 9, 20, 15, 7};
    vector<int> inorder  = {9, 3, 15, 20, 7};

    TreeNode* root = buildTree(preorder, inorder);

    cout << "Inorder traversal of constructed tree: ";
    printInorder(root);  // Expected Output: 9 3 15 20 7
    cout << endl;

    return 0;
}
