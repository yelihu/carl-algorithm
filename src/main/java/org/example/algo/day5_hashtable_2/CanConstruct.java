package org.example.algo.day5_hashtable_2;

/**
 * @author yelihu
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for (char ch : magazine.toCharArray()) {
            dict[ch - 'a'] += 1;
        }

        for (char ch : ransomNote.toCharArray()) {
            dict[ch - 'a'] -= 1;
        }
        for (int count : dict) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("aa", "aab"));
        System.out.println(new CanConstruct().canConstruct("aa", "ab"));
        System.out.println(new CanConstruct().canConstruct("aa", "a"));
        System.out.println(new CanConstruct().canConstruct("aa", "aa"));
    }
}
