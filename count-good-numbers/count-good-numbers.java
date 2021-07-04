class Solution {
    int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n % 2 == 0) ? n/2 : (n/2)+1;
        long ans = (pow(5 , even) *  pow(4 , odd)) % MOD;
        return (int) ans;
    }
    public long pow(long x, long n) {
        long ans = 1;
        for(long i = 0 ; i < 64 ; i++) {
            long prev = x;
            if((n & (1l << i)) != 0) {
                for(int j = 1 ; j <= i ; j++) {
                    prev = (prev * prev) % MOD;
                }
                ans = (ans * prev) % MOD;
            }   
        }
        return ans;
    }
}