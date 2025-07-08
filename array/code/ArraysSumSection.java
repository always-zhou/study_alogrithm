import java.util.Scanner;

/**
 * @Author zhouxianwen
 * @Date 2025/7/8 18:54
 * @Description: 算法刷题-数组篇-区间和
 */
public class ArraysSumSection {

    /*题目：区间和
    给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
    输入描述
    第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。
    随后的输入为需要计算总和的区间，直至文件结束。
    输出描述
    输出每个指定区间内元素的总和。*/

    // 使用 前缀和 计算数组中，每个下标的区间和，在计算区间和的时候，可以用相减的方式去计算。
    // 比如 数组【1，2，3，4，5，6】，那么计算以后 p = [1,3,6,10,15，21]，要计算0，1的和就是p[1]的值，
    // 要计算1，3就是p[3]-p[0]的值
    // 因为 p[3] = p0 + p1 +p2 +p3
    // 要计算 2，5的和 就是 p5-p1
    // 因为p5 = p0 + p1 + p2 + p3 + p4 + p5
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vec = new int[n];
        int[] p = new int[n];

        int presum = 0;
        for (int i = 0; i < n; i++) {
            vec[i] = scanner.nextInt();
            presum += vec[i];
            p[i] = presum;
        }

        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int sum;
            if (a == 0) {
                sum = p[b];
            } else {
                sum = p[b] - p[a - 1];
            }
            System.out.println(sum);
        }

        scanner.close();
    }
}
