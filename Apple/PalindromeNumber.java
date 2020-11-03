/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Idea:
 * 
 * If you create a number where it's rightmost digit is the unit digit of `x`,
 * and its second digit from the right is the tens digit from `x` and so on,
 * what you'll find is that if `x` is truly a palindrome, it must equals this
 * new number you're creating. Also, note that this new number you are creating
 * is the reverse of `x`.
 * 
 * Conversion to long is necessary because we could run into an overflow issue
 * while reversing `x`.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long copyOfX = x;
        int remainder = 0;

        while (x != 0) {
            remainder = x % 10;
            reversed = reversed * 10 + remainder;
            x /= 10;
        }

        return (reversed == copyOfX);
    }
}
