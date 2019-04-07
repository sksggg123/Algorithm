package algorithm;

import java.util.Scanner;

public class Baekjoon_2529 {

    static String min = "999999999";
    static String max = "0";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.next();
        }
        sc.close();

        int[] num = new int[10];
        boolean[] numAccess = new boolean[10];
        int[] array = new int[n+1];
        boolean[] access = new boolean[n+1];
        for (int i = 0; i < 10; i++) {
            num[i] = i;
        }

        check(input, num, array, access, numAccess, n, 0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void check(String[] input, int[] num, int[] array, boolean[] access, boolean[] numAccess, int n, int dep) {
        if(n >= dep) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    if(!access[i] && !numAccess[j]) {
                        array[dep] = num[j];
                        access[i] = true;
                        numAccess[j] = true;
                        check(input, num, array, access, numAccess, n, dep+1);
                        access[i] = false;
                        numAccess[j] = false;
                    }
                }
            }
        } else {
            boolean flag = false;
            for (int i = 0; i < array.length-1 ; i++) {
                if(!strCheck(input[i], array[i], array[i+1])) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {

                String number = "";
                for (int i = 0; i < array.length; i++) {
                    number += array[i]+"";
                }
                maxMinCheck(number);
            }
        }
    }

    public static boolean strCheck(String str, int first, int second) {
        boolean rtn = false;
        if(str.equals(">")) {
            if(first > second) {
                rtn = true;
            }
        } else {
            if(first < second) {
                rtn = true;
            }
        }
        return rtn;
    }

    public static void maxMinCheck(String num) {
        if(Integer.parseInt(min) > Integer.parseInt(num)) {
            min = num;
        }
        if(Integer.parseInt(max) < Integer.parseInt(num)) {
            max = num;
        }
    }

}
