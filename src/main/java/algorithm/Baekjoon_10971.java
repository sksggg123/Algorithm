package algorithm;

import java.util.Scanner;

public class Baekjoon_10971 {

    static int[][] ROAD;
    static boolean[] CITY_ACCESS;
    static int MIN = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ROAD = new int[N][N];
        CITY_ACCESS = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ROAD[i][j] = sc.nextInt();
            }
        }
        sc.close();

        for (int i = 0; i < N; i++) {
            CITY_ACCESS[i] = true;
            nextAccess(i, 1, 0, 0);
            CITY_ACCESS[i] = false;
        }

        System.out.println(MIN);
    }

    private static void nextAccess(int start, int count, int sum, int i) {
        if(count < N) {
            for (int j = 0; j < N; j++) {
                if(i!=j && ROAD[i][j] !=0 && !CITY_ACCESS[j]) {
                    CITY_ACCESS[j] = true;
                    sum += ROAD[i][j];
                    nextAccess(start, count+1, sum, j);
                    sum -= ROAD[i][j];
                    CITY_ACCESS[j] = false;
                }
            }
        } else {
            // 접근 count가 n보다 클때 원래 지점으로 돌아오기
            // min 비교
            // 마지막 -> start 0 조건 체크 [스터디 조언사항] - > 추가로직 설계해보자
            if (ROAD[i][start] != 0) {
                sum += ROAD[i][start];
                MIN = (MIN > sum) ? sum : MIN;
            }
        }
    }
}
