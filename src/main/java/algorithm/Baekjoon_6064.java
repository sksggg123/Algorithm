package algorithm;

import java.util.Scanner;

public class Baekjoon_6064 {

    public static void main(String[] args) {

        // 1. input setting
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < row; i++) {
            String temp = sc.nextLine();
            String[] str = temp.split(" ");

            System.out.println(processing(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
        }
        sc.close();


    }

    public static int processing(int m, int n, int x, int y) {

        // m * i(반복횟수) + x = n * j(반복횟수) + y = Answer
        // 각각의 반복 횟수 초기화
        int i=0, j=0, year=-1;

        // 조건에 맞을떄까지 반복 순회
        int lcm = lcm(m, n);
        while(true) {
            // 년도 계산 값
            year = m * i + x;
            // 년도가 최소공배수와 같거나 크다면 문제는 끝나지 않기에 "-1"로 리턴
            if(lcm <= year) return -1;

            // 핵심 공식이다.
            int mX = m * i + x, nY = n * j + y;

            // mX == nY 이면 구하려는 값이기에 year을 반환
            if(mX == nY) {
                break;
            } else {
                // mX와 nY의 값을 비교하여 연산작업에 필요한 값을 올려준다.
                if(mX > nY) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return year;
    }

    // 최소공배수 구하기
    public static int lcm(int m, int n) {
        int max = m, min = n, r = 1;
        if(max<min) {
            max=n;
            min=m;
        }

        while(r>0) {
            r = max%min;
            max=min;
            min=r;
        }
        return m*n/max;
    }
}
