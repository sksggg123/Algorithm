package algorithm;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_6064 {

    public static void main(String[] args) throws IOException {

        // 1. input setting
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < row; i++) {
            String temp = sc.nextLine();
            String[] str = temp.split(" ");

            System.out.println(returnInteger(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
        }
        sc.close();


    }

    static int returnInteger(int m, int n, int x, int y) {

        int cnt = 1;
        int startX = 1;
        int startY = 1;
        while (true) {
            if (startX == m && startY == n) {
                return -1;
            } else {
                startX++;
                startY++;
                cnt++;
                startX = (startX > m) ? 1 : startX;
                startY = (startY > n) ? 1 : startY;

                if (startX == x && startY == y) {
                    return cnt;
                }
            }
        }
    }
}
