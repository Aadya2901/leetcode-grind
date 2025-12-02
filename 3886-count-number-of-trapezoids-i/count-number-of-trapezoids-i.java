import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> countY = new HashMap<>();

        // Count points per y-line
        for (int[] p : points) {
            countY.put(p[1], countY.getOrDefault(p[1], 0L) + 1);
        }

        long sum = 0;       // sum of all C(cnt,2)
        long sumSq = 0;     // sum of squares of C(cnt,2)

        for (long cnt : countY.values()) {
            if (cnt >= 2) {
                long v = cnt * (cnt - 1) / 2;   // C(cnt,2)

                v %= MOD;

                sum = (sum + v) % MOD;
                sumSq = (sumSq + (v * v) % MOD) % MOD;
            }
        }

        // Using formula: (sum^2 - sumSq) / 2
        long ans = ( (sum * sum) % MOD - sumSq + MOD ) % MOD;

        // multiply by inverse of 2 mod MOD
        long inv2 = (MOD + 1) / 2; // since MOD is prime
        ans = (ans * inv2) % MOD;

        return (int) ans;
    }
}
