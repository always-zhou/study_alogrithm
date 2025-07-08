/**
 * @Author zhouxianwen
 * @Date 2025/7/8 17:29
 * @Description: 算法刷题-数组篇-长度最小的子数组
 */
public class ArraysMinSubArrayLen {

    /*题目：长度最小的子数组
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
    如果不存在符合条件的子数组，返回 0。
    示例：
    输入：s = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    提示：
            1 <= target <= 10^9
            1 <= nums.length <= 10^5
            1 <= nums[i] <= 10^5*/

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 6;
//        System.out.println(minSubArrayLen01(nums, target));
        System.out.println(minSubArrayLen02(nums, target));
//        System.out.println(Integer.MAX_VALUE);
    }

    // 解法一：暴力破解
    public static int minSubArrayLen01(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = j - i + 1;
                    break;
                }
            }
        }
        return res;
    }

    // 第二种解法：滑动差窗口（双指针的一种）
    public static int minSubArrayLen02(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
