// Last updated: 7/9/2026, 10:06:59 AM
import java.util.Arrays;

class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;

        long[] minVal = new long[m];
        long[] secondMin = new long[m];

        for (int i = 0; i < m; i++) {
            Arrays.sort(units[i]);
            minVal[i] = units[i][0];
            secondMin[i] = (units[i].length > 1) ? units[i][1] : 0;
        }

        long S = 0;
        for (int i = 0; i < m; i++) S += Math.max(minVal[i], secondMin[i]);

        long sourceMin1 = Long.MAX_VALUE, sourceMin2 = Long.MAX_VALUE;
        int countMin1 = 0;

        for (int i = 0; i < m; i++) {
            if (secondMin[i] > minVal[i]) {
                if (minVal[i] < sourceMin1) {
                    sourceMin2 = sourceMin1;
                    sourceMin1 = minVal[i];
                    countMin1 = 1;
                } else if (minVal[i] == sourceMin1) {
                    countMin1++;
                } else if (minVal[i] < sourceMin2) {
                    sourceMin2 = minVal[i];
                }
            }
        }

        long best = 0;
        for (int k = 0; k < m; k++) {
            long baseWithoutK = S - Math.max(minVal[k], secondMin[k]);

            long effSourceMin;
            if (secondMin[k] > minVal[k]) {
                if (minVal[k] == sourceMin1 && countMin1 == 1) {
                    effSourceMin = sourceMin2;
                } else {
                    effSourceMin = sourceMin1;
                }
            } else {
                effSourceMin = sourceMin1;
            }

            long newRating = (effSourceMin == Long.MAX_VALUE) ? minVal[k] : Math.min(minVal[k], effSourceMin);
            long total = baseWithoutK + newRating;
            best = Math.max(best, total);
        }

        return best;
    }
}
