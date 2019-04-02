package algorithm;

import java.util.*;

public class Baekjoon_9095 {

    static List<Integer> list = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        int[] arr = new int[row];
        for (int i = 0; i < row; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < arr.length; i++) {
            bfs(arr[i], 0, 1);
            bfs(arr[i], 0, 2);
            bfs(arr[i], 0, 3);

            list.add(cnt);
            cnt = 0;
        }

        for(int temp : list) {
            System.out.println(temp);
        }
    }

    static void bfs(int limit, int sum, int target) {

        sum+=target;
        if(sum <= limit) {

            if (sum == limit) {
                cnt++;
            } else {

                bfs(limit, sum, 1);
                bfs(limit, sum, 2);
                bfs(limit, sum, 3);
            }
        }
    }
}
