"""
30. Substring with Concatenation of All Words

You are given a string s and an array of strings words of the same length. Return all starting indices
of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without
any intervening characters.

You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

"""

import copy


class Solution:
    def findSubstring(self, src, words):
        if len(words) == 0:
            return []
        lenWords = len(words[0])
        lenStr = lenWords * len(words)
        lenSrc = len(src)
        ret = []
        for i in range(lenSrc - lenStr + 1):
            tmp = copy.copy(words)
            if src[i:i + lenWords] in words:
                j = i
                while True:
                    if src[j:j + lenWords] in tmp:
                        tmp.remove(src[j:j + lenWords])
                        j += lenWords
                    elif len(tmp) == 0:
                        ret.append(i)
                        break
                    else:
                        break
        return ret


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    x = ["foo","bar"]
    s = "barfoothefoobarman"
    ret = Solution().findSubstring(s, x)

    endTime = datetime.datetime.now()
    print 'output:', ret
    print 'running time:%s', (endTime - startTime)
