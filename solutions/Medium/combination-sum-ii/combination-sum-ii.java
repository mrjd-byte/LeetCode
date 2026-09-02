class Solution {
    List<List<Integer>> res = new ArrayList<>();
    private void sequence(int index, int target, List<Integer> lst, int[] arr) {
        if (target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }
        if (index == arr.length) {
            return;
        }

        for(int i = index; i<arr.length; i++){
            if(arr[i] > target) break;
            if(i > index && arr[i] == arr[i-1]) continue;

            lst.add(arr[i]);
            sequence(i+1, target - arr[i], lst, arr);
            lst.remove(lst.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sequence(0, target, new ArrayList<Integer>(), candidates);
        return res;
    }
}