package algorithm;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-09-07 10:56
 */
public class Kakao_blind_2018_04 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        int[] food_times = {3,1,1,1,2,4,3};
        int k = 12;
//        int[] food_times = {3,1,2};
//        int k = 5;
        // 6

        System.out.println(sol.solution(food_times, k));
    }
}

class Solution4 {
    private static int eatIndex = 1;
    private static int eatCount = 0;
    private static int[] food;

    public int solution(int[] food_times, long k) {
        food = new int[food_times.length + 1];

        for (int i = 1; i < food.length; i++) {
            food[i] = food_times[i-1];
        }

        if (food_times.length < 1 || food_times.length > 200000) {
            return eatIndex;
        }

        while(true) {
            if(checkNetwork(k)) {
                loopFindLastIndex();
                break;
            } else {
                eat();
            }
        }

        return eatIndex;
    }

    private boolean isEat() {
        initIndex();
        return food[eatIndex] <= 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    private void eat() {


        if (isEat()) {
            food[eatIndex] -= 1;
            print();
            increaseIndex();
            increaseCount();
        } else {
            increaseIndex();
        }
    }

    private void increaseIndex() {
        eatIndex++;
    }

    private void increaseCount() {
        eatCount++;
    }

    private void initIndex() {
        if (eatIndex > food.length -1) {
            eatIndex = 1;
            System.out.println("Init!!");
        }
    }

    private boolean checkNetwork(long time) {
        return eatCount >= time ? Boolean.TRUE : Boolean.FALSE;
    }

    private void print() {
        System.out.print(eatIndex + " -> ");
        for (int i = 0; i < food.length; i++) {
            System.out.print(food[i] + " ");
        }
        System.out.println(" -> " + eatCount);
    }

    private void loopFindLastIndex() {
        int count = 1;
        while(!isEat()) {
            count++;
            if (count > food.length) {
                eatIndex = 1;
                break;
            }
            eatIndex++;
        }
    }

}