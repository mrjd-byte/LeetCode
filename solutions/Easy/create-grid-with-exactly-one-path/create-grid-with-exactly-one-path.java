class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
   
        for (int i = 0; i < m; i++) {
            String row = "";
            
            for (int j = 0; j < n; j++) {
                if (i == m - 1 || j == 0) {
                    row += ".";
                } else {
                    row += "#";
                }
            }
            res[i] = row;
        }
        return res;
    }
}
