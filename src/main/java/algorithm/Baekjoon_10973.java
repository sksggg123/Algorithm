package algorithm;

import java.util.Scanner;


public class Baekjoon_10973 {

    public static void main(String[] args) {

        // 1. 찾고자하는 순열 (TestCase로 입력된 순열)
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        boolean returnMessage = false;

        // 2. 마지막 index 부터 loop 시작
        breakpoint : for (int i = n-1; i >= 1 ; i--) {

            int source = -1;

            // 좌측 Index 값과 우측 Index값을 비교하며, 좌측 Index값이 더 크면 추가 로직 수행 (좌측 > 우측)
            if(input[i-1] > input[i]) {
                returnMessage = true;
                source = i-1;

                int min = -1;

                // 4. 마지막 Index부터 target Index까지 loop 재시작 (이중 반복문)
                for (int j = n-1; j >= i; j--) {

                    // 5. source Index값과 step4의 loop Index값을 비교하여 값 찾기 (source Index > loop Index)
                    if(input[source] > input[j]) {
                        min = source + 1;
                        // 6. source Index <-> loop Index, 2개의 값을 swap 한다.
                        int temp = input[j];
                        input[j] = input[source];
                        input[source] = temp;
                        int max = n-1;

                        // 7. 마지막으로 source Index의 우측 index 부터 마지막 index까지 revers 시켜준다.
                        while(min < max) {
                            int revers = input[max];
                            input[max] = input[min];
                            input[min] = revers;
                            min++;
                            max--;
                        }

                        break breakpoint;
                    }
                }
            }
        }

        // 결과값 return returnMessage = true 이면 정렬의 첫번째 -> 이전순서가 없음.
        if(returnMessage) {
            for (int i = 0; i < input.length ; i++) {
                System.out.print(input[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}