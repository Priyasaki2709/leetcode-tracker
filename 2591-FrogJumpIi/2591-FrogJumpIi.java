// Last updated: 7/9/2026, 10:07:00 AM
class Solution {
    public int maxJump(int[] stones) {

        int maxCost = stones[1] - stones[0];

        for (int i = 2; i < stones.length; i++) {
            maxCost = Math.max(
                maxCost,
                stones[i] - stones[i - 2]
            );
        }

        return maxCost;
    }
}