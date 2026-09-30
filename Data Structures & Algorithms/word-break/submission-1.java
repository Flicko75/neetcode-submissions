class Solution {
    HashMap<Integer, Boolean> dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        dp.put(s.length(), true);
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> words, int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        for (String word : words) {
            if (i + word.length() <= s.length() &&
                s.substring(i, i + word.length()).equals(word)) {
                    if (dfs(s, words, i + word.length())) {
                        dp.put(i, true);
                        return true;
                    }
                }
        }
        dp.put(i, false);
        return false;
    }
}
