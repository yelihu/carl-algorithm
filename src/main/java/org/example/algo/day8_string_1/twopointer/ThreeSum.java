package org.example.algo.day8_string_1.twopointer;

import java.util.*;

/**
 * @author yelihu
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 剪枝, 如果当前数大于0，则后续数都大于0，不可能找到和为0的数
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);

        List<List<Integer>> lists2 = threeSum.threeSum(nums2);
        System.out.println(lists2);


        List<List<Integer>> lists3 = threeSum.threeSum(nums3);
        System.out.println(lists3);
    }
}
