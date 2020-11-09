
/**
 * https://leetcode.com/problems/friend-circles/
 * 
 * Idea:
 * 
 * Depth-first traversal of the graph to find nodes, 
 * and add them to visited so that they are not visited again.
 */
import java.util.*;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int friendGroups = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (!visited.contains(i)) {
                friendGroups++;
                visited.add(i);
                dfs(visited, M[i], M);
            }
        }

        return friendGroups;
    }

    public void dfs(Set<Integer> visited, int[] neighbors, int[][] M) {
        for (int i = 0; i < neighbors.length; i++) {
            if (!visited.contains(i) && neighbors[i] == 1) {
                visited.add(i);
                dfs(visited, M[i], M);
            }
        }
    }
}
