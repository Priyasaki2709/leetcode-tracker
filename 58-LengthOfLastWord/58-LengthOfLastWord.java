// Last updated: 7/9/2026, 10:07:40 AM
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int len = 0;

        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }

        return len;
    }
}