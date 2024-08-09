package org.example.algo.day8_string_1;

/**
 * @author yelihu
 */
public class Reverse {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            //使用位运算的方式交换数值，“^=”表示“异或”，即a^=b表示a=a^b
            //举个例子s[left] = 1，s[right] = 2
            // 则s[left] = 1^2 = 3
            s[left] ^= s[right];
            // 则s[right] = 3^2 = 1
            s[right] ^= s[left];
            // 则s[left] = 3^1 = 2
            s[left] ^= s[right];

            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverse.reverseString(s);
        System.out.println(s);
    }

}
