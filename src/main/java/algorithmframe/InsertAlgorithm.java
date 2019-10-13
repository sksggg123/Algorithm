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
                    swap(targetIndex, targetIndex +1);
                }
            }
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
