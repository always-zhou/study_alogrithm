import java.util.Scanner;

/**
 * @Author zhouxianwen
 * @Date 2025/7/8 19:18
 * @Description: 算法刷题-数组篇-开发商贩卖土地
 */
public class ArraysSaleLand {

    /*题目：开发商贩卖土地
    在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
    现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。
    为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
    注意：区块不可再分。
            【输入描述】
    第一行输入两个正整数，代表 n 和 m。
    接下来的 n 行，每行输出 m 个正整数。
    输出描述
    请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
            【输入示例】
            3 3 1 2 3 2 1 3 1 2 3
            【输出示例】
            0
            【提示信息】
    如果将区域按照如下方式划分：
            1 2 | 3 2 1 | 3 1 2 | 3
    两个子区域内土地总价值之间的最小差距可以达到 0。
            【数据范围】：
            1 <= n, m <= 100；
            n 和 m 不同时为 1。*/

    public static void main(String[] args) {
        method01();
        method02();
    }

    // 优化暴力解法
    public static void method01(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int count = 0; // 统计遍历过的行

        // 行切分
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += vec[i][j];
                // 遍历到行末尾时候开始统计
                if (j == m - 1) {
                    result = Math.min(result, Math.abs(sum - 2 * count));
                }
            }
        }

        count = 0;
        // 列切分
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                count += vec[i][j];
                // 遍历到列末尾时候开始统计
                if (i == n - 1) {
                    result = Math.min(result, Math.abs(sum - 2 * count));
                }
            }
        }

        System.out.println(result);
        scanner.close();
    }

    // 前缀和
    public static void method02(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        // 统计横向
        int[] horizontal = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontal[i] += vec[i][j];
            }
        }

        // 统计纵向
        int[] vertical = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                vertical[j] += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int horizontalCut = 0;
        for (int i = 0; i < n; i++) {
            horizontalCut += horizontal[i];
            result = Math.min(result, Math.abs((sum - horizontalCut) - horizontalCut));
            // 更新result。其中，horizontalCut表示前i行的和，sum - horizontalCut表示剩下的和，作差、取绝对值，得到题目需要的“A和B各自的子区域内的土地总价值之差”。下同。
        }

        int verticalCut = 0;
        for (int j = 0; j < m; j++) {
            verticalCut += vertical[j];
            result = Math.min(result, Math.abs((sum - verticalCut) - verticalCut));
        }

        System.out.println(result);
        scanner.close();
    }
}
