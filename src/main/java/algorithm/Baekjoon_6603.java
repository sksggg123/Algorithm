package algorithm;

import java.util.Scanner;

public class Baekjoon_6603 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int k = sc.nextInt();
            // 입력된 수가 0이면 loop 종료
            if(k == 0) {
                break;
            }
            int[] input = new int[k];
            boolean[] access = new boolean[k];

            // 첫 번째 row : array setting
            for (int i = 0; i < k; i++) {
                int temp = sc.nextInt();
                input[i] = temp;
            }
            if(input.length == 6) {
                print(input);
            } else {
                doCheck(k, input, access);
                System.out.println();
            }
        }
        sc.close();


    }

    private static void doCheck(int k, int[] input, boolean[] access) {
        // 기준점 index 잡아서 실행하기 위한 중간 필터
        for (int i = 0; i < k; i++) {
            int[] sixArray = new int[6];
            sixArray[0] = input[i];
            access[i] = true;
            allCheck(input, sixArray, access, 1, i);
        }
    }

    private static void allCheck(int[] input, int[] sixArray, boolean[] access, int depth, int startIndex) {
        // doCheck 메서드에서 전달한 startIndex 기준으로 loop 시작점 진행
        breakPoint : for (int i = startIndex+1; i < input.length; i++) {
            // 6개의 값 탐색 완료 체크
            if(depth >= 6) {
                // 6개의 값 중 좌측 index의 value값이 더 클 경우 출력 안함 -> 오름차순이 아니기 때문에
                // break breakPoint로 빠져나오기
                for (int j = 0; j < sixArray.length-1 ; j++) {
                    if(sixArray[j + 1] != 0) {
                        if(sixArray[j] > sixArray[j+1]) {
                            break breakPoint;
                        }
                    }
                }
                // 위의 좌/우측 index value값 조건 통과되면 출력문 실행
                print(sixArray);
                break;
            } else {
                // 일반적인 모든순열 탐색 로직
                if (!access[i]) {
                    sixArray[depth] = input[i];
                    access[i] = true;
                    allCheck(input, sixArray, access, depth + 1, startIndex);
                    access[i] = false;
                }
            }
        }
    }

    // 출력문
    private static void print(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}