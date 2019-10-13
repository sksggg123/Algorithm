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

    private static final String TARGET_INDEX_D_TARGET_NUM_D_SOURCE_INDEX_D_SOURCE_NUM_D = "targetIndex : %d\t targetNum : %d\t sourceIndex : %d\t sourceNum : %d";
    private static int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};

    public static void main(String[] args) {
        SelectAlgorithm main = new SelectAlgorithm();
        main.run();
    }

    public int[] run() {

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
        return null;
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
