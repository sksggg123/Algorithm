package algorithm;

import java.util.Scanner;

/**
 * 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
 */
public class Baekjoon_1476 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        String[] inputArr = input.split(" ");
        int e = Integer.parseInt(inputArr[0]);
        int s = Integer.parseInt(inputArr[1]);
        int m = Integer.parseInt(inputArr[2]);

        int eCnt = 1;
        int sCnt = 1;
        int mCnt = 1;

        int year = 1;

        while(true) {
            if ( (e == eCnt) && (s == sCnt) && (m == mCnt) ) {
                break;
            } else {
                if(eCnt > 15 || sCnt > 28 || mCnt > 19) {

                    if(eCnt > 15) {
                        eCnt = 1;
                    }

                    if(sCnt > 28) {
                        sCnt = 1;
                    }

                    if(mCnt > 19) {
                        mCnt = 1;
                    }

                } else {
                    eCnt++; sCnt++; mCnt++; year++;
                }

            }
        }

        System.out.println(year);
    }

}
