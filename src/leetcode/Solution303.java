package leetcode;

public class Solution303 {
    //存储前i元素和，sum[0]=0;
    private int sum[];
    public Solution303(int[] nums){
        sum=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i <nums.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i,int j){
        //j+1因为sum[0]为0个元素的和，i因为包括进去了
        return sum[j+1]-sum[i];
    }
}
