class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(gas.length==0 || cost.length==0) return 0;
        
        int f=0;
        int r=0;
        int accGas=0;
        
        while(f < gas.length){
             accGas += gas[f] - cost[f];
            if(accGas < 0){
                r = f + 1;
                accGas = 0;
            }
            f++;
        }
        
        f = 0;

        while(f < r){
            accGas += gas[f] - cost[f];
            f++;
        }
        
        if(accGas < 0) return -1; 
        return r;
    }
}