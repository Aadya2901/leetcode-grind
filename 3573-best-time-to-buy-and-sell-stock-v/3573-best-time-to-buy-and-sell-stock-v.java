class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[] prev = new long[n];
        long[] curr = new long[n];

        for (int t = 1; t <= k; t++) {
            long bestBuy = -prices[0];     // dp[t-1][0] - prices[0]
            long bestSell = prices[0];     // dp[t-1][0] + prices[0]

            for (int i = 1; i < n; i++) {
                curr[i] = Math.max(
                    curr[i - 1],
                    Math.max(
                        prices[i] + bestBuy,
                        -prices[i] + bestSell
                    )
                );

                bestBuy = Math.max(bestBuy, prev[i - 1] - prices[i]);
                bestSell = Math.max(bestSell, prev[i - 1] + prices[i]);
            }

            // move curr → prev
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1];
    }
}
