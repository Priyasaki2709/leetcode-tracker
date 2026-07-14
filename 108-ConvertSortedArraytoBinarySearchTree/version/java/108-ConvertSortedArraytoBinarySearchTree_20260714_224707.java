// Last updated: 7/14/2026, 10:47:07 PM
1class Solution {
2    public TreeNode sortedArrayToBST(int[] nums) {
3        return buildTree(nums, 0, nums.length - 1);
4    }
5
6    private TreeNode buildTree(int[] nums, int left, int right) {
7        if (left > right)
8            return null;
9
10        int mid = left + (right - left) / 2;
11
12        TreeNode root = new TreeNode(nums[mid]);
13
14        root.left = buildTree(nums, left, mid - 1);
15        root.right = buildTree(nums, mid + 1, right);
16
17        return root;
18    }
19}