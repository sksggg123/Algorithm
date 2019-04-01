package algorithm;

import java.util.Scanner;

public class baekjoon_1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int length = 0;
        int cnt = 1;
        int target = 10;
        for (int i = 1; i <= num; i++) {
            if(i%target == 0) {
                cnt++;
                target *= 10;
            }
            length += cnt;
            System.out.println(cnt + " | " + length);
        }

        System.out.println(length);
    }
}