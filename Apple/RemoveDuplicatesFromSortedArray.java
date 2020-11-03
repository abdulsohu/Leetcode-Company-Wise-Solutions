/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Idea:
 * 
 * `curr` stands whichever number's duplicates we're trying to bypass.
 * 
 * `pointer` moves until it finds a non-duplicate with respect to nums[curr].
 * 
 * When you see a new number, you let `curr` know that the spot right next to it
 * is going to have that new number (curr++), and we're obviously going to
 * extend the length for this new number (length++), and finally, bring over the
 * new number to curr because of the (curr++).
 * 
 */
class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int curr = 0;
        int pointer = 0;
        int length = 1;

        while (pointer < n) {
            if (nums[pointer] == nums[curr]) {
                pointer++;
            } else {
                curr++;
                length++;
                nums[curr] = nums[pointer];
            }
        }

        return length;
    }
}