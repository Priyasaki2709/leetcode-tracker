// Last updated: 7/14/2026, 10:41:15 PM
1class Solution {
2    public List<Integer> inorderTraversal(TreeNode root) {
3        List<Integer> result = new ArrayList<>();
4        inorder(root, result);
5        return result;
6    }
7
8    private void inorder(TreeNode node, List<Integer> result) {
9        if (node == null)
10            return;
11
12        inorder(node.left, result);
13        result.add(node.val);
14        inorder(node.right, result);
15    }
16}