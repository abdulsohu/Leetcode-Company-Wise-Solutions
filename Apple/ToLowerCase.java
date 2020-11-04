/**
 * https://leetcode.com/problems/to-lower-case/
 * 
 * Idea:
 * 
 * Every character in the alphabet has an ASCII code value, so if you encounter
 * a character that represents the value of a capital character, just scale it
 * down, and map it to the ASCII value of lowercase alphabet.
 * 
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr >= 65 && curr <= 90) {
                curr = (char) (curr - 'A' + 'a');
            }
            sb.append(curr);
        }

        return sb.toString();
    }
}
