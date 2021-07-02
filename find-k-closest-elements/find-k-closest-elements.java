class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr,x);

        int leftBound = index - k - 1;
        int rightBound = index + k - 1;

        while(leftBound < 0){
            leftBound++;
        }

        while(rightBound > arr.length-1){
            rightBound--;
        }

        List<Integer> result = new ArrayList<>();
        while(rightBound - leftBound + 1 > k){
            if(Math.abs(x-arr[leftBound]) <= Math.abs(x-arr[rightBound])){
                rightBound--;
            }else{
                leftBound++;
            }
        }

        for(int i = leftBound; i <= rightBound; i++){
            result.add(arr[i]);
        }
        return result;
    }

    public int binarySearch(int[] arr, int num){

        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(arr[mid] == num){
                return mid;
            }else if(arr[mid] < num){
                left = mid + 1;
            }else{
                right = mid;
            }

        }

        return left;
    }
}