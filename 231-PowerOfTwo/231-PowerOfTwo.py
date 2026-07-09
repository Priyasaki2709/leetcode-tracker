# Last updated: 7/9/2026, 10:07:04 AM
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
            return n > 0 and (n & (n - 1)) == 0    