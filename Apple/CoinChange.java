/**
 * https://leetcode.com/problems/coin-change/
 * 
 * Idea: Check out the main comment in the code.
 * 
 * Good video explanation here:
 * https://www.youtube.com/watch?v=1R0_7HqNaW0&ab_channel=KevinNaughtonJr.
 * 
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        // Assume it's impossible to make the amount up
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        
        // Need only 0 coins to make up amount = 0
        dp[0] = 0;
        
        /**
        * For each amount, going up until the amount we need,
        * cent by cent, so, 0 -> 1 -> 2 -> 3-> amount, the best
        * or fewest number of coins needed will be as follows:
        *
        * For an amount `i`, we obviously need to pick a coin with value 
        * less than the  `i`. In doing so, we now know that all the
        * coins we will ever look at are the ones <= `i`th amount.
        * 
        * For any coin less than the `i`th amount, there are two choices:
        *
        * 1) Either we don't use that coin because doing so wouldn't
        * be optimal. In this case, we will continue to stick to whatever
        * is in dp[i].
        * 
        * 2) Or, we use that coin. In this case, we're using 1 coin +
        * the best solution of whatever the value of that coin is subtracted
        * from the `i`th amount.
        *
        */
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        
        return (dp[amount] < amount + 1) ? dp[amount] : -1;
    }
}
