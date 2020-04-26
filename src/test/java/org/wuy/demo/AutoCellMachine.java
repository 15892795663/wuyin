package org.wuy.demo;

/**
 * @Title:
 * @Description: TODO
 * @Company:北京九恒星科技股份有限公司
 * @Author xiaolong
 * @Date 2020/4/2
 **/
public class AutoCellMachine {

    public static void main(String[] args) {
        int a[][] = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }

    }

    public static void gameOfLife(int[][] board) {
        if (board.length <= 0) {
            return;
        }
        int[][] nextBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                saveThatCell(i, j, nextBoard, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    private static void saveThatCell(int i, int j, int[][] nextBoard, int[][] board) {
        int survivalCell = 0;
        if (i > 0 && j > 0 && board[i - 1][j - 1] == 1) {
            survivalCell++;
        }
        if (i > 0 && board[i - 1][j] == 1) {
            survivalCell++;
        }

        if (i > 0 && j < board[i].length - 1 && board[i - 1][j + 1] == 1) {
            survivalCell++;
        }

        if (j > 0 && board[i][j - 1] == 1) {
            survivalCell++;
        }

        if (j < board[i].length - 1 && board[i][j + 1] == 1) {
            survivalCell++;
        }

        if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] == 1) {
            survivalCell++;
        }

        if (i < board.length - 1 && board[i + 1][j] == 1) {
            survivalCell++;
        }

        if (i < board.length - 1 && j < board[i].length - 1 && board[i + 1][j + 1] == 1) {
            survivalCell++;
        }

        if (survivalCell < 2) {
            nextBoard[i][j] = 0;
        } else if (survivalCell == 2 && board[i][j] == 1) {
            nextBoard[i][j] = 1;
        } else if (survivalCell == 3) {
            nextBoard[i][j] = 1;
        } else if (survivalCell > 3) {
            nextBoard[i][j] = 0;
        }

    }
}
