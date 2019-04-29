package algorithm;

import java.util.*;

public class Baekjoon_13023 {

    // match 조건
    private static int matchCnt = 4;
    private static int n;
    private static int m;
    private static int[][] input;
    private static boolean[][] access;

    public static void main(String[] args) {
        // input data
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n][n];
        access = new boolean[n][n];
        Map<Integer, List<Integer>> inputMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int source = sc.nextInt();
            int target = sc.nextInt();
            int sourceSwapTarget = target;
            int targetSwapSource = source;

            input[source][target] = 1;
            input[sourceSwapTarget][targetSwapSource] = 1;


        }
        sc.close();

    }

    private static void check(int depth, int originIndex) {

    }
}

