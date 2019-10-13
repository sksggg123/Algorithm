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
     * 4. 정렬 기준 index가 시작지점과 같을때까지 반
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
