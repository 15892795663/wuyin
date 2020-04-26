package org.wuy.demo;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Description: TODO
 * @Company:北京九恒星科技股份有限公司
 * @Author xiaolong
 * @Date 2020/4/15
 **/
public class CalculateMatrixDistance {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        //int[][] b = updateMatrix(a);
        int[][] c = updateMatrix_1(a);
        int[][] d = updateMatrix_2(a);
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int[][] distanceMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int minDistance = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) {
                    distanceMatrix[i][j] = matrix[i][j];
                    continue;
                }
                for (int i1 = 0; i1 < matrix.length; i1++) {
                    for (int j1 = 0; j1 < matrix[i].length; j1++) {
                        if ((i != i1 || j != j1) && matrix[i1][j1] == 0) {
                            minDistance = min(minDistance, getDistance(i, j, i1, j1));
                        }
                    }
                }
                distanceMatrix[i][j] = minDistance;
            }
        }
        return distanceMatrix;
    }

    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static int getDistance(int i, int j, int i1, int j1) {
        return Math.abs(i - i1) + Math.abs(j - j1);
    }

    public static int[][] updateMatrix_1(int[][] matrix) {
        int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        int[][] seen = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = 1;
                }
            }
        }
        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            for (int d = 0; d < 4; ++d) {
                int ni = a[0] + dirs[d][0];
                int nj = a[1] + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && seen[ni][nj] == 0) {
                    dist[ni][nj] = dist[a[0]][a[1]] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = 1;
                }
            }
        }

        return dist;
    }

    public static int[][] updateMatrix_2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

}