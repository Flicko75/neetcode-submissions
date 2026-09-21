class Solution {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > half)
                return n;
        }

        return -1;
    }
}