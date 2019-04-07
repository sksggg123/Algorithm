package algorithm;

import java.util.Scanner;

public class Baekjoon_10972 {

    public static void main(String[] args) {

        // input setting
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        boolean flag = false;

        int cmpRight = -1;
        int cmpLeft = -1;
        for (int i = n-1; i >= 1 ; i--) {

            if(input[i-1] < input[i]) {
                cmpRight = i;
                cmpLeft = i-1;

                break;
            }

            if(i==1) {
                flag = true;
            }
        }

        if(!flag) {
            for (int i = n-1; i >= cmpRight; i--) {
                if(input[cmpLeft] < input[i]) {
                    int swap = input[i];
                    input[i] = input[cmpLeft];
                    input[cmpLeft] = swap;

                    break;
                }
            }

            for (int i = cmpRight; i < n ; i++) {
                for (int j = i+1; j < n; j++) {
                    if(input[i] > input[j]) {
                        int swqp = input[i];
                        input[i] = input[j];
                        input[j] = swqp;
                    }
                }
            }

            for (int i = 0; i < input.length; i++) {
                System.out.print(input[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}