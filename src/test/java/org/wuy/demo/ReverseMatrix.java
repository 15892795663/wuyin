package org.wuy.demo;

/**
 * @Title:
 * @Description: TODO
 * @Company:北京九恒星科技股份有限公司
 * @Author xiaolong
 * @Date 2020/4/7
 **/
public class ReverseMatrix {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(a);
        System.out.println(a);
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = i; i1 < matrix[i].length; i1++) {
                int temp = matrix[i][i1];
                matrix[i][i1] = matrix[i1][i];
                matrix[i1][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length / 2; i1++) {
                int temp = matrix[i][i1];
                matrix[i][i1] = matrix[i][matrix.length - 1 - i1];
                matrix[i][matrix.length - 1 - i1] = temp;
            }
        }
    }
}
