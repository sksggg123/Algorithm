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
 * create date  : 2019-10-13 15:04
 */
public class SelectAlgorithm {

    /**
     * 선택정렬 알고리즘 구현순서
     * 1. 전달받은 숫자들 중 가장 작은값은 추출
     * 2. 가장 작은값으로 추출된 값과 "정렬되지 않은" 가장 앞의 index의 값과 swap
     */
    private static final String TARGET_INDEX_D_TARGET_NUM_D_SOURCE_INDEX_D_SOURCE_NUM_D = "targetIndex : %d\t targetNum : %d\t sourceIndex : %d\t sourceNum : %d";
    private static int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};

    public static void main(String[] args) {
        SelectAlgorithm main = new SelectAlgorithm();
        main.run();
    }

    public void run() {

        for (int targetIndex = 0; targetIndex < input.length -1; targetIndex++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int sourceIndex = targetIndex; sourceIndex < input.length; sourceIndex++) {
                int flagValue = Integer.compare(min, input[sourceIndex]);
                if (flagValue >= 1) {
                    min = input[sourceIndex];
                    minIndex = sourceIndex;
                }
            }

            if (targetIndex != minIndex) swap(targetIndex, minIndex);
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
 * targetIndex : 0	 targetNum : 10	 sourceIndex : 4	 sourceNum : 1	==> 1 6 8 4 10 5 2 9 3 7
 * targetIndex : 1	 targetNum : 6	 sourceIndex : 6	 sourceNum : 2	==> 1 2 8 4 10 5 6 9 3 7
 * targetIndex : 2	 targetNum : 8	 sourceIndex : 8	 sourceNum : 3	==> 1 2 3 4 10 5 6 9 8 7
 * targetIndex : 4	 targetNum : 10	 sourceIndex : 5	 sourceNum : 5	==> 1 2 3 4 5 10 6 9 8 7
 * targetIndex : 5	 targetNum : 10	 sourceIndex : 6	 sourceNum : 6	==> 1 2 3 4 5 6 10 9 8 7
 * targetIndex : 6	 targetNum : 10	 sourceIndex : 9	 sourceNum : 7	==> 1 2 3 4 5 6 7 9 8 10
 * targetIndex : 7	 targetNum : 9	 sourceIndex : 8	 sourceNum : 8	==> 1 2 3 4 5 6 7 8 9 10
 */