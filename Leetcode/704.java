class Solution {
    public int search(int[] nums, int target) {

        int ans = binarySearch(nums, target, 0, nums.length - 1);
        return ans;

    }

    public int binarySearch(int[] nums, int target, int left, int right) {

        if (right >= left) {

            int mid = (right + left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    return binarySearch(nums, target, left, mid - 1);
                } else {
                    return binarySearch(nums, target, mid + 1, right);
                }
            }

        }
        return -1;
    }

}