class Solution {
    public int majorityElement(int[] nums) {
        
        //size of the given array:
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return nums[i];
        }
        return -1;
    }
}

