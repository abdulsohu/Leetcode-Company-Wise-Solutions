/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Idea:
 * 
 * If the target is less than or equals to the first number in sorted array, it
 * must go at the 0th location, and if it's greater than the last number in a
 * sorted array, it must go in the last index + 1, because it's greater. If none
 * of these conditions are met, we must try to look for the target in the array.
 * And finally, if the target is not found within the array, we know now that
 * there must, at the very least, exist a pair of numbers in the array between
 * which the target lies. So if such a pair exists, we say that target goes to
 * the index of the lower number (plus one because it would obviously go after
 * the smaller number as the array is sorted).
 * 
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[n - 1]) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < target && target < nums[i + 1]) {
                index = i + 1;
            }
        }

        return index;
    }
}
