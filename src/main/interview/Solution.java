package interview;

import java.util.Scanner;

/**
 * Created by lason on 8/28/16.
 */
public class Solution {
    int [][]matrix = new int[100][100];
    int [][]cnt = new int[100][100]; // 记录每一个点的最大滑雪长度
    int row ,col;

    public int DP(int i, int j) {
        int max = 0;
        if (cnt[i][j] > 0)
            {
                return cnt[i][j];
            }
            if (j-1 >= 0)
            {
                if (matrix[i][j] > matrix[i][j-1])
                {
                    if (max < DP(i, j-1))
                    {
                        max = DP(i, j-1);
                    }
                }
            }

            if (j+1 <= col-1)
            {
                if (matrix[i][j] > matrix[i][j+1])
                {
                    if (max < DP(i, j+1))
                    {
                        max = DP(i, j+1);
                    }
                }
            }

            if (i-1 >= 0)
            {
                if (matrix[i][j] > matrix[i-1][j])
                {
                    if (max < DP(i-1, j))
                    {
                        max = DP(i-1, j);
                    }
                }
            }


            if (i+1 <= row-1)
            {
                if (matrix[i][j] > matrix[i+1][j])
                {
                    if (max < DP(i+1, j))
                    {
                        max = DP(i+1, j);
                    }
                }
            }
            return cnt[i][j] = max + 1;
        }


        public static void  main(String []args) {
            Scanner in = new Scanner(System.in);
            Solution demo = new Solution();
            while (in.hasNextInt()) {
                int row = in.nextInt();
                int col = in.nextInt();
                for (int i = 0; i <= row - 1; i++) {
                    for (int j = 0; j <= col - 1; j++) {
                        demo.matrix[i][j] = in.nextInt();
                        demo.cnt[i][j] = 0;
                    }
                }

                // 处理每一个点,将其最大滑雪长度保存在cnt数组里面
                for (int i = 0; i <= row - 1; i++) {
                    for (int j = 0; j <= col - 1; j++) {
                        demo.DP(i, j);
                    }
                }

                for (int i = 0; i <= row - 1; i++) {
                    for (int j = 0; j <= col - 1; j++) {
                        if (demo.cnt[0][0] < demo.cnt[i][j]) {
                            demo.cnt[0][0] = demo.cnt[i][j];
                        }
                    }
                }

                for (int i = 0; i <= row - 1; i++) {
                    for (int j = 0; j <= col - 1; j++) {
                        System.out.println(demo.cnt[i][j]);
                    }
                }
            }

        }
}
