/**
 * @Author zhouxianwen
 * @Date 2025/7/8 14:48
 * @Description: 算法刷题-数组篇-移除元素
 */
public class Arrays_RemoveElement {

    /*题目：移除元素
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
    示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
    你不需要考虑数组中超出新长度后面的元素。*/

    static int[] num = {0,1,2,2,3,0,4,2};
    static int val = 2;

    public static void main(String[] args) {
//        System.out.println(method01(num, val));
//        System.out.println(method02(num, val));
//        System.out.println(method03(num, val));
        System.out.println(method04(num, val));
    }

    // 暴力解法-双重for循环，第一层查找元素，第二层移动位置
    public static int method01(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val){
                for (int i1 = i+1; i1 < size; i1++) {
                    nums[i1-1] = nums[i1];
                }
                i--; // 元素往前移一位
                size--;
            }
        }
        return size;
    }

    // 双指针解法（快慢指针）
    // 快指针：寻找新数组的元素，不包含目标元素数据
    // 慢指针：指向更新，新数组的下标
    public static int method02(int[] nums, int target) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != target) {
                nums[slowIndex++] = nums[fastIndex]; // 先赋值后，在新增慢指标的值
            }
        }
        return slowIndex;
    }

//    双指针法（相向双指针法) 版本一
    public static int method03(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }


//    双指针法（相向双指针法) 版本二
    public static int method04(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else {
                // 这里兼容了right指针指向的值与val相等的情况
                left++;
            }
        }
        return left;
    }
}
