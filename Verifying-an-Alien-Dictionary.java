//In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

//Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

 

//Example 1:

//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

class Solution {
    int[] alien = new int[26];                                          //creating and mapping digit from 0-25 for a-z in alien library
    public boolean isAlienSorted(String[] words, String order) {
       for(int i=0;i<order.length();i++){
           alien[order.charAt(i)-'a']=i;
       }
       for(int i=1;i<words.length;i++){
           if(!compare(words[i],words[i-1])) return false;              //compare each word with element behind it
       }
       return true;
    }
    public boolean compare(String s1, String s2){
        int j=0;
        while(j<s1.length() && j<s2.length()){
            if(s1.charAt(j) == s2.charAt(j)) j++;                        //if first alphabets are equal then go for next and so on
            else if(alien[s1.charAt(j)-'a']>alien[s2.charAt(j)-'a']) return true;   //if first words element is greater than secome words element then return true
            else return false;                                           //else false
        }
        if(s1.length()<s2.length()) return false;
        return true;
    }
}
