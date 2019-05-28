package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-05-28 11:22
 */
public class Baekjoon_1759 {

    public static void main(String[] args) {

        /**
         * 4 6
         * a t c i s w
         */

        // input data
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();

        String[] input = new String[C];
        boolean[] access = new boolean[C];

        List<String> list = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            list.add(sc.next());
        }
        sc.close();

        // list sort
        Collections.sort(list);

        for (int i = 0; i < C; i++) {
            input[i] = list.get(i);
            access[i] = false;
        }

        // list -> array
        String[] array = new String[L];
        loop(input, array, access, 0, C);
    }

    static void loop(String[] input, String[] array, boolean[] access, int dep, int n){
        if(n > dep) {
            for (int i = 0; i < n; i++) {
                // index 접근하여 추출한 여부 체크
                if(!access[i]) {
                    // dep 번째 index에 i 번째 값을 넣는 부분이 중요
                    array[dep] = input[i];
                    access[i] = true;
                    loop(input, array, access, dep+1, n);
                    // 접근한 index를 다시 false로 초기화 시켜주어야 다음 경우의 순열이 접근가능
                    access[i] = false;
                }
            }
        } else {
            for (String i : array) {
                System.out.print(i);
            }
            System.out.println();
        }
    }


}
