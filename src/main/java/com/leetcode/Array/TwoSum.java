package com.leetcode.Array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
 * 你可以按任意顺序返回答案
 * @author guozx
 */
@Slf4j
public class TwoSum {
    
    /**
     * 解法一：暴力法
     * 时间复杂度 O(n^2)
     * 先确定一个数，然后去和后面的数一个个相加，看看和是不是target，需要双层循环
     * 执行用时：65 ms
     * 内存消耗：41.3 MB
     * 耗时太久了，不可取
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 解法二：哈希表法
     * 时间复杂度O(n)
     * 使用map，遍历的时候使用target减去当前的数，找找map中有没有差
     * 有的话就是找到了两个数，没有的话就把值作为key，下标作为value存进map中
     * 这样就能一次循环就完成了。
     * 执行用时：1 ms，在所有Java提交中击败了 99.34% 的用户
     * 内存消耗：41.3 MB，在所有Java提交中击败了 77.82% 的用户
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            Integer index = map.get(target - num);
            if (index != null) {
                return new int[] {index, i};
            }
            map.put(num, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
     * 另一种写法
     * containsKey方法：判断是否包含指定的键名
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        // 输入：nums = [2,7,11,15], target = 9
        // 输出：[0,1]
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        log.info(Arrays.toString(twoSum(nums, 9)));
        log.info(Arrays.toString(twoSum2(nums, 9)));
        log.info(Arrays.toString(twoSum3(nums, 9)));

        // 输入：nums = [3,2,4], target = 6
        // 输出：[1,2]
        int[] nums2 = new int[3];
        nums2[0] = 3;
        nums2[1] = 2;
        nums2[2] = 4;
        log.info(Arrays.toString(twoSum(nums2, 6)));
        log.info(Arrays.toString(twoSum2(nums2, 6)));
        log.info(Arrays.toString(twoSum3(nums2, 6)));

        // 输入：nums = [3,3], target = 6
        // 输出：[0,1]
        int[] nums3 = new int[2];
        nums3[0] = 3;
        nums3[1] = 3;
        log.info(Arrays.toString(twoSum(nums3, 6)));
        log.info(Arrays.toString(twoSum2(nums3, 6)));
        log.info(Arrays.toString(twoSum3(nums3, 6)));
    }
}
