import java.util.Arrays;

/**
 * @Author zhouxianwen
 * @Date 2025/7/8 15:43
 * @Description: 算法刷题-数组篇-有序数组的平方
 */
public class ArraysSortedSquares {

/*
题目：有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
*/

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
//        System.out.println(Arrays.toString(twoSum(nums)));
        System.out.println(Arrays.toString(twoSum02(nums)));
    }

    // 暴力解法：循环拿到平方后的数据，在做排序
    public static  int[] twoSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针法：因为数组是有序的，所有平方后，最大的也是在最边上，要不左边/右边。
    // 双指针 从两端开始 比较平方后的大小，取值大的放到 新的数组最右边
    public static int[] twoSum02(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int index = res.length-1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index--] = nums[left] * nums[left];
                ++left;
            } else {
                res[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return res;
    }
}
