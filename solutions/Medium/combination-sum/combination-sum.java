class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void sequence(int index, int target, List<Integer> lst, int[] arr) {
        if (target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }
        if (index == arr.length) {
            return;
        }

        if (arr[index] <= target) {
            lst.add(arr[index]);
            sequence(index, target - arr[index], lst, arr);
            lst.remove(lst.size() - 1);
        }

        sequence(index + 1, target, lst, arr);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sequence(0, target, new ArrayList<Integer>(), candidates);
        return res;
    }
}