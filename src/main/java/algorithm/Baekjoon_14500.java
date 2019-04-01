package algorithm;

import java.util.Scanner;

public class Baekjoon_14500 {

    // 상, 하, 좌, 우
    static private int[] validRow = {-1, 1, 0, 0}, validLine = {0, 0, -1, 1};

    // check flag
    static private boolean[][] flag;

    // max
    static private int max = 0;

    public static void main(String[] args) {

        // 1. input setting
        Scanner sc = new Scanner(System.in);
        String[] row = sc.nextLine().split(" ");
        int[][] input = new int[Integer.parseInt(row[0])][Integer.parseInt(row[1])];

        for (int i = 0; i < Integer.parseInt(row[0]) ; i++) {
            String[] rowValue = sc.nextLine().split(" ");

            for (int j = 0; j < Integer.parseInt(row[1]) ; j++) {
                input[i][j] = Integer.parseInt(rowValue[j]);
            }

        }
        sc.close();
        // 1. input setting

        // 2. input 배열과 동일 크기의 boolean type 배열 설정 (default: false)
        flag = new boolean[Integer.parseInt(row[0])][Integer.parseInt(row[1])];

        // 3. 모든 index 순차시작
        for (int i = 0; i < Integer.parseInt(row[0]); i++) {
            for (int j = 0; j < Integer.parseInt(row[1]); j++) {
                flag[i][j] = true;
                dfs(0, 0, input, flag, i, j);
                flag[i][j] = false;
            }
        }

        // 4. 'ㅗ', 'ㅜ', 'ㅓ', 'ㅏ' check
        for (int i = 0; i < Integer.parseInt(row[0]); i++) {
            for (int j = 0; j < Integer.parseInt(row[1]); j++) {
                exceptionShape(input, i, j, 1);
                exceptionShape(input, i, j, 2);
                exceptionShape(input, i, j, 3);
                exceptionShape(input, i, j, 4);
            }
        }

        System.out.println(max);
    }

    static void dfs(int dept, int sum, int[][] array, boolean[][] flag, int row, int line) {

        // 4개의 index 접근 시 max와 sum 비교 처리
        // 그렇지 않으면 계속 합산
        if(dept > 3) {
            max = (max < sum) ? sum : max;
            System.out.printf("[DEPT]  ==>  dept:%d, sum:%d, target:%d, row:%d, line:%d\n", dept, sum, array[row][line], row, line);
        } else {
//            try {
//                System.out.printf("[SUM]  ==>  dept:%d, sum:%d, target:%d, row:%d, line:%d\n", dept, sum, array[row][line], row, line);
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//
//            }

            sum += array[row][line];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + validRow[i];
                int nextLine = line + validLine[i];

                if( (nextRow >= 0 && nextRow < array.length)
                        && (nextLine >= 0 && nextLine < array[0].length)
                        && !flag[nextRow][nextLine] ) {

                    flag[nextRow][nextLine] = true;
                    dfs(dept + 1, sum, array, flag, nextRow, nextLine);
                    flag[nextRow][nextLine] = false;
                }
            }
        }
    }

    static void exceptionShape(int[][] array, int row, int line, int type) {

        int nextUp = row + validRow[0];
        int nextDown = row + validRow[1];
        int nextLeft = line + validLine[2];
        int nextRight = line + validLine[3];
        int sum = 0;

        switch (type) {
            case 1:
                if( (nextUp >= 0)
                        && (nextLeft >= 0)
                        && (nextRight <= array[0].length-1) ) {

                    sum += array[row][line];
                    sum += array[nextUp][line];
                    sum += array[row][nextLeft];
                    sum += array[row][nextRight];
                }
                break;
            case 2:
                if((nextDown <= array.length-1)
                        && (nextLeft >= 0)
                        && (nextRight <= array[0].length-1) ) {

                    sum += array[row][line];
                    sum += array[nextDown][line];
                    sum += array[row][nextLeft];
                    sum += array[row][nextRight];
                }
                break;
            case 3:
                if( (nextUp >= 0)
                        && (nextDown <= array.length-1)
                        && (nextLeft >= 0)) {

                    sum += array[row][line];
                    sum += array[nextUp][line];
                    sum += array[nextDown][line];
                    sum += array[row][nextLeft];
                }
                break;
            case 4:
                if( (nextUp >= 0)
                        && (nextDown <= array.length-1)
                        && (nextRight <= array[0].length-1) ) {

                    sum += array[row][line];
                    sum += array[nextUp][line];
                    sum += array[nextDown][line];
                    sum += array[row][nextRight];
                }
                break;
        }
        max = (max < sum) ? sum : max;
    }

}
