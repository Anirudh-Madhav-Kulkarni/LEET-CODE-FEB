// You are given an array of strings ideas that represents a list of names to be used in the process of naming a company. The process of naming a company is as follows:

// Choose 2 distinct names from ideas, call them ideaA and ideaB.
// Swap the first letters of ideaA and ideaB with each other.
// If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
// Otherwise, it is not a valid name.
// Return the number of distinct valid names for the company.


class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] sets = new Set[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet();
        }
        for (String s : ideas) {
            sets[s.charAt(0) - 'a'].add(s.substring(1));
        }
        int[][] same = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (String s : sets[i]) {
                for (int j = i + 1; j < 26; j++) {
                    if (sets[j].contains(s)) {
                        same[i][j]++;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                res += (sets[i].size() - same[i][j]) * (sets[j].size() - same[i][j]) * 2;
            }
        }
        return res;
    }
}
