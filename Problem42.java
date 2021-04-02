/*
42. First Missing Positive

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 */

class Problem42 {
    public int trap(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int length = nums.length;
        int area = 0, left, right, lIndex, rIndex;

        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0 && nums[i] > nums[i + 1]) {
                left = nums[i];
                right = 0;
                rIndex = 0;
                lIndex = i;
                int secondHigh = nums[i + 1];

                for (int j = i + 2; j < length; j++) {
                    if (nums[j] > secondHigh) {
                        secondHigh = nums[j];
                        right = nums[j];
                        rIndex = j;

                        if (right >= left) {
                            break;
                        }
                    }
                }

                if (right > 0) {
                    for (int t = lIndex + 1; t < rIndex; t++) {
                        area -= nums[t];
                    }

                    i = rIndex - 1;
                    int height = Math.min(left, right);
                    area += height * (rIndex - lIndex - 1);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int ret = new Problem42().trap(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}