class Solution {
    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ways = dfs(s, i + 1);
        
        if (i + 1 < s.length()) {
            int number = Integer.parseInt(s.substring(i, i + 2));
            
            if (number >= 10 && number <= 26) {
                ways += dfs(s, i + 2);
            }
        }

        dp[i] = ways;

        return ways;
    }
}
