package algorithm;

import java.util.Scanner;

public class Baekjoon_10819 {

    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        int[] array = new int[n];
        boolean[] access = new boolean[n];

        check(input, array, access, n, 0);

        System.out.println(max);
    }

    public static void check(int[] input, int[] array, boolean[] access, int n, int dep) {
        if(n > dep) {
            for (int i = 0; i < n; i++) {
                if(!access[i]) {
                    array[dep] = input[i];
                    access[i] = true;
                    check(input, array, access, n, dep+1);
                    access[i] = false;
                }
            }
        } else {
            // 정리된 순열 경우의 수를 통해 sum 메서드 호출
            maxCheck(array);
        }
    }

    public static void maxCheck(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length-1 ; i++) {
            sum += Math.abs(array[i] - array[i+1]);
        }

        if(sum > max) {
            max = sum;
        }
    }
}
