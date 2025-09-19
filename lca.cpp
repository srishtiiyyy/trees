#include <bits/stdc++.h>
using namespace std;

/*
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

// ------------------- Binary Tree LCA -------------------
TreeNode* lowestCommonAncestorBT(TreeNode* root, TreeNode* p, TreeNode* q) {
    if (root == NULL || root == p || root == q)
        return root;

    TreeNode* leftn = lowestCommonAncestorBT(root->left, p, q);
    TreeNode* rightn = lowestCommonAncestorBT(root->right, p, q);

    if (leftn != NULL && rightn != NULL)
        return root;

    return (leftn != NULL) ? leftn : rightn;
}

// ------------------- BST LCA -------------------
TreeNode* lowestCommonAncestorBST(TreeNode* root, TreeNode* p, TreeNode* q) {
    if (root == NULL) return NULL;

    if (p->val < root->val && q->val < root->val)
        return lowestCommonAncestorBST(root->left, p, q);

    if (p->val > root->val && q->val > root->val)
        return lowestCommonAncestorBST(root->right, p, q);

    return root; // current node is LCA
}

// ------------------- Helper Function to Build a Simple Binary Tree -------------------
TreeNode* buildSampleBinaryTree() {
    // Binary Tree (not BST)
    //        3
    //       / \
    //      5   1
    //     / \ / \
    //    6  2 0  8
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(5);
    root->right = new TreeNode(1);
    root->left->left = new TreeNode(6);
    root->left->right = new TreeNode(2);
    root->right->left = new TreeNode(0);
    root->right->right = new TreeNode(8);
    return root;
}

// ------------------- Helper Function to Build a Simple BST -------------------
TreeNode* buildSampleBST() {
    // BST
    //        6
    //       / \
    //      2   8
    //     / \ / \
    //    0  4 7  9
    //      / \
    //     3   5
    TreeNode* root = new TreeNode(6);
    root->left = new TreeNode(2);
    root->right = new TreeNode(8);
    root->left->left = new TreeNode(0);
    root->left->right = new TreeNode(4);
    root->left->right->left = new TreeNode(3);
    root->left->right->right = new TreeNode(5);
    root->right->left = new TreeNode(7);
    root->right->right = new TreeNode(9);
    return root;
}

// ------------------- Main Function -------------------
int main() {
    // ----- Test Binary Tree LCA -----
    TreeNode* rootBT = buildSampleBinaryTree();
    TreeNode* pBT = rootBT->left;        // Node 5
    TreeNode* qBT = rootBT->right;       // Node 1
    TreeNode* lcaBT = lowestCommonAncestorBT(rootBT, pBT, qBT);
    cout << "Binary Tree LCA of " << pBT->val << " and " << qBT->val << " = " << lcaBT->val << endl;

    // ----- Test BST LCA -----
    TreeNode* rootBST = buildSampleBST();
    TreeNode* pBST = rootBST->left;        // Node 2
    TreeNode* qBST = rootBST->left->right; // Node 4
    TreeNode* lcaBST = lowestCommonAncestorBST(rootBST, pBST, qBST);
    cout << "BST LCA of " << pBST->val << " and " << qBST->val << " = " << lcaBST->val << endl;

    return 0;
}
