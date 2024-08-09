package org.example.algo.day8_string_1;

/**
 * @author yelihu
 */
public class ReverseStr2 {
    /**
     * reverse字符串
     * 1 <= s.length <= 104
     * s 仅由小写英文组成
     * 1 <= k <= 104
     *
     * @param s
     * @param k
     * @return {@link String}
     */
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < charArray.length; i += 2 * k) {
            slow = i;
            fast = i + k - 1;
            if (fast >= charArray.length) {
                fast = charArray.length - 1;
            }
            while (slow < fast && fast < charArray.length) {
                //swap
                charArray[fast] ^= charArray[slow];
                charArray[slow] ^= charArray[fast];
                charArray[fast] ^= charArray[slow];
                fast--;
                slow++;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        ReverseStr2 reverseStr2 = new ReverseStr2();
        //System.out.println(reverseStr2.reverseStr("abcdefg", 2));
        //System.out.println(reverseStr2.reverseStr("abcd", 2));
        System.out.println(reverseStr2.reverseStr("abcdefg", 8));
    }
}
