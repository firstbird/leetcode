package com.mzl.map;

public class NumIslands {


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int rnum = grid.length;
        int cnum = grid[0].length;
        int islandNum = 0;
        for (int i = 0; i < rnum; i++){
            for (int j = 0; j < cnum; j++){
                if (grid[i][j] == '1'){
                    islandNum++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandNum;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rnum = grid.length;
        int cnum = grid[0].length;
        if (i < 0 || j < 0 || i >= rnum || j >= cnum || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
