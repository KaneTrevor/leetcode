/*
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/
#include <iostream>
#include <math.h>
#include <vector>
#include <set>
#include <algorithm>


class Solution {
public:
    double findMedianSortedArrays(std::vector<int> &a, std::vector<int> &b) {
        int total_size = a.size() + b.size();
        std::vector<int>::size_type ia = 0;
        std::vector<int>::size_type ib = 0;
        int i = -1;
        int odd = total_size % 2;
        int ret_x = 0;
        int ret_y = 0;
        int find_flag = 0;
        double ret = 0;

        if (!a.size()) {
            if (odd) {
                return b[total_size / 2];
            } else {
                return (b[total_size / 2 - 0.5] + b[total_size / 2 + 0.5]) / 2.0;
            }
        } else if (!b.size()) {
            if (odd) {
                return a[total_size / 2];
            } else {
                return (a[total_size / 2 - 0.5] + a[total_size / 2 + 0.5]) / 2.0;
            }
        } else {
            while (i < total_size / 2 + 1) {
                i++;
                if (ia >= a.size()) {
                    //do not find median after traversing list a, then the median must in list b
                    if (odd) {
                        ret = b[total_size / 2 - a.size()];
                        break;
                    } else {
                        if (!find_flag) {
                            ret_x = b[total_size / 2 - a.size() - 1];
                        }
                        ret_y = b[total_size / 2 - a.size()];
                        ret = (ret_x + ret_y) / 2.0;
                        break;
                    }
                }

                if (ib >= b.size()) {
                    //do not find median after traversing list b, then the median must in list a
                    if (odd) {
                        ret = a[total_size / 2 - b.size()];
                        break;
                    } else {
                        if (!find_flag) {
                            ret_x = a[total_size / 2 - b.size() - 1];
                        }
                        ret_y = a[total_size / 2 - b.size()];
                        ret = (ret_x + ret_y) / 2.0;
                        break;
                    }
                }

                if (a[ia] < b[ib]) {
                    //move the smallest element of the list to the back
                    if (odd) {
                        if (i >= total_size / 2) {
                            ret = a[ia];
                            break;
                        }
                    } else {
                        if (i == total_size / 2 - 1) {
                            ret_x = a[ia];
                            find_flag = 1;
                        } else if (i == total_size / 2) {
                            ret_y = a[ia];
                            ret = (ret_x + ret_y) / 2.0;
                            break;
                        }
                    }
                    ia++;
                } else {
                    if (odd) {
                        if (i >= total_size / 2) {
                            ret = b[ib];
                            break;
                        }
                    } else {
                        if (i == total_size / 2 - 1) {
                            ret_x = b[ib];
                            find_flag = 1;
                        } else if (i == total_size / 2) {
                            ret_y = b[ib];
                            ret = (ret_x + ret_y) / 2.0;
                            break;
                        }
                    }
                    ib++;
                }
            }
        }
        return ret;
    }
};


int main(int argc, char *argv[]) {
    std::vector<int> a = {1, 2};
    std::vector<int> b = {3, 4};
    Solution s;
    double ret = s.findMedianSortedArrays(a, b);
    std::cout << "ret: " << ret << std::endl;
    system("pause");
    return (0);
}

