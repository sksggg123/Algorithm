package algorithm;

import java.util.Scanner;

public class Baekjoon_3085 {

    static int max = 0;

    public static void main(String[] args) {

        // 1. 입력시작
        Scanner sc1 = new Scanner(System.in);
        // 2. row 값 설정
        int row = sc1.nextInt();

        // 3. 입력 배열 설정
        String[][] item = new String[row][row];
        for (int i = 0; i < row; i++) {
            String temp = sc1.next();
            item[i] = temp.split("");
        }
        // 1. 입력종료
        sc1.close();

        // check 시작
        doCheck(item, row);

        System.out.println(max);
    }

    // array 반복문을 통해 인접 index 선별
    static void doCheck(String[][] item, int row) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {

                // case에 따라 인접 index가 다르다.
                if (i==0 && j==0) {

                    switchCase(1, item, i, j);
                    switchCase(3, item, i, j);

                } else if (i==(item.length-1) && j==(item[i].length -1)) {

                    switchCase(2, item, i, j);
                    switchCase(4, item, i, j);

                } else if (i==0 && j==(item[i].length-1)) {

                    switchCase(2, item, i, j);
                    switchCase(3, item, i, j);

                } else if (i==(item.length-1) && j==0) {

                    switchCase(1, item, i, j);
                    switchCase(4, item, i, j);

                } else if (i==0) {

                    switchCase(1, item, i, j);
                    switchCase(2, item, i, j);
                    switchCase(3, item, i, j);

                } else if (j==0) {

                    switchCase(1, item, i, j);
                    switchCase(3, item, i, j);
                    switchCase(4, item, i, j);

                } else if (i==(item.length-1)) {

                    switchCase(1, item, i, j);
                    switchCase(2, item, i, j);
                    switchCase(4, item, i, j);

                } else if (j==(item[i].length-1)) {

                    switchCase(2, item, i, j);
                    switchCase(3, item, i, j);
                    switchCase(4, item, i, j);

                } else {

                    switchCase(1, item, i, j);
                    switchCase(2, item, i, j);
                    switchCase(3, item, i, j);
                    switchCase(4, item, i, j);

                }

            }
        }

    }

    // 인접 index의 4가지 case
    static void switchCase(int caseNum, String[][] item, int row, int line) {
        switch (caseNum) {
            // 동
            case 1: doSwitchCheck(item, row, line, row, line+1);
                    break;
            // 서
            case 2: doSwitchCheck(item, row, line, row, line-1);
                    break;
            // 남
            case 3: doSwitchCheck(item, row, line, row+1, line);
                    break;
            // 북
            case 4: doSwitchCheck(item, row, line, row-1, line);
                    break;
        }
    }

    // 인접한 index 변경
    static void doSwitchCheck(String[][] switchArr, int originRow, int originLine, int row, int line) {
        // index switching
        String temp = switchArr[originRow][originLine];
        switchArr[originRow][originLine] = switchArr[row][line];
        switchArr[row][line] = temp;

        int cnt = 0;
        String key = switchArr[originRow][originLine];;

        for (int i = 0; i < switchArr.length; i++) {
            if(key.equals(switchArr[i][originLine])) {
                cnt++;
                doMaxCheck(cnt);
            } else {
                cnt=0;
            }
        }

        cnt = 0;
        for (int i = 0; i < switchArr.length; i++) {
            if(key.equals(switchArr[originRow][i])) {
                cnt++;
                doMaxCheck(cnt);
            } else {
                cnt=0;
            }
        }

        // index switching
        temp = switchArr[originRow][originLine];
        switchArr[originRow][originLine] = switchArr[row][line];
        switchArr[row][line] = temp;
    }

    // max compare
    static void doMaxCheck(int source) {
        if(source > max) {
            max = source;
        }
    }

}
