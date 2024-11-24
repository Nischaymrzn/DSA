package Leetcode;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

import java.util.HashMap;

// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

public class TwoSum_1 {
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        TwoSum_1 s=new TwoSum_1();
        int[] nums={1,2,3,4,5};
        int[] arr=s.twoSum(nums, 9);
        System.out.println(arr[0] + "," + arr[1]);
    }
}