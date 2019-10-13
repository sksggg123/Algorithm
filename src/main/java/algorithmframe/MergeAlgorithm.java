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
 * create date  : 2019-10-13 16:29
 */
public class MergeAlgorithm {
    /**
     * 합병정렬 알고리즘 구현순서
     * 1. 분할 : 주어진 숫자를 반으로 분할한다.
     * 2. 정복 : 더이상 분할이 불가능 할 때까지 확인하며 분할을 재귀한다.
     * 3. 결합 : 분할된 숫자들을 정렬을 하며 합친다.
     *
     * 합병정렬의 경우 추가적인 메모리가 필요하다.
     */
    private static final String COUNT_D_LEFT_D_RIGHR_D = "[Divid - %s]\t Count : %d\t left : %d\t mid : %d\t right : %d\t";
    private static final String MERGE_S_LEFT_D_MID_D_RIGHT_D = "[merge]\t\t\t Count : %d\t left : %d\t mid : %d\t right : %d\t";
    private static int[] input = {10, 6, 8, 4, 1, 5, 2, 9, 3, 7};
    private static int[] merge = new int[input.length];
    private static int dividCount = 0;

    public static void main(String[] args) {
        MergeAlgorithm main = new MergeAlgorithm();
        main.run();
    }

    public void run() {
        divid(0, input.length-1, "init");
        printInput();
    }

    // 분할
    public void divid(int left, int right, String flag) {
        dividCount++; // print를 위한 변수
        int mid = (left + right) / 2;
        System.out.println(String.format(COUNT_D_LEFT_D_RIGHR_D, flag, dividCount, left, mid, right));

        if (left < right) {
            divid(left, mid, "left");
            divid(mid+1, right, "right");
            merge(left, mid, right, dividCount);
        }
    }

    public void merge(int left, int mid, int right, int dividCount) {
        System.out.println(String.format(MERGE_S_LEFT_D_MID_D_RIGHT_D, dividCount, left, mid, right));
        int leftStartIndex = left;
        int rightStartIndex = mid + 1;
        int mergeStartIndex = left;

        // 왼쪽 파티션과 오른쪽 파티션의 시작지점부터 비교를 위한 loop
        // left[0] <= right[0]
        // 아래의 loop break 조건까지 완료를 하면 왼쪽 or 오른쪽 파티션의 숫자들이 남는다
        // ex) left {1, 4, 5} | right {2, 3} 에서 아래 loop 수행하면 {1, 2, 3} 까지 정렬 후 loop가 종료 됨. 남은 left에 {4, 5}를 처리해야 한다.
        // 참고) merge 메소드로 전달된 파티션들의 갖고있는 숫자들은 정렬되었다고 봐야 한다.
        while(leftStartIndex <= mid && rightStartIndex <= right) {
            if (input[leftStartIndex] <= input[rightStartIndex]) {
                merge[mergeStartIndex++] = input[leftStartIndex++];
            } else {
                merge[mergeStartIndex++] = input[rightStartIndex++];
            }
        }

        // 위의 loop처리 후 남은 가장 큰 값을 마지막 autoIndex에 넣어준다.
        if (leftStartIndex <= mid) {
            for (int i = leftStartIndex; i <= mid; i++) {
                merge[mergeStartIndex++] = input[leftStartIndex++];
            }
        } else {
            for (int i = rightStartIndex; i <= right; i++) {
                merge[mergeStartIndex++] = input[rightStartIndex++];
            }
        }

        for (int i = 0; i < mergeStartIndex; i++) {
            input[i] = merge[i];
        }
    }
    public void printInput() {
        Arrays.stream(input)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    public void print() {
        Arrays.stream(merge)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}

/**
 * [Divid - init]	 Count : 1	 left : 0	 mid : 4	 right : 9
 * [Divid - left]	 Count : 2	 left : 0	 mid : 2	 right : 4
 * [Divid - left]	 Count : 3	 left : 0	 mid : 1	 right : 2
 * [Divid - left]	 Count : 4	 left : 0	 mid : 0	 right : 1
 * [Divid - left]	 Count : 5	 left : 0	 mid : 0	 right : 0
 * [Divid - right]	 Count : 6	 left : 1	 mid : 1	 right : 1
 * [merge]			 Count : 6	 left : 0	 mid : 0	 right : 1
 * [Divid - right]	 Count : 7	 left : 2	 mid : 2	 right : 2
 * [merge]			 Count : 7	 left : 0	 mid : 1	 right : 2
 * [Divid - right]	 Count : 8	 left : 3	 mid : 3	 right : 4
 * [Divid - left]	 Count : 9	 left : 3	 mid : 3	 right : 3
 * [Divid - right]	 Count : 10	 left : 4	 mid : 4	 right : 4
 * [merge]			 Count : 10	 left : 3	 mid : 3	 right : 4
 * [merge]			 Count : 10	 left : 0	 mid : 2	 right : 4
 * [Divid - right]	 Count : 11	 left : 5	 mid : 7	 right : 9
 * [Divid - left]	 Count : 12	 left : 5	 mid : 6	 right : 7
 * [Divid - left]	 Count : 13	 left : 5	 mid : 5	 right : 6
 * [Divid - left]	 Count : 14	 left : 5	 mid : 5	 right : 5
 * [Divid - right]	 Count : 15	 left : 6	 mid : 6	 right : 6
 * [merge]			 Count : 15	 left : 5	 mid : 5	 right : 6
 * [Divid - right]	 Count : 16	 left : 7	 mid : 7	 right : 7
 * [merge]			 Count : 16	 left : 5	 mid : 6	 right : 7
 * [Divid - right]	 Count : 17	 left : 8	 mid : 8	 right : 9
 * [Divid - left]	 Count : 18	 left : 8	 mid : 8	 right : 8
 * [Divid - right]	 Count : 19	 left : 9	 mid : 9	 right : 9
 * [merge]			 Count : 19	 left : 8	 mid : 8	 right : 9
 * [merge]			 Count : 19	 left : 5	 mid : 7	 right : 9
 * [merge]			 Count : 19	 left : 0	 mid : 4	 right : 9
 * 1 2 3 4 5 6 7 8 9 10
 */
