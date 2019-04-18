package algorithm;

import java.util.Scanner;

public class Baekjoon_4963 {

    private static int cnt = 0;
    private static int[] row = {-1, 0, 1, 0, -1, -1, 1, 1};
    private static int[] line = {0, -1, 0, 1, -1, 1, -1, 1};
    private static boolean[][] access;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {

            int w = sc.nextInt();
            int h = sc.nextInt();
            if(w == 0 && h == 0) {
                break;
            }

            int[][] array = new int[h][w];
            access = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 여러개의 TestCase 중 하나씩 처리
                    array[i][j] = sc.nextInt();
                }
            }
            check(array);
            System.out.println(cnt);
            cnt = 0;

        }
        sc.close();

    }

    private static void check(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                boolean startFlag = false;
                allCheck(array, i, j, startFlag);
            }
        }
    }

    private static void allCheck(int[][] array, int i, int j, boolean startFlag) {
        if(!access[i][j] && !startFlag && array[i][j] != 0) {
            access[i][j] = true;
            cnt++;
            for (int k = 0; k < 8 ; k++) {
                if((i + row[k]) >= 0
                        && (j + line[k]) >= 0
                        && array.length > i+row[k]
                        && array[i].length > j+line[k]) {
                    allCheck(array, i+row[k], j+line[k], true);
                }
            }
        }

        if(!access[i][j] && startFlag && array[i][j] != 0) {
            access[i][j] = true;
            for (int k = 0; k < 8 ; k++) {
                if((i + row[k]) >= 0
                        && (j + line[k]) >= 0
                        && array.length > i+row[k]
                        && array[i].length > j+line[k]) {
                    allCheck(array, i+row[k], j+line[k], true);
                }
            }
        }
    }
}
