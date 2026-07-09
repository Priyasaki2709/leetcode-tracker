# Last updated: 7/9/2026, 10:07:54 AM
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        # Negative numbers are not palindromes
        # Also, numbers ending in 0 (but not 0 itself) can't be palindromes
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        reversed_half = 0
        while x > reversed_half:
            reversed_half = reversed_half * 10 + x % 10
            x = x // 10
        
        # For even length numbers: x == reversed_half
        # For odd length numbers: x == reversed_half // 10
        return x == reversed_half or x == reversed_half // 10  