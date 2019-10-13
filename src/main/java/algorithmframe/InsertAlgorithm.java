package algorithmframe;

import java.util.Arrays;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-13 15:33
 */
public class InsertAlgorithm {
    /**
     * 삽입정렬 알고리즘 구현순서
     * 1. index 1 부터 좌측으로 탐색을 시작
     * 2. ex) loop 1   -> index 1과 index 0을 비교하여 " index 0 < index 1 " 이라면 2개의 자리를 교체
     * 3. ex) loop 2.1 -> index 2와 index 1을 비교하여 " index 1 < index 2 " 이라면 2개의 자리를 교체
     *    ex) loop 2.2 -> index 1과 index 0을 비교하여 " index 0 < index 1 " 이라면 2개의 자리를 교체
     *    .........
     * 4. 마지막 index까지 탐색
     */
    private static final String TARGET_INDEX_D_TARGET_NUM_D_SOURCE_INDEX_D_SOURCE_NUM_D = "targetIndex : %d\t targetNum : %d\t sourceIndex : %d\t sourceNum : %d";
    private static int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};

    public static void main(String[] args) {
        InsertAlgorithm main = new InsertAlgorithm();
        main.run();
    }

    public void run() {
        for (int startIndex = 1; startIndex < input.length; startIndex++) {
            int targetValue = input[startIndex];

            for (int targetIndex = startIndex-1; targetIndex >= 0 ; targetIndex--) {
                if (targetValue < input[targetIndex]) {
                    targetValue = input[targetIndex +1];
                    swap(targetIndex, targetIndex +1);
                }
            }
            System.out.println("외부 loop ---");
        }
    }

    public void swap(int targetIndex, int sourceIndex) {
        System.out.print(String.format(TARGET_INDEX_D_TARGET_NUM_D_SOURCE_INDEX_D_SOURCE_NUM_D + "\t==> ", targetIndex, input[targetIndex], sourceIndex, input[sourceIndex]));
        int tmp = input[targetIndex];
        input[targetIndex] = input[sourceIndex];
        input[sourceIndex] = tmp;

        print();
    }

    public void print() {
        Arrays.stream(input)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}

/**
 * swap 결과
 * targetIndex : 0	 targetNum : 10	 sourceIndex : 1	 sourceNum : 6	==> 6 10 8 4 1 5 2 9 3 7
 * 외부 loop ---
 * targetIndex : 1	 targetNum : 10	 sourceIndex : 2	 sourceNum : 8	==> 6 8 10 4 1 5 2 9 3 7
 * 외부 loop ---
 * targetIndex : 2	 targetNum : 10	 sourceIndex : 3	 sourceNum : 4	==> 6 8 4 10 1 5 2 9 3 7
 * targetIndex : 1	 targetNum : 8	 sourceIndex : 2	 sourceNum : 4	==> 6 4 8 10 1 5 2 9 3 7
 * targetIndex : 0	 targetNum : 6	 sourceIndex : 1	 sourceNum : 4	==> 4 6 8 10 1 5 2 9 3 7
 * 외부 loop ---
 * targetIndex : 3	 targetNum : 10	 sourceIndex : 4	 sourceNum : 1	==> 4 6 8 1 10 5 2 9 3 7
 * targetIndex : 2	 targetNum : 8	 sourceIndex : 3	 sourceNum : 1	==> 4 6 1 8 10 5 2 9 3 7
 * targetIndex : 1	 targetNum : 6	 sourceIndex : 2	 sourceNum : 1	==> 4 1 6 8 10 5 2 9 3 7
 * targetIndex : 0	 targetNum : 4	 sourceIndex : 1	 sourceNum : 1	==> 1 4 6 8 10 5 2 9 3 7
 * 외부 loop ---
 * targetIndex : 4	 targetNum : 10	 sourceIndex : 5	 sourceNum : 5	==> 1 4 6 8 5 10 2 9 3 7
 * targetIndex : 3	 targetNum : 8	 sourceIndex : 4	 sourceNum : 5	==> 1 4 6 5 8 10 2 9 3 7
 * targetIndex : 2	 targetNum : 6	 sourceIndex : 3	 sourceNum : 5	==> 1 4 5 6 8 10 2 9 3 7
 * 외부 loop ---
 * targetIndex : 5	 targetNum : 10	 sourceIndex : 6	 sourceNum : 2	==> 1 4 5 6 8 2 10 9 3 7
 * targetIndex : 4	 targetNum : 8	 sourceIndex : 5	 sourceNum : 2	==> 1 4 5 6 2 8 10 9 3 7
 * targetIndex : 3	 targetNum : 6	 sourceIndex : 4	 sourceNum : 2	==> 1 4 5 2 6 8 10 9 3 7
 * targetIndex : 2	 targetNum : 5	 sourceIndex : 3	 sourceNum : 2	==> 1 4 2 5 6 8 10 9 3 7
 * targetIndex : 1	 targetNum : 4	 sourceIndex : 2	 sourceNum : 2	==> 1 2 4 5 6 8 10 9 3 7
 * 외부 loop ---
 * targetIndex : 6	 targetNum : 10	 sourceIndex : 7	 sourceNum : 9	==> 1 2 4 5 6 8 9 10 3 7
 * 외부 loop ---
 * targetIndex : 7	 targetNum : 10	 sourceIndex : 8	 sourceNum : 3	==> 1 2 4 5 6 8 9 3 10 7
 * targetIndex : 6	 targetNum : 9	 sourceIndex : 7	 sourceNum : 3	==> 1 2 4 5 6 8 3 9 10 7
 * targetIndex : 5	 targetNum : 8	 sourceIndex : 6	 sourceNum : 3	==> 1 2 4 5 6 3 8 9 10 7
 * targetIndex : 4	 targetNum : 6	 sourceIndex : 5	 sourceNum : 3	==> 1 2 4 5 3 6 8 9 10 7
 * targetIndex : 3	 targetNum : 5	 sourceIndex : 4	 sourceNum : 3	==> 1 2 4 3 5 6 8 9 10 7
 * targetIndex : 2	 targetNum : 4	 sourceIndex : 3	 sourceNum : 3	==> 1 2 3 4 5 6 8 9 10 7
 * 외부 loop ---
 * targetIndex : 8	 targetNum : 10	 sourceIndex : 9	 sourceNum : 7	==> 1 2 3 4 5 6 8 9 7 10
 * targetIndex : 7	 targetNum : 9	 sourceIndex : 8	 sourceNum : 7	==> 1 2 3 4 5 6 8 7 9 10
 * targetIndex : 6	 targetNum : 8	 sourceIndex : 7	 sourceNum : 7	==> 1 2 3 4 5 6 7 8 9 10
 * 외부 loop ---
 */
