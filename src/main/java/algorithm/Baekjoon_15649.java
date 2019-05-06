package algorithm;

import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * <p>
 * email        : sksggg123
 * github       : github.com/sksggg123
 * blog         : sksggg123.github.io
 * <p>
 * project      : algorithm
 * <p>
 * create date  : 2019-05-06 13:24
 */
public class Baekjoon_15649 {

    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        int[] input = new int[n];
        int[] array = new int[m];
        boolean[] access = new boolean[n];

        // n까지의 정수배열 값 셋팅
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }

        // 메서드 실행
        check(input, array, access, 0, n, m);

    }

    public static void check(int[] input, int[] array, boolean[] access, int dep, int n, int m) {

        // n개의 개수와 깊이를 비교하여 로직 수행여부 결정
        if(m > dep) {
            for (int i = 0; i < n; i++) {
                cnt++;
                // index 접근하여 추출한 여부 체크
                if(!access[i]) {
                    // dep 번째 index에 i 번째 값을 넣는 부분이 중요
                    array[dep] = input[i];
                    access[i] = true;
                    check(input, array, access, dep+1, n, m);
                    // 접근한 index를 다시 false로 초기화 시켜주어야 다음 경우의 순열이 접근가능
                    access[i] = false;
                }
            }
        } else {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
