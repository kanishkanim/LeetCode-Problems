class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n];
        
        rightMin[n - 1] = arr[n - 1];
        
        for(int i = n - 2; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        
        //counting chunks
        int count = 1;
        int leftMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < n - 1; i++){
            leftMax = Math.max(leftMax, arr[i]);
            
            if(leftMax <= rightMin[i + 1]){
                count++;
            }
        }
        return count;
    }
}