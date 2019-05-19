package algorithm.woowa_condig_test;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-05-19 17:54
 */
public class WoowaCoding1 {

    public static void main(String[] args) {


        int convert = Integer.parseInt("011100", 2);
        int cnt = 0;

        while(true) {
            if(convert != 0) {
                // 짝수
                if(checkNumber(convert)) {
                    convert = convert / 2 ;
                    System.out.println(convert);
                }
                // 홀수
                else {
                    convert -= 1;
                    System.out.println(convert);
                }
                cnt++;


            } else {
                break;
            }

        }

        System.out.println(convert + " " + cnt);

    }
    public static boolean checkNumber(int check) {

        return (check%2) == 0 ? true : false;
    }
}
