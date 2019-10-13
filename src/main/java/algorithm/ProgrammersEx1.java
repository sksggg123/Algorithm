package algorithm;

import java.util.Arrays;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-09-28 09:57
 */
public class ProgrammersEx1 {

    private static int count = 0;
    private static boolean[] accessGood;
    private static boolean[] accessBoxed;

    public static void main(String[] args) {
        int[] goods = {3, 5, 7};
        int[] boxed = {3, 7, 6};

        System.out.println(solution(goods, boxed));
    }

    public static int solution(int[] goods, int[] boxes) {
        int answer = 0;

        accessBoxed = new boolean[boxes.length];
        accessGood = new boolean[goods.length];

        if (goods.length < 1 || goods.length > 100_000) {
            return 0;
        }

        if (boxes.length < 1 || boxes.length > 100_000) {
            return 0;
        }

        // 정렬
        Arrays.sort(goods);
        Arrays.sort(boxes);

        return check(goods, boxes);
    }

    public static int check(int[] goods, int[] boxes) {

        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (!accessBoxed[i]) {
                int box = boxes[i];
                for (int j = 0; j < goods.length; j++) {
                    if (!accessGood[j]) {
                        int good = goods[j];
                        if (box >= good) {
                            accessBoxed[i] = true;
                            accessGood[i] = true;
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static boolean isSizeValue(int size) {
        System.out.println(size);
        return (size < 1 || size > 100_000_000) ? Boolean.TRUE : Boolean.FALSE;
    }


}
