class Solution {
    public int addRungs(int[] rungs, int dist) {
      int count = (rungs[0] - 1) / dist;
        for (int i = 1; i < rungs.length; i++) {
            if(rungs[i]-rungs[i-1] > dist){
                count += (rungs[i] - rungs[i - 1] - 1) / dist;  
            }
        }
        return count;
    }
}