package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baekjoon_2309 {

    static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args) {

        // 1. 입력받기 start
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <9 ; i++) {
            inputList.add(sc.nextInt());
        }
        sc.close();
        // 1. 입력받기 end

        // 2. 9개의 합
        int sum = 0;
        for(int temp : inputList) {
            sum += temp;
        }

        // 3. sum - 100 -> 제외 대상(2개)의 합
        sum -= 100;

        // 4. 제외 대상 검색
        breakPoint : for (int i = 0; i <inputList.size() ; i++) {
            int tempSum = 0;
            for (int j = 0; j <inputList.size() ; j++) {

                if(i != j) {

                    tempSum = inputList.get(i) + inputList.get(j);
                    if(tempSum == sum) {

                        // list의 경우 작은 index 삭제 시 index의 순서가 바뀌기 때문에 조건 필요
                        if( i>j ) {
                            inputList.remove(i);
                            inputList.remove(j);

                        } else {
                            inputList.remove(j);
                            inputList.remove(i);
                        }

                        break breakPoint;
                    }
                }

            }
        }

        // 5. list 정렬
        Collections.sort(inputList);

        for(int temp : inputList) {
            System.out.println(temp);
        }

    }
}
