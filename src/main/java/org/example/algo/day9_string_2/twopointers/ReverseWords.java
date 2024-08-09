package org.example.algo.day9_string_2.twopointers;

/**
 * @author yelihu
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (charArray[left] == ' ') {
            left++;
        }
        while (charArray[right] == ' ') {
            right--;
        }

        //这里使用builder重新去创建一个字符串
        StringBuilder builder = new StringBuilder();
        while (left <= right) {
            if (charArray[left] != ' ' || builder.charAt(builder.length() - 1) != ' ') {
                builder.append(charArray[left]);
            }
            left++;
        }

        //reverse
        char[] trim = builder.toString().toCharArray();
        left = 0;
        right = trim.length - 1;
        while (left < right) {
            trim[left] ^= trim[right];
            trim[right] ^= trim[left];
            trim[left] ^= trim[right];
            left++;
            right--;
        }

        //reverse single word
        left = 0;
        right = 0;
        while (right < trim.length) {
            while (right < trim.length && trim[right] != ' ') {
                right++;
            }
            int next = right + 1;

            int tmp = right - 1;
            while (left < tmp) {
                trim[left] ^= trim[tmp];
                trim[tmp] ^= trim[left];
                trim[left] ^= trim[tmp];
                left++;
                tmp--;
            }
            left = next;
            right = next;
        }
        return new String(trim);
    }


    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        //System.out.println(reverseWords.reverseWords("the sky is blue"));
        //System.out.println(reverseWords.reverseWords("  hello world  "));
        //System.out.println(reverseWords.reverseWords("a good   example"));
        System.out.println(reverseWords.reverseWords("  Bob    Loves  Alice   "));
    }
}
