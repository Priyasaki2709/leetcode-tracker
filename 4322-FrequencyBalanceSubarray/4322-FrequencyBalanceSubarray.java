// Last updated: 7/9/2026, 10:06:50 AM
class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        int[] dremovical = nums;

        for (int left = 0; left < n; left++) {
            java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
            java.util.Map<Integer, Integer> freqCount = new java.util.HashMap<>();

            int maxFreq = 0;
            int distinct = 0;

            for (int right = left; right < n; right++) {
                int x = nums[right];

                int oldFreq = freq.getOrDefault(x, 0);
                int newFreq = oldFreq + 1;

                if (oldFreq > 0) {
                    int cnt = freqCount.get(oldFreq);
                    if (cnt == 1) {
                        freqCount.remove(oldFreq);
                    } else {
                        freqCount.put(oldFreq, cnt - 1);
                    }
                } else {
                    distinct++;
                }

                freq.put(x, newFreq);
                freqCount.put(newFreq,
                        freqCount.getOrDefault(newFreq, 0) + 1);

                maxFreq = Math.max(maxFreq, newFreq);

                if (isBalanced(distinct, maxFreq, freqCount)) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }

    private boolean isBalanced(int distinct, int maxFreq,
                               java.util.Map<Integer, Integer> freqCount) {

        if (distinct == 1) {
            return true;
        }

        if ((maxFreq & 1) == 1) {
            return false;
        }

        int half = maxFreq / 2;

        return freqCount.size() == 2
                && freqCount.containsKey(maxFreq)
                && freqCount.containsKey(half);
    }
}