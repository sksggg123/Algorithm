package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-09-28 10:34
 */
public class ProgrammersEx3 {
    private static boolean[] access;
    public static void main(String[] args) {

        int[] sticker = new int[]{12, 80, 14, 22, 100};
        access = new boolean[sticker.length];

        System.out.println(solution(sticker));
    }

    public static int solution(int[] sticker) {
        int answer = 180;
        List<Integer> stickerList = Arrays.stream(sticker)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(stickerList);
        Collections.reverse(stickerList);

        for (int i = 0; i < stickerList.size(); i++) {

        }

        return answer;
    }
}
