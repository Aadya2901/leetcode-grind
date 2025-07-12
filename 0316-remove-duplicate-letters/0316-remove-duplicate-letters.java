class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];      // frequency of each character
        boolean[] visited = new boolean[26];  // track if char is in result
        StringBuilder sb = new StringBuilder(); // result stack-like behavior

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--; // consume this character once

            if (visited[ch - 'a']) continue;

            // remove last char from result if it's greater than current
            // and it still exists later in the string
            while (sb.length() > 0 && 
                   sb.charAt(sb.length() - 1) > ch &&
                   freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            visited[ch - 'a'] = true;
        }

        return sb.toString();
    }
}
