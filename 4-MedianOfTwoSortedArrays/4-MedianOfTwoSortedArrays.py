# Last updated: 7/9/2026, 10:07:55 AM
class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        # Ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        m, n = len(nums1), len(nums2)
        total = m + n
        half = total // 2
        
        left, right = 0, m
        while True:
            i = (left + right) // 2  # Partition index for nums1
            j = half - i  # Partition index for nums2
            
            left1 = nums1[i-1] if i > 0 else float("-inf")
            right1 = nums1[i] if i < m else float("inf")
            left2 = nums2[j-1] if j > 0 else float("-inf")
            right2 = nums2[j] if j < n else float("inf")
            
            if left1 <= right2 and left2 <= right1:
                if total % 2:  # Odd length
                    return min(right1, right2)
                return (max(left1, left2) + min(right1, right2)) / 2
            elif left1 > right2:
                right = i - 1
            else:
                left = i + 1
        