class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());

        return res;
    }

    private void dfs(int n, int open, int close, StringBuilder stack) {
        if (stack.length() == 2*n) {
            res.add(stack.toString());
            return;
        }

        if (open < n) {
            stack.append('(');
            dfs(n, open + 1, close, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (close < open) {
            stack.append(')');
            dfs(n, open, close + 1, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
