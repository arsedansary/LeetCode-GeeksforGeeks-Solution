class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
int sum=0;
for(int i : nums){
  sum=i==1?++sum:0;
    max=Math.max(sum,max);
}
return max;
        
    }
}
 