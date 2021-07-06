class Solution {
public void nextPermutation(int[] nums) {

    if(nums.length <= 1 ) return;
     for (int i = nums.length - 2; i > -1; i--) {
        if (nums[i] < nums[i + 1]) {
		    
            int r = i + 1;
            while (r + 1 < nums.length && nums[i] < nums[r + 1]) r++;
            swap(nums, i, r);
            reverse(nums, i + 1, nums.length - 1);
            return;
        }
    }
    
     reverse(nums, 0, nums.length - 1);
}
public static void swap(int[] nums , int i , int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
public static void reverse(int[] nums , int i , int j){
    while(i < j){
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
       i++;
        j--;
    }
}
}