package org.example.algo.day_6_string_two_pointer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yelihu
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            //正数，并且还比target大，后面都是比target大的数字了，不需要继续
            if (nums[k] > 0 && nums[k] > target) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1; i < nums.length; i++) {
                //已经加和的两位数已经比target大，并且是正数，并且target也是正数，不需要继续
                if (nums[k] + nums[i] > target
                        && nums[k] + nums[i] > 0 && target > 0) {
                    break;
                }
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[left] + nums[right] + nums[k] + nums[i];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(new FourSum().fourSum(nums, 8));
    }
}
