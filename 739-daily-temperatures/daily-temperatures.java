class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];
        
        Stack<Integer> st = new Stack<>(); 
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temps[i] > temps[st.peek()]) {
                int prevIndex = st.pop();
                ans[prevIndex] = i - prevIndex;
            }
            
            st.push(i);
        }
        
        return ans;
    }
}