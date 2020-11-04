/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Idea:
 * 
 * Two videos that explain the KMP algorithm really well:
 * 
 * 1) https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * 
 * 2) https://www.youtube.com/watch?v=KG44VoDtsAA
 * 
 * Following video provides a neat implementation that goes hand in hand with
 * the explanations above:
 * 
 * https://www.youtube.com/watch?v=EL4ZbRF587g
 * 
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int[] lsp = computeLspTable(needle);
        int hayPointer = 0;
        int needlePointer = 0;

        while (hayPointer < haystack.length()) {
            if (haystack.charAt(hayPointer) == needle.charAt(needlePointer)) {
                hayPointer++;
                needlePointer++;

                if (needlePointer == needle.length()) {
                    return (hayPointer - needlePointer);
                }
            } else {
                needlePointer = lsp[needlePointer];
                if (needlePointer < 0) {
                    needlePointer++;
                    hayPointer++;
                }
            }
        }

        return -1;
    }

    public static int[] computeLspTable(String needle) {
        int n = needle.length();
        int[] arr = new int[n + 1];

        arr[0] = -1;
        arr[1] = 0;

        int i = 1;
        int j = 0;

        while (i < n) {
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
                i++;
                arr[i] = j;
            } else if (j > 0) {
                j = arr[j];
            } else {
                i++;
                arr[i] = 0;
            }
        }

        return arr;
    }
}
