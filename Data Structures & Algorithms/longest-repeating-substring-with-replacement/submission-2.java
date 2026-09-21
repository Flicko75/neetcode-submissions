// class Solution {
//     public int characterReplacement(String s, int k) {
//         Map<Character, Integer> count = new HashMap<>();
//         int res = 0;

//         int l = 0, maxf = 0;

//         for (int r=0; r<s.length(); r++){
//             count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

//             maxf = Math.max(maxf, count.get(s.charAt(r)));

//             while ((r - l + 1) - maxf > k){
//                 count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
//                 l++;
//             }
//             res = Math.max(res, (r - l + 1));
//         }
//         return res;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

            int currMaxf = 0;
            for (int freq : count.values()) {
                currMaxf = Math.max(currMaxf, freq);
            }

            while ((r - l + 1) - currMaxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;

                currMaxf = 0;
                for (int freq : count.values()) {
                    currMaxf = Math.max(currMaxf, freq);
                }
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}

