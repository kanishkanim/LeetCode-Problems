class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            if (i>0 && arr[i] == arr[i-1]) {
                continue;
            }
            
            for (int j=i+1; j<arr.length; j++) {
                if (j>i+1 && arr[j] == arr[j-1]) {
                    continue;
                }
                
                searchPair(arr, target, i, j, quadruplets);
            }
        }
        
        return quadruplets;
    }
    
    private void searchPair(int[] arr, int target, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;
        
        while(left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                
                 while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }

                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }       
        }
    }
}