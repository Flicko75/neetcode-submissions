class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        if (x == 0){
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sqr = (long) mid * mid;

            if (sqr == x){
                return mid;
            }
            else if (sqr > x){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return right;
    }
}