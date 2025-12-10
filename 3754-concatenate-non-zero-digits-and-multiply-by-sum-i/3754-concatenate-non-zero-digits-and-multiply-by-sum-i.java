class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;

        // Extract digits of n from left to right
        String s = String.valueOf(n);

        for (char c : s.toCharArray()) {
            if (c != '0') {
                int digit = c - '0';
                x = x * 10 + digit;
                sum += digit;
            }
        }

        return x * sum;
    }
}
