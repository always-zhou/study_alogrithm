/**
 * @Author zhouxianwen
 * @Date 2025/7/8 10:44
 * @Description: 算法刷题-数组篇-二分查找
 */
public class Arrays_TwoFen {

    static int[] nums ={1,3,4,6,7,8,9};
    static int target = 9;
    public static void main(String[] args) {
//        test01(nums, target);
        int i = test03(nums, target);
        System.out.println(i);
    }

    // 二分查找

    /*
    * 题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
    * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    * */

    // 普通的实现
    public static void test01(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target) {
                System.out.println(i);
            }
            i+=1;
        }
    }

    // 二分法实现-区间左闭右闭
    public static int test02(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length-1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1); // 这里 >> 1就是把二进制的结果右移一位，同等于 除与2并向下取整
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }



    // 二分法实现-区间左闭右开
    public static int test03(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length-1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1); // 这种右移的操作，记得用括号
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return -1;
    }
}
