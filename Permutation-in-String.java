// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

 

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int x = s1.length() , y = s2.length();
        if(x>y || y == 0) return false;           // if input string length is greater than main string then it cant be a substring 
        if(x == 0) return true;                   //if given string length is 0 then it is obviously a  substring of main string

        int[] arr1 = new int[26];                 //creating Array [hashmaps]  so that we can use sliding window
        int[] arr2 = new int[26];                 

        for(int i=0;i<x;i++){
            arr1[s1.charAt(i)-'a']++;             // incrementing arr[indexes] of input string character 
            arr2[s2.charAt(i)-'a']++;             // incrementing arr[indexes] of main string character
        }

        for(int i=x;i<y;i++){                     //sliding window of length of x;
            if(Arrays.equals(arr1,arr2)) return true; //if array1 and array 2 are equal that means substring is presen
            arr2[s2.charAt(i-x) - 'a']--;         //if not then increment the window +1 element
            arr2[s2.charAt(i)-'a']++;               
        }
        if(Arrays.equals(arr1,arr2)) return true;   //if substring is present in the last return true
        else return false;
    }
}
