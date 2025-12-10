class Solution {
    public int countElements(int[] nums, int k) {
        // Count frequencies of each value
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Sort the keys
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int currentGreaterValues = 0;  // how many are strictly greater
        int n = nums.length;

        // We need to count elements x that have at least k greater numbers
        // So we traverse from the largest downward.

        // Compute suffix sums (count elements greater than each key)
        Map<Integer, Integer> greaterCount = new HashMap<>();
        int suffix = 0;

        // traverse keys in descending order
        for (int i = keys.size() - 1; i >= 0; i--) {
            int key = keys.get(i);
            greaterCount.put(key, suffix);   // numbers strictly greater than this key
            suffix += freq.get(key);
        }

        int count = 0;
        for (int x : nums) {
            if (greaterCount.get(x) >= k) {
                count++;
            }
        }

        return count;
    }
}
