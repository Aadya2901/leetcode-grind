class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length,count=0;
          for (int i = 0; i < n; i++) {
            if (nums[i] % 3 == 1 || nums[i] % 3 == 2)
                count++;
        }
        return count;
    }
}