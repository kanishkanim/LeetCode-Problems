class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        int[] prevRow = new int[N];
        int ans = 0;
        
        for (int i = 0; i < M; i++) {
            int[] curRow = new int[N];
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '1'){
                    curRow[j] = 1 + prevRow[j];
                }
            }
            prevRow = curRow;
            ans = Math.max(ans, largestRectangleArea(curRow));
        }          
        return ans;
    }
    
	// Leetcode problem 84
    public int largestRectangleArea(int[] heights) {
        // heights[right[i]] is the first element < heights[i] to right
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        
        // heights[left[i]] is the first element < height[i] to left
        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >=0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
        
            if (!stack.isEmpty())
                right[i] = stack.peek();
            
            stack.push(i);
        }
        
        stack.clear();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            
            if (!stack.isEmpty())
                left[i] = stack.peek();
            
            stack.push(i);
        }
        
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftLen = i - left[i];
            int rightLen = right[i] - i;
            int area = heights[i] * (leftLen + rightLen - 1);
            max = Math.max(max, area);
        }        
        return max;    
    }
}