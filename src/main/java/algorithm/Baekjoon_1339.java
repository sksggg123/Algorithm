package algorithm;

import java.util.*;

public class Baekjoon_1339 {

    public static void main(String[] args) {

        // 1. input data setting
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i <n ; i++) {
            input[i] = sc.next();
        }
        sc.close();

        // 2. 0 ~ 9 까지의 숫자배열 생성 및 access array 셋팅
        int[] numberList = new int[10];
        boolean[] access = new boolean[10];
        for (int i = 0; i < 10; i++) {
            numberList[i] = i;
        }

        // 3. row max length 체크 및 Set Collection에 문자 셋팅 (중복제거)
        int maxLength = 0;
        int maxIndex = -1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length ; i++) {
            // 3-1 Set setting
            String[] temp = input[i].split("");
            for (String s : temp) {
                set.add(s);
            }
            // 3-2 max length 체크
            if(maxLength < input[i].length()) {
                maxLength = input[i].length();
                maxIndex = i;
            }
        }

        // 4. 이차원 배열로 가로 : 세로 반전시켜서 초기화
        String[][] revers = new String[maxLength][input.length];
        int[][] reversNumberArray = new int[maxLength][input.length];
        for (int i = 0; i < revers.length ; i++) {
            for (int j = 0; j < input.length; j++) {

            }
        }


    }

}
