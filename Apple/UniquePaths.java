/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * Idea: check out the in-code comments below.
 * 
 * Very good explanation video here: https://www.youtube.com/watch?v=6qMFjFC9YSc
 * 
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        /**
         * Because we can only go down or right the only way to reach cells in the first
         * column is to go continously down from start.
         */
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        /**
         * Because we can only go down or right the only way to reach cells in the first
         * row is to go continously right from start.
         */
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        /**
         * First row and first column are filled so now we fill from second row and
         * second column onwards. Note that to fill any such cell `i`, all we need to do
         * is to ask where we could have come from and the answer to that would be from
         * left: dp[row][col - 1] or from above: dp[row - 1][col]. The unique paths of
         * reaching that cell would then be the sum of both the aforesaid.
         */
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
            }
        }

        return dp[m - 1][n - 1];
    }
}
