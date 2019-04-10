package algorithm;

import java.util.*;

public class Baekjoon_1339 {

    private static int MAX = 0;
    private static Set<String> set = new HashSet<>();
    private static int[] numList = new int[10];
    static int MAX2 = 0;

    public static void main(String[] args) {

        // 1. input data setting
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i <n ; i++) {
            input[i] = sc.next();
        }
        sc.close();

        // 2. numList setting
        int number = 9;
        for (int i = 0; i < 10 ; i++) {
            numList[i] = number;
            number--;
        }

        // 3. Set Collection에 문자 셋팅
        for (int i = 0; i < input.length ; i++) {
            String[] temp = input[i].split("");
            for (String s : temp) {
                set.add(s);
            }
        }

        int cnt = 0;
        // 문자열
        String[] filter = new String[set.size()];
        // 정수
        int[] num = new int[set.size()];
        // 접근 유무
        boolean[] access = new boolean[set.size()];
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            filter[cnt] = it.next();
            cnt++;
        }

        // set.size 걸러낼수있는 조건 찾아야함..
        if(set.size() == 10) {
            System.out.println(45*input.length);
        } else {
            bfs(input, num, access, set.size(), 0);

            System.out.println(MAX + " | " + MAX2);
        }
    }

    // 9 ~ 0 의 숫자 중 Set Collection Size만큼만 추출하는 순열
    public static void bfs(String[] input, int[] array, boolean[] access, int size, int cnt) {

        if(size > cnt) {
            for (int i = 0; i < size ; i++) {
                if(!access[i]) {
                    array[cnt] = numList[i];
                    access[i] = true;
                    bfs(input, array, access, size, cnt+1);
                    access[i] = false;
                }

            }
        } else {
            sum(input, array);
        }

    }

    public static void sum(String[] input, int[] array) {
        Iterator<String> it = set.iterator();
        // 원본 배열 clone 한 후 작업
        String[] temp = input.clone();
        int cnt = 0;
        int sum = 0;
        // 중복없는 문자열을 가지고 입력받은 문자 replace
        while(it.hasNext()) {
            String str = it.next();
            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i].replace(str, array[cnt]+"");
            }
            cnt++;
        }
        // 입력받은 row의 연산작업
        for (int i = 0; i < temp.length; i++) {
            MAX2++;
            sum += Integer.parseInt(temp[i]);
        }
        // Max 값 비교작업
        MAX = (MAX < sum) ? sum : MAX;
    }
}

// 9864101
