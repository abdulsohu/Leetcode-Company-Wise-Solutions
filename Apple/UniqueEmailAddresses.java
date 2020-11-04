
/**
 * https://leetcode.com/problems/unique-email-addresses/
 * 
 * Idea:
 * 
 * Add everything before the '@' to a stringbuilder, except the periods ('.').
 * Then, find where the '+' exists in the stringbuilder and remove the substring
 * starting at that point. Finally, append the portion from email address
 * starting at '@'.
 * 
 */
import java.util.*;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> real = new HashSet<>();

        for (String email : emails) {
            real.add(realize(email));
        }

        return real.size();
    }

    public String realize(String email) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (email.charAt(i) != '@') {
            if (email.charAt(i) != '.') {
                sb.append(email.charAt(i));
            }

            i++;
        } // Now you know i = index of '@'

        int j = 0;
        while (j < sb.length()) {
            if (sb.charAt(j) == '+') {
                break;
            }
            j++;
        } // Now you know j = index of '+'

        sb.delete(j, sb.length());
        sb.append(email.substring(i));
        return sb.toString();
    }
}
