package org.ContainsDuplicate;

import java.util.HashMap;

public class ContainsDuplicate {

  /**
   * Given an integer array nums, return true if any value appears at least twice in the array, and
   * return false if every element is distinct.
   *
   *  nums the input array of integers
   *  true if there are duplicates, false otherwise
   *     <p>You should aim for a solution with O(n) time and O(n) space, where n is the size of the
   *     input array.
   *     <p>Hint 1 A brute force solution would be to check every element against every other
   *     element in the array. This would be an O(n^2) solution. Can you think of a better way?
   */
  public static void main(String[] args) {
    ContainsDuplicate containsDuplicate = new ContainsDuplicate();
    int[] nums = {1, 2, 3, 4, 5, 1};
    boolean result = containsDuplicate.hasDuplicate(nums);
    System.out.println("Contains duplicate: " + result); // Should print true
  }

  public boolean hasDuplicate(int[] nums) {
    HashMap<Integer, Integer> list = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      list.put(nums[i], list.getOrDefault(nums[i], 0) + 1);
      if (list.containsKey(nums[i + 1])) {
        return true;
      }
    }
    return false;
  }
}
