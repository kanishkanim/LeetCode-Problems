class Solution {
	
	public int kthSmallest (int[][] matrix, int k) {
	
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int n = matrix.length;
		int min = matrix[0][0];
		int max = matrix[n - 1][n - 1];
        
		while (min < max) {
			int mid = min + (max - min) / 2;
			int count = 0;
			int r = n - 1;
            
			for (int i = 0; i < n; i++) {
				while (r >= 0 && matrix[i][r] > mid) {
					--r;
				}
				count += r + 1;
			}
            
			if (count >= k) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		
		return min;
	}
}