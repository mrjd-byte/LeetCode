class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void sequence(int index, List<Integer> lst, int[] arr) {
        res.add(new ArrayList<>(lst));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            lst.add(arr[i]);
            sequence(i + 1, lst, arr);
            lst.remove(lst.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        sequence(0, new ArrayList<Integer>(), nums);
        return res;
    }
}