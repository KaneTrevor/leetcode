/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
using all the original letters exactly once.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lower-case English letters.

 */


import javafx.util.Pair;

import java.nio.charset.Charset;
import java.util.*;

class Problem49 {
    static class StringList {
        List<String> list = new ArrayList<>();

        public StringList(String one) {
            list.add(one);
        }

        public void addOne(String one) {
            list.add(one);
        }

        public List<String> getList() {
            return list;
        }
    }

    //if we don't use sort
    public List<List<String>> complexAnagrams(String[] strs) {
        List<List<String>> matrix = new ArrayList<>();
        if (strs.length <= 0) {
            return matrix;
        } else if (strs.length <= 1) {
            matrix.add(Collections.singletonList(strs[0]));
            return matrix;
        }

        HashMap<Pair<Integer, Integer>, List<Pair<HashMap<Character, Integer>, StringList>>> strMap = new HashMap<>();

        for (String str : strs) {
            int sum = 0;
            char[] charArr = str.toCharArray();

            for (char ch : charArr) {
                sum += ch;
            }
            Pair<Integer, Integer> strFeature = new Pair<>(str.length(), sum);
            boolean findFlag = false;

            for (Map.Entry<Pair<Integer, Integer>, List<Pair<HashMap<Character, Integer>, StringList>>> entry : strMap.entrySet()) {
                if (strFeature.equals(entry.getKey())) {
                    for (Pair<HashMap<Character, Integer>, StringList> pair : entry.getValue()) {
                        findFlag = true;

                        HashMap<Character, Integer> checkMap = new HashMap<>();
                        for (char ch : charArr) {
                            if (!pair.getKey().containsKey(ch)) {
                                findFlag = false;
                                break;
                            }

                            //checkMap.compute(ch, (w, prev) -> prev != null ? prev + 1 : 1);
                            checkMap.merge(ch, 1, (prev, one) -> prev + one);
                        }

                        if (findFlag && pair.getKey().equals(checkMap)) {
                            pair.getValue().addOne(str);
                            break;
                        } else {
                            findFlag = false;
                        }
                    }
                }
            }

            if (!findFlag) {
                List<Pair<HashMap<Character, Integer>, StringList>> inList = strMap.getOrDefault(strFeature, new ArrayList<>());

                HashMap<Character, Integer> compareMap = new HashMap<>();
                for (char ch : str.toCharArray()) {
                    compareMap.merge(ch, 1, Integer::sum);
                }
                inList.add(new Pair<>(compareMap, new StringList(str)));
                strMap.put(strFeature, inList);
            }
        }

        strMap.forEach((strLen, v) -> v.forEach(
                e -> matrix.add(e.getValue().getList())
                //if (e.getValue().getList().size() > 1) {
                //    System.out.println("Strings:" + e.getValue().getList());
                //}
        ));

        return matrix;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 0) {
            return new ArrayList<>();
        }
        List<List<String>> matrix = new ArrayList<>();

        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String strVal = String.valueOf(arr);

            List<String> oneList = strMap.get(strVal);
            if (oneList == null) {
                strMap.put(strVal, new ArrayList<String>() {{add(str);}});
            } else {
                oneList.add(str);
            }
        }

        strMap.forEach((e,v)-> matrix.add(v));
        return matrix;
    }

     public static void main(String[] args) {
         long start, end;
         start = System.currentTimeMillis();
         String[] strArrays = new String[]{"abc", "def", "bca", "cab", "fed", "xy", "yx", "zzxy", "yzzx", "zxyz"};
         List<List<String>> ret = new Problem49().groupAnagrams(strArrays);
         System.out.println("Output:" + ret);
         end = System.currentTimeMillis();
         System.out.println("Run Time:" + (end - start) + " ms");
     }
}
