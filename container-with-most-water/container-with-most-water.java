class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int maxWater = 0;
            
        while(i < j){
            
            int l = j - i;
            int h = Math.min(height[i], height[j]);
            int water = l * h;
            
            maxWater = Math.max(water, maxWater);
            
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
            
        }
        
        return maxWater;
    }
}