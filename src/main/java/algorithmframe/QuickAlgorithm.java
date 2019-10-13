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
 * create date  : 2019-10-13 21:40
 */
public class QuickAlgorithm {
    /**
     * 퀵정렬 알고리즘 구현순서
     * 1. 주어진 숫자들에 pivot을 기준으로 좌측엔 작은숫자들, 우측엔 큰 숫자들로 배치한다.
     * 2. 좌, 우측으로 분활된 리스트를 정렬한다.
     * 3. 분할된 부분을 더이상 pivot 기준으로 분할하지 못할 때까지 분할처리 한다.
     */

    private static int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};

    public static void main(String[] args) {
        QuickAlgorithm main = new QuickAlgorithm();
        main.run();
    }

    public void run() {
        int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};
        combine(input, 0, input.length - 1);
    }

    public void combine(int[] raw, int left, int right) {
        print(raw);
        if (left < right) {
            int partition = partition(raw, left, right);
            combine(raw, left, partition - 1);
            combine(raw, partition + 1, right);
        }
    }

    public int partition(int[] raw, int left, int right) {
        int pivot = left;
        // pivot 다음 index 부터 체크가 시작되야 하기에
        left++;

        // left와 right가 교차하는지 확인
        while (left < right) {
            // left가 right를 지나쳤는지, left와 pivot 값이 맞는지 (left에는 작은 값으로 되어야 함.)
            while ((left <= right && raw[left] < raw[pivot])) {
                left++;
            }

            // right가 left를 지나쳤는지, right와 pivot 값이 맞는지 (right에는 큰 값으로 되어야 함.)
            while ((right >= left && raw[right] > raw[pivot])) {
                right--;
            }

            // left와 right가 서로 교차한 것이 아니라면 2개의 값을 swap
            // 교차유무를 확인하지 않고 교환을 하게 되면 ArrayIndexOutOfBoundsException이 발생할 수 있다.
            if (left < right) {
                swap(raw, left, right);
            }
        }

        swap(raw, pivot, right);
        return right;
    }

    public void swap(int[] raw, int targetIndex, int sourceIndex) {
        int tmp = raw[targetIndex];
        raw[targetIndex] = raw[sourceIndex];
        raw[sourceIndex] = tmp;
    }

    public void print(int[] target) {
        Arrays.stream(target)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}

/**
 * 10 6 8 4 1 5 2 9 3 7
 * 7 6 8 4 1 5 2 9 3 10
 * 2 6 3 4 1 5 7 9 8 10
 * 1 2 3 4 6 5 7 9 8 10
 * 1 2 3 4 6 5 7 9 8 10
 * 1 2 3 4 6 5 7 9 8 10
 * 1 2 3 4 6 5 7 9 8 10
 * 1 2 3 4 6 5 7 9 8 10
 * 1 2 3 4 6 5 7 9 8 10
 * 1 2 3 4 5 6 7 9 8 10
 * 1 2 3 4 5 6 7 9 8 10
 * 1 2 3 4 5 6 7 9 8 10
 * 1 2 3 4 5 6 7 8 9 10
 * 1 2 3 4 5 6 7 8 9 10
 * 1 2 3 4 5 6 7 8 9 10
 */
