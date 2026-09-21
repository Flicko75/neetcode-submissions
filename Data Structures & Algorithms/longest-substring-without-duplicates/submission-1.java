class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            int count = 0;

            for (int j=i; j<s.length(); j++){
                char c = s.charAt(j);

                if (set.contains(c)){
                    break;
                }

                set.add(c);
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
