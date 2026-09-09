class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                map.put(nums2[i], -1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            list.add(map.get(num));
        }
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}