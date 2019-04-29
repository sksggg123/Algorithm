package algorithm;

import java.util.Scanner;

public class Baekjoon_11724 {

    private static int[][] input;
    private static boolean[][] access;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        input = new int[n+1][n+1];
        access = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int source = sc.nextInt();
            int target = sc.nextInt();
            int swpaSourceTarget = target;
            int swapTargetSource = source;

            input[source][target] = 1;
            input[swpaSourceTarget][swapTargetSource] = 1;
        }
        sc.close();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {

            }
        }
    }
}
