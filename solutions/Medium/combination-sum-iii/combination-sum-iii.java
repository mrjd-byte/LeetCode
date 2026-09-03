class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public void sequence(int index, int sum, int k, List<Integer> lst) {
        if (k == 0) {
            if (sum == 0) {
                res.add(new ArrayList<>(lst));
            }
            return;
        }

        if (sum <= 0) {
            return;
        }

        for (int i = index; i < 10; i++) {
            if (i > sum) break;
            lst.add(i);
            sequence(i + 1, sum - i, k - 1, lst);
            lst.remove(lst.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        sequence(1, n, k, new ArrayList<>());
        return res;
    }
}