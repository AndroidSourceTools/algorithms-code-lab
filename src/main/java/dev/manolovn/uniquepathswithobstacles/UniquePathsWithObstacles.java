package dev.manolovn.uniquepathswithobstacles;

/**
 * source: https://leetcode.com/problems/unique-paths-ii/
 * difficulty: MEDIUM
 * topic: DYNAMIC PROGRAMMING
 */
public class UniquePathsWithObstacles {

    /**
     * Time:  O(N*M) ; where N and M are the dimensions of the input grid
     * Space: O(1) ; modifying the input, space complexity is constant
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // precondition, if the first cell is obstacle no paths are possible
        if (obstacleGrid[0][0] == 1) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < rows; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < cols; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[rows-1][cols-1];
    }
}
