package algorithm;

import java.util.Scanner;

public class Baekjoon_10973 {

    private static int resultArray[][];
    private static int row = 0;
    private static int mul = 1;

    public static void main(String[] args) {

        // input setting
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
            mul *= i + 1;
        }
        sc.close();

        // static array range setting
        resultArray = new int[mul][n];

        for (int i = 1; i <= n; i++) {

            bfs(n, i, 1, 0);

        }


        for (int[] one : resultArray) {
            for (int two : one) {
                System.out.print(two + " ");
            }
            System.out.println();
        }


    }

    static void bfs(int n, int k, int dept, int indexNum) {

        int a = n-dept;
        int b = a-1;
        int start =
        System.out.printf("%d, %d", a, b);

    }
}