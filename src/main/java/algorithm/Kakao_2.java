
package algorithm;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-09-10 09:40
 */
public class Kakao_2 {
    public static void main(String[] args) {
        Solution_2 sol = new Solution_2();
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};

        System.out.println(sol.solution(key, lock));
    }
}

class Solution_2 {

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        print(key);
        System.out.println();
        int[][] temp = up(key);
        print(temp);


        return answer;
    }

    private int[][] up(int[][] target) {
        int[][] temp = new int[target.length][target[0].length];
        int[] defaultArr = new int[target.length];

        for (int i = 0; i < target.length; i++) {
            int[] swap = target[i].clone();
            if (i == 0) {
                temp[target.length-1] = defaultArr.clone();
            } else {
                temp[i-1] = swap.clone();
            }
        }

        return temp;
    }

    private int[][] down(int[][] target) {
        int[][] temp = new int[target.length][target[0].length];
        int[] defaultArr = new int[target.length];

        for (int i = 0; i < target.length; i++) {
            int[] swap = target[i].clone();
            if (i == target.length -1) {
                temp[0] = defaultArr.clone();
            } else {
                temp[i-1] = swap.clone();
            }
        }

        return temp;
    }

    private void print(int[][] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                System.out.print(target[i][j] + " ");
            }
            System.out.println();
        }
    }
}
