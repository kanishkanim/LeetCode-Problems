class Solution {

public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if(nums.length==0)
        return result;
    int count1 = 0, count2 = 0;
    int num1 = nums[0], num2 = nums[0];
    for (int num : nums) {
        if (num1 == num)
            count1++;
        else if (num2 == num)
            count2++;
        else if (count1 == 0) {
            num1 = num;
            count1++;
        } else if (count2 == 0) {
            num2 = num;
            count2++;
        } else {
            count1--;
            count2--;
        }
    }
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
        if (num1 == num)
            count1++;
        else if (num2 == num)
            count2++;
    }
    if (count1 > nums.length / 3) {
        result.add(num1);
    }
    if (count2 > nums.length / 3) {
        result.add(num2);
    }
    return result;
}
}