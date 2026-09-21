class Solution {

    private Map<Character, String> map = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(digits, 0, new StringBuilder());

        return res;
    }

    private void dfs(String digits, int index, StringBuilder current) {
        if (index >= digits.length()) {
            res.add(current.toString());
            return;
        }

        String choice = map.get(digits.charAt(index));

        for (char c : choice.toCharArray()) {
            current.append(c);
            dfs(digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
