"""
11. Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water
(blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
"""


class Solution(object):
    def __init__(self):
        self.storedMaxArea = 0
        self.left = 0
        self.right = 0

    def maxArea(self, height):
        length = len(height)
        self.right = length - 1
        if length < 3:
            return min(height[0], height[1])

        while self.right > self.left:
            area = (self.right - self.left) * min(height[self.left], height[self.right])
            if area > self.storedMaxArea:
                self.storedMaxArea = area
            if height[self.left] < height[self.right]:
                self.left = self.left + 1
            else:
                self.right = self.right - 1
        return self.storedMaxArea


if __name__ == '__main__':
    test = Solution()
    lists = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    test.maxArea(lists)
    print 'area:', test.storedMaxArea
