// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

class Solution {
    public List<Integer> findAnagrams(String s1, String p) {
        ArrayList<Integer> Res = new ArrayList<Integer>();
        int[] hash = new int[26];
        int[] phash = new int[26];

        int window = p.length();
        int len = s1.length();

        if(len<window){
            return Res;
        }
        int left = 0, right = 0;
        while(right<window){
            phash[(p.charAt(right)-'a')]++;
            hash[(s1.charAt(right)-'a')]++;
            right++;
        }
        right--;
        while(right<len){
            if(Arrays.equals(hash,phash)) Res.add(left);
            right++;
            if(right!=len) hash[s1.charAt(right)-'a']++;
            hash[s1.charAt(left)-'a']--;
            left+=1;
        }
        return Res;
    }
}
