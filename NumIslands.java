package com.test.week04;

public class NumIslands {

    int res = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                // 是陆地是才进行相邻结点扫描
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    // 深度搜索遍历网格
    private void dfs(char[][] grid, int row, int col) {
        // terminator1：判断越界及已遍历过
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] != '1')
            return;
        // proccess logic status设置已遍历过的
        grid[row][col] = '2';
        // drill down：扫描当前结点的上方
        dfs(grid, row - 1, col);
        // drill down：扫描当前结点的下访
        dfs(grid, row + 1, col);
        // drill down：扫描当前结点的左方
        dfs(grid, row, col - 1);
        // drill down：扫描当前结点的右方
        dfs(grid, row, col + 1);
    }
}
