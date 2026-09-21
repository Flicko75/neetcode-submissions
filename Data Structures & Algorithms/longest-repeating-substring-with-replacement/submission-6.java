class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int res = 0;

        for (; r < s.length(); r++) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            maxFreq = Math.max(maxFreq, freq.get(s.charAt(r)));

            while ((r - l + 1) - maxFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
