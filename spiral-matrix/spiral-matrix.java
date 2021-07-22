class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        
        //column
        int left = 0;
        int right = matrix[0].length - 1;
        
        //row
        int top = 0;
        int bottom = matrix.length - 1;
        
        int dir = 0;
        
        while(left <= right && top <= bottom){
            //left to right
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    list.add(matrix[top][i]);
                }   
                top++;
            }
            
            //top to bottom
            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    list.add(matrix[i][right]); 
                }   
                right--;
            }
            
            //right to left
            if(dir == 2){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]); 
                }   
                bottom--;
            }
            
            //bottom to up
            if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }   
                left++;
            }
            
            //direction change 
            dir = (dir + 1) % 4;
        }
        return list;
    }
}