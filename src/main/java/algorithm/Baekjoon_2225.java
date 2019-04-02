package algorithm;

public class Baekjoon_2225 {
    public static void main(String[] args) {
        int n = 20;
        int k = 2;

        if(!(n >= 1 && n <= 200)) {

        }

        if(!(k >= 1 && k <= 200)) {

        }

        int cnt = 0;
        for (int i = 0; i <= n ; i++) {

            for (int j = 0; j <= n; j++) {

                if(i+j == n) {
                    cnt++;
                    System.out.printf("i: $d, j: %d, sum: %d, cnt: %d \n", i, j, i+j, cnt);

                } else if(i+j > n) {
                    break;
                }

            }

        }

    }
}
