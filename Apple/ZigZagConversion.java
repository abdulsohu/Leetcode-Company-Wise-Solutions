
/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * Idea:
 * 
 * Simply add characters to list as if you were traversing the string in a 
 * zig zag manner.
 * 
 * An explanation video here: https://www.youtube.com/watch?v=-fFDzIWebA4
 * 
 */
import java.util.*;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // Initialize each row
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        // Iterate
        boolean goingDown = false;
        int row = 0;

        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));

            if (row == numRows - 1 || row == 0) {
                goingDown = !goingDown;
            }

            row += (goingDown) ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder part : list) {
            sb.append(part);
        }

        return sb.toString();
    }
}
