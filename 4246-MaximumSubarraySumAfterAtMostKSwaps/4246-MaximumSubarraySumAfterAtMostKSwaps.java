// Last updated: 7/9/2026, 10:06:55 AM
import java.util.*;

class Solution {
    public long maxSum(int[] nums, int k) {
        int n = nums.length;
        long best = Long.MIN_VALUE;

        int[] desc = nums.clone();
        for (int i = 0; i < n; i++) desc[i] = -nums[i];
        Arrays.sort(desc);
        long[] gPfx = new long[n + 1];
        for (int i = 0; i < n; i++) gPfx[i + 1] = gPfx[i] - desc[i];

        for (int l = 0; l < n; l++) {
            int[] inside = new int[n];
            int[] outside = new int[n];
            int inSz = 0, outSz = 0;

            for (int i = 0; i < n; i++) {
                if (i != l) outside[outSz++] = nums[i];
            }
            Arrays.sort(outside, 0, outSz);

            inside[inSz++] = nums[l];
            long windowSum = nums[l];

            int len = 1;
            if (k >= len) best = Math.max(best, gPfx[len]);
            else {
                long sum = windowSum;
                for (int j = 0; j < k && outSz - 1 - j >= 0; j++) {
                    long outVal = outside[outSz - 1 - j];
                    long inVal = inside[j];
                    if (outVal <= inVal) break;
                    sum += outVal - inVal;
                }
                best = Math.max(best, sum);
            }

            for (int r = l + 1; r < n; r++) {
                int val = nums[r];
                windowSum += val;
                int pos = lowerBound(outside, 0, outSz, val);
                System.arraycopy(outside, pos + 1, outside, pos, outSz - pos - 1);
                outSz--;
                int ipos = lowerBound(inside, 0, inSz, val);
                System.arraycopy(inside, ipos, inside, ipos + 1, inSz - ipos);
                inside[ipos] = val;
                inSz++;

                len = r - l + 1;

                if (k >= len) {
                    best = Math.max(best, gPfx[len]);
                    continue;
                }

                long sum = windowSum;
                for (int j = 0; j < k && outSz - 1 - j >= 0; j++) {
                    long outVal = outside[outSz - 1 - j];
                    long inVal = inside[j];
                    if (outVal <= inVal) break;
                    sum += outVal - inVal;
                }
                best = Math.max(best, sum);
            }
        }

        return best;
    }

    int lowerBound(int[] arr, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}