package org.TwoSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

record edgeCase(Integer a, Integer b) {}

public class TwoSumSolution {
  edgeCase edgeCaseOne = new edgeCase(2, 1000);
  edgeCase edgeCaseTwo = new edgeCase(-10000000, 10000000);

  public static void main(String[] args) {

    int[] testCaseOne = {3, 4, 5, 6};
    int targetOne = 7;
    System.out.println(
        "Pass - Test Case One: "
            + Arrays.toString(new TwoSumSolution().twoSum(testCaseOne, targetOne)));

    int[] testCaseTwo = {4, 5, 6};
    int targetTwo = 10;

    System.out.println(
        "Pass - Test Case Two: "
            + Arrays.toString(new TwoSumSolution().twoSum(testCaseTwo, targetTwo)));
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> prevMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i]; // [ 2, 5 , 4 , 1 , 3 , 6] target 5
      int diff = target - num; // 5 - 2 = 3

      if (prevMap.containsKey(diff)) { // is there a 3, no... move on
        return new int[] {prevMap.get(diff), i};
      }

      prevMap.put(
          num,
          i); // put 2 at index 0, 5 at index 1, 4 at index 2, 1 at index 3 then the solution is at
      // 4 + 1
    }

    return new int[] {}; // return empty in case there is no solution
  }

  public int[] twoSumChatGPT(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }

    throw new IllegalArgumentException("No two sum solution");
  }

  public int[] twoSumSorting(int[] nums, int target) {
    int[][] A = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      A[i][0] = nums[i];
      A[i][1] = i;
    }

    Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

    int i = 0, j = nums.length - 1;
    while (i < j) {
      int cur = A[i][0] + A[j][0];
      if (cur == target) {
        return new int[] {Math.min(A[i][1], A[j][1]), Math.max(A[i][1], A[j][1])};
      } else if (cur < target) {
        i++;
      } else {
        j--;
      }
    }
    return new int[0];
  }

  public int[] twoSumBruteForce(int[] nums, int target) {
    int[] solution = new int[2];

    // constraint here first code checkers
    if (edgeCaseOne.a() < 2 && edgeCaseOne.b() > 10000) {
      return solution;
    }
    if (target < edgeCaseTwo.a() && target > edgeCaseTwo.b()) {
      return solution;
    }
    //  arbers way brute force first attempt
    // [2,7,11,15]

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < edgeCaseTwo.a() && nums[i] > edgeCaseTwo.b()) {
        return solution;
      }

      if (i == (nums.length - 1)) {
        return solution;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if ((nums[i] + nums[j]) == target) {
          solution[0] = i;
          solution[1] = j;
          return solution;
        }
      }
    }
    return solution;
  }
}
