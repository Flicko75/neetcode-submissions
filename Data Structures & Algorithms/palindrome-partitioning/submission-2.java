class Solution {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());

        return res;        
    }

    private void dfs(int idx, String s, List<String> curr) {
        if (idx >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=idx; i<s.length(); i++) {
            if (isPal(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                dfs(i + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
