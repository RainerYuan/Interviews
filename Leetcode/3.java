class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] table = new Integer[128];
        int len = s.length();
        int right = 0;
        int left = 0;
        int res = 0;

        while (right < len) {
            int r = s.charAt(right);
            Integer currIndex = table[r];
            if (currIndex != null && currIndex >= left && currIndex <= right) {
                left = currIndex + 1;
            }
            res = Math.max(res, right - left + 1);
            table[r] = right;

            right++;
        }

        return res;

    }
}