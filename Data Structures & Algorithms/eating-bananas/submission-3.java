class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        for (int p : piles) {
            r = Math.max(r, p);
        }

        int res = r;

        while (l <= r) {
            int k = l + ((r - l) / 2);

            int total = 0;
            for (int pile : piles) {
                total += Math.ceil((double) pile / k);
            }

            if (total <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
