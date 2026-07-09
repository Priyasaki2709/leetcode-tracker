// Last updated: 7/9/2026, 10:07:30 AM
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
        

    }
    public boolean isMirror(TreeNode left,TreeNode right){
        if (left == null && right == null) {
        return true;
        }

        // One null
        if (left == null || right == null) {
            return false;
        }

        // Check values and mirror subtrees
        return (left.val == right.val)
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
