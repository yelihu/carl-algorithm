package org.example.algo.day4_hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yelihu
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] ints = new int[2];
                ints[0] = i;
                ints[1] = map.get(target - nums[i]);
                return ints;
            }
            //保存数值和下标，记录之前出现过这个值
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
