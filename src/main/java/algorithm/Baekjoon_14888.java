package algorithm;

import java.util.Scanner;

public class Baekjoon_14888 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] numList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numList = new int[n];
        int[] fourCount = new int[4];
        for (int i = 0; i < n; i++) {
            numList[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < fourCount.length ; i++) {
            int temp = sc.nextInt();
            cnt += temp;
            fourCount[i] = temp;
        }
        // 문자열 array setting
        String[] operator = new String[cnt];
        String[] putOper = new String[cnt];
        boolean[] access = new boolean[cnt];
        cnt = 0;
        for (int i = 0; i < fourCount.length ; i++) {
            for (int j = 0; j < fourCount[i] ; j++) {
                if(i==0) {
                    operator[cnt] = "+";
                    cnt++;
                } else if (i==1) {
                    operator[cnt] = "-";
                    cnt++;
                } else if (i==2) {
                    operator[cnt] = "*";
                    cnt++;
                } else  {
                    operator[cnt] = "/";
                    cnt++;
                }
            }
        }
        sc.close();

        combineNumAndOperator(operator, putOper, access, 0);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void combineNumAndOperator(String[] operator, String[] putOper, boolean[] access, int depth) {

        if(depth >= operator.length) {
            checkMaxMin(putOper);
        } else {
            // 일반 적인 순열 탐색 로직
            for (int i = 0; i < operator.length ; i++) {
                if(!access[i]) {
                    putOper[depth] = operator[i];
                    access[i] = true;
                    combineNumAndOperator(operator, putOper, access, depth+1);
                    access[i] = false;
                }
            }
        }
    }

    private static void checkMaxMin(String[] operator) {
        int cal = numList[0];
        for (int i = 1; i < numList.length; i++) {
            int num = numList[i];
            String type = operator[i-1];
            cal = calculate(cal, num, type);
        }
        MAX = (MAX < cal) ? cal : MAX;
        MIN = (MIN > cal) ? cal : MIN;
    }

    private static int calculate(int num1, int num2, String type) {
        int cal = 0;

        switch (type) {
            case "+" :
                cal = num1 + num2;
                break;
            case "-" :
                cal = num1 - num2;
                break;
            case "*":
                cal = num1 * num2;
                break;
            case "/" :
                boolean num1Flag = false;
                boolean num2Flag = false;

                if(num1 < -1) {
                    num1Flag = true;
                    num1*= -1;
                }
                if(num2 < -1) {
                    num2Flag = true;
                    num2*=-1;
                }

                cal = num1 / num2;

                if(num1Flag) {
                    cal *= -1;
                }
                if(num2Flag) {
                    cal *= -1;
                }
                break;
        }
        return cal;
    }
}