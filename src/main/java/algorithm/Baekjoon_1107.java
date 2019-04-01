package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 5457
 * 3
 * 6 7 8
 */
public class Baekjoon_1107 {

    public static void main(String[] args) {

        String currentChannel = "100";

        // 1. 입력값 세팅 start
        Scanner sc = new Scanner(System.in);
        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            input[i] = sc.nextLine();
        }
        sc.close();
        // 1. 입력값 세팅 end

        // 2. 채널 리스트 셋팅
        String[] channel = input[0].split("");
        List<String> cList = Arrays.asList(channel);

        // 3. 고장난 버튼 리스트 셋팅
        List<String> list = new ArrayList<>();
        for(String temp : input[2].split(" ")) {
            list.add(temp);
        }

        returnNumber(input, list, currentChannel);

    }

    static int returnNumber(String[] input, List<String> list, String currentChannel) {

        int resultNumber = 0;
        String[] channel = input[0].split("");
        String[] inputChannel = new String[channel.length];

        if(input[0].equals(currentChannel)) {
            return 0;
        }

        // 입력가능한 채널 셋팅 (고장나지 않은 버튼)
        for (int i = 0; i < channel.length; i++) {
            if(!list.contains(channel[i])) {
                inputChannel[i] = channel[i];
            }
        }

        for (int i = 0; i < channel.length; i++) {

            if(inputChannel[i].equals(null)) {

                for (int j = 0; j < 10; j++) {

                    int target = Integer.parseInt(channel[i]);

                    if(target >= 5) {

                        for (int k = 5; k < 10; k++) {

                        }

                    } else {

                        for (int k = 4; k >= 0 ; k--) {

                        }

                    }


                }

            }

        }

        return resultNumber;
    }

}

