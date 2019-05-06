package algorithm;

import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-05-06 22:36
 */
public class Baekjoon_15651 {

    static int cnt = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        int[] input = new int[n];
        int[] array = new int[m];

        // n까지의 정수배열 값 셋팅
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }

        check(input, array, 0, n, m);
    }

    public static void check(int[] input, int[] array, int dep, int n, int m) {
        System.out.println(++cnt);
        // n개의 개수와 깊이를 비교하여 로직 수행여부 결정
        if(m > dep) {
            for (int i = 0; i <= n-dep; i++) {
                array[dep] = input[i];
                check(input, array, dep+1, n, m);
            }
        } else {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
