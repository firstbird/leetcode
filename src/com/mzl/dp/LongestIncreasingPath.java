package com.mzl.dp;

import java.util.Arrays;
import java.util.Map;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[row][col];
        int[][] res = new int[row][col];
        int len = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                len = Math.max(len, dfs(matrix, i, j, row, col, Integer.MIN_VALUE, res));
            }
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.printf("i: %d, j: %d, data: %d, res: %d \n", i, j, matrix[i][j], res[i][j]);
//            }
//        }
        return len;
    }

    private int dfs(int[][] matrix, int i, int j, int row, int col, int old, int[][] res) {
        if (i < 0 || j < 0 || i >= row || j >= col || old >= matrix[i][j]) {
            return 0;
        }
        if (res[i][j] != 0) {
            return res[i][j];
        }
        int subLen = 0;
        int curVal = matrix[i][j];
        subLen = Math.max(subLen, dfs(matrix, i -1, j, row, col, curVal, res));
        subLen = Math.max(subLen, dfs(matrix, i +1, j, row, col, curVal, res));
        subLen = Math.max(subLen, dfs(matrix, i, j+1, row, col, curVal, res));
        subLen = Math.max(subLen, dfs(matrix, i, j-1, row, col, curVal, res));
        res[i][j] = subLen +1;
        return res[i][j];
    }
}
