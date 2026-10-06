class Solution {

    int[] parent;
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[py] = px;
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        HashMap<String, Integer> emailOwner = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (emailOwner.containsKey(email)) {
                    union(i, emailOwner.get(email));
                } else {

                    emailOwner.put(email, i);

                }
            }
        }
        HashMap<Integer, ArrayList<String>> merged = new HashMap<>();

        for (String email : emailOwner.keySet()) {

            int account = find(emailOwner.get(email));

            merged.putIfAbsent(account, new ArrayList<>());

            merged.get(account).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int account : merged.keySet()) {

            ArrayList<String> emails = merged.get(account);

            Collections.sort(emails);

            ArrayList<String> temp = new ArrayList<>();

            temp.add(accounts.get(account).get(0));
            temp.addAll(emails);

            ans.add(temp);
        }


        return ans;
    }
}