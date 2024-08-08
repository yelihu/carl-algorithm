package org.example.algo.day5_hashtable_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 第454题.四数相加II
 *
 * @author yelihu
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map1.put(
                        i + j,
                        map1.getOrDefault(i + j, 0) + 1
                );
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int key = -(i + j);
                if (map1.containsKey(key)) {
                    count+=map1.get(key);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(new FourSumCount().fourSumCount(nums1, nums2, nums3, nums4));

    }
}
