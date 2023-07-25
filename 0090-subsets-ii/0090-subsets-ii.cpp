public class Solution {
    private void solve(int[] nums, int index, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);
            solve(nums, i + 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        solve(nums, 0, ans, tmp);
        return ans;
    }
}