package org.example.algo.day10_stack_queue_1;

import java.util.Queue;
import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 *
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * @author yelihu
 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.isEmpty()) {
                stack.push(charArray[i]);
                continue;
            }
            Character top = stack.peek();
            if (charArray[i] == top) {
                stack.pop();
            }else {
                stack.push(charArray[i]);
            }

        }
        StringBuilder b = new StringBuilder();
        while (!stack.isEmpty()) {
            b.append(stack.pop());
        }
        b.reverse();
        return b.toString();
    }


    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates("abbaca"));
        System.out.println(removeDuplicates.removeDuplicates("a"));
    }
}
