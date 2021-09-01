class Solution {
    public int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private int helper(int[] nums, int s, int e){
        if(s+1 >= e){
            int min = (nums[s]>nums[e])? nums[e]:nums[s];
            return min;
        }

        if(nums[s]<nums[e]){
            return nums[s];
        }
        int mid = (s+e)/2;
        int leftmin = helper(nums,s,mid);
        int rightmin = helper(nums,mid+1,e);
        int finalmin = (leftmin>rightmin)? rightmin:leftmin;
        return finalmin;
    }
}