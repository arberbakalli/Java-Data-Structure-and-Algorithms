package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MultipleSolutions {

  public class BruteForceSolution {
    public boolean hasDuplicate(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] == nums[j]) {
            return true;
          }
        }
      }
      return false;
    }
  }

  /** Time & Space Complexity Time complexity:O(n^2) Space complexity:O(1) */
  public class SortingSolution {
    public boolean hasDuplicate(int[] nums) {
      Arrays.sort(nums);
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i - 1]) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Time & Space Complexity Time complexity:O (n log n) Space complexity:O(1) or O(n) depending on
   * the sorting algorithm used
   */
  public class HashSetSolution {
    public boolean hasDuplicate(int[] nums) {
      Set<Integer> seen = new HashSet<>();
      for (int num : nums) {
        if (seen.contains(num)) {
          return true;
        }
        seen.add(num);
      }
      return false;
    }
  }

  /** Time & Space Complexity Time complexity:O(n) Space complexity:O(n) */
  public class HashSetLengthSolution {
    public boolean hasDuplicate(int[] nums) {
      return Arrays.stream(nums).distinct().count() < nums.length;
    }
  }
  /** Time & Space Complexity Time complexity:O(n) Space complexity:O(n) */
}
