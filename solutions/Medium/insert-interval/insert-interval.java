class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while (i < n && intervals[i][0] > newInterval[1]) {
            ans.add(intervals[i]);
            i++;
        }
        int[][] result = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            result[j] = ans.get(j);
        }
        return result;
    }
}