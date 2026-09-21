class Solution {
    public int maxProfit(int[] prices) {
        int L = 0;
        int R = 1;
        int max = 0;

        while (R < prices.length){
            if (prices[R] > prices[L]){
                int profit = prices[R] - prices[L];
                max = Math.max(profit, max);
            }
            else {
                L = R;
            }
            R++;
        }

        return max;
    }
}
