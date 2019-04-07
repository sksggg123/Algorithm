package algorithm;

import java.util.Scanner;

public class Baekjoon_10974 {

    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // n까지의 정수 배열
        int[] input = new int[n];
        // input 배열에서 값을 추출하여 저장할 배열
        int[] array = new int[n];
        // index 접근 유무 확인 용도
        boolean[] access = new boolean[n];

        // n까지의 정수배열 값 셋팅
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }

        // 메서드 실행
        check(input, array, access, 0, n);

    }

    public static void check(int[] input, int[] array, boolean[] access, int dep, int n) {

        // n개의 개수와 깊이를 비교하여 로직 수행여부 결정
        if(n > dep) {
            for (int i = 0; i < n; i++) {
                cnt++;
//                System.out.println("cnt = [" + cnt + "] " + "input = [" + input[i] + "], array = [" + array[i] + "], access = [" + access[i] + "], dep = [" + (dep+1) + "], n = [" + n + "]");
                // index 접근하여 추출한 여부 체크
                if(!access[i]) {
                    // dep 번째 index에 i 번째 값을 넣는 부분이 중요
                    array[dep] = input[i];
                    access[i] = true;
                    check(input, array, access, dep+1, n);
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
