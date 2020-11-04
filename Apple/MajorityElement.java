
/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Idea:
 * 
 * We know the exact threshold a given number's frequency has to be greater than 
 * to be the answer. Maintain a map from numbers in the array to their frequencies
 * and look for one whose frequency is greater than our threshold `required`.
 * 
 */

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int required = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int answer = 0;
        for (int key : freq.keySet()) {
            if (freq.get(key) > required) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
