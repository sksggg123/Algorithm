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
 * create date  : 2019-10-13 15:59
 */
public class BubbleAlgorithm {
    /**
     * 버블정렬 알고리즘 구현순서
     * 1. index 0 부터 시작하여 우측 index의 값과 비교하여 swap
     * 2. 1회전 이후 마지막 index는 최대값으로 정렬이 되어진다.
     * 3. 2회전은 마지막 index 전 까지 동일하게 수행
     *    .........
     * 4. 정렬 기준 index가 시작지점과 같을때까지 반복
     */
    private static final String TARGET_INDEX_D_TARGET_NUM_D_SOURCE_INDEX_D_SOURCE_NUM_D = "targetIndex : %d\t targetNum : %d\t sourceIndex : %d\t sourceNum : %d";
    private static int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};

    public static void main(String[] args) {
        BubbleAlgorithm main = new BubbleAlgorithm();
        main.run();
    }

    public void run() {
        for (int lastIndex = input.length -1; lastIndex >= 0; lastIndex--) {
            for (int startIndex = 0; startIndex < lastIndex; startIndex++) {
                int left = input[startIndex];
                int right = input[startIndex + 1];
                if (left > right) swap(startIndex, startIndex + 1);
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
 * targetIndex : 0	 targetNum : 10	 sourceIndex : 1	 sourceNum : 6	==> 6 10 8 4 1 5 2 9 3 7
 * targetIndex : 1	 targetNum : 10	 sourceIndex : 2	 sourceNum : 8	==> 6 8 10 4 1 5 2 9 3 7
 * targetIndex : 2	 targetNum : 10	 sourceIndex : 3	 sourceNum : 4	==> 6 8 4 10 1 5 2 9 3 7
 * targetIndex : 3	 targetNum : 10	 sourceIndex : 4	 sourceNum : 1	==> 6 8 4 1 10 5 2 9 3 7
 * targetIndex : 4	 targetNum : 10	 sourceIndex : 5	 sourceNum : 5	==> 6 8 4 1 5 10 2 9 3 7
 * targetIndex : 5	 targetNum : 10	 sourceIndex : 6	 sourceNum : 2	==> 6 8 4 1 5 2 10 9 3 7
 * targetIndex : 6	 targetNum : 10	 sourceIndex : 7	 sourceNum : 9	==> 6 8 4 1 5 2 9 10 3 7
 * targetIndex : 7	 targetNum : 10	 sourceIndex : 8	 sourceNum : 3	==> 6 8 4 1 5 2 9 3 10 7
 * targetIndex : 8	 targetNum : 10	 sourceIndex : 9	 sourceNum : 7	==> 6 8 4 1 5 2 9 3 7 10
 * 외부 loop ---
 * targetIndex : 1	 targetNum : 8	 sourceIndex : 2	 sourceNum : 4	==> 6 4 8 1 5 2 9 3 7 10
 * targetIndex : 2	 targetNum : 8	 sourceIndex : 3	 sourceNum : 1	==> 6 4 1 8 5 2 9 3 7 10
 * targetIndex : 3	 targetNum : 8	 sourceIndex : 4	 sourceNum : 5	==> 6 4 1 5 8 2 9 3 7 10
 * targetIndex : 4	 targetNum : 8	 sourceIndex : 5	 sourceNum : 2	==> 6 4 1 5 2 8 9 3 7 10
 * targetIndex : 6	 targetNum : 9	 sourceIndex : 7	 sourceNum : 3	==> 6 4 1 5 2 8 3 9 7 10
 * targetIndex : 7	 targetNum : 9	 sourceIndex : 8	 sourceNum : 7	==> 6 4 1 5 2 8 3 7 9 10
 * 외부 loop ---
 * targetIndex : 0	 targetNum : 6	 sourceIndex : 1	 sourceNum : 4	==> 4 6 1 5 2 8 3 7 9 10
 * targetIndex : 1	 targetNum : 6	 sourceIndex : 2	 sourceNum : 1	==> 4 1 6 5 2 8 3 7 9 10
 * targetIndex : 2	 targetNum : 6	 sourceIndex : 3	 sourceNum : 5	==> 4 1 5 6 2 8 3 7 9 10
 * targetIndex : 3	 targetNum : 6	 sourceIndex : 4	 sourceNum : 2	==> 4 1 5 2 6 8 3 7 9 10
 * targetIndex : 5	 targetNum : 8	 sourceIndex : 6	 sourceNum : 3	==> 4 1 5 2 6 3 8 7 9 10
 * targetIndex : 6	 targetNum : 8	 sourceIndex : 7	 sourceNum : 7	==> 4 1 5 2 6 3 7 8 9 10
 * 외부 loop ---
 * targetIndex : 0	 targetNum : 4	 sourceIndex : 1	 sourceNum : 1	==> 1 4 5 2 6 3 7 8 9 10
 * targetIndex : 2	 targetNum : 5	 sourceIndex : 3	 sourceNum : 2	==> 1 4 2 5 6 3 7 8 9 10
 * targetIndex : 4	 targetNum : 6	 sourceIndex : 5	 sourceNum : 3	==> 1 4 2 5 3 6 7 8 9 10
 * 외부 loop ---
 * targetIndex : 1	 targetNum : 4	 sourceIndex : 2	 sourceNum : 2	==> 1 2 4 5 3 6 7 8 9 10
 * targetIndex : 3	 targetNum : 5	 sourceIndex : 4	 sourceNum : 3	==> 1 2 4 3 5 6 7 8 9 10
 * 외부 loop ---
 * targetIndex : 2	 targetNum : 4	 sourceIndex : 3	 sourceNum : 3	==> 1 2 3 4 5 6 7 8 9 10
 * 외부 loop ---
 * 외부 loop ---
 * 외부 loop ---
 * 외부 loop ---
 * 외부 loop ---
 */
