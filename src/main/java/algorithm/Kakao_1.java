package algorithm;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-09-07 13:58
 */
public class Kakao_1 {
    public static void main(String[] args) {
        Solution_1 sol = new Solution_1();

        System.out.println(sol.solution("aabbcccddee"));
    }
}

class Solution_1 {
    private static String[] arrSplit;
    private static int last;
    private static int subLength;
    private static int length = 1000;
    private static String beforeKeyword = "";

    public int solution(String s) {
        int answer = 0;
        arrSplit = s.split("");
        last = s.length();
        subLength = 1;



        for (int i = 0; i < last; i++) {

            String mergeStr = "";
            int matchCount = 0;

            for (int j = 0; j < last; j = j+subLength) {

                int start = j;
                int end = j+subLength;

                if (!isPossible(end)) {
                    mergeStr += subString(s, start, last);
                    break;
                }
                String subStr = subString(s, start, end);
                String combinStr = "";

                if (!beforeKeyword.equals(subStr)) {

                    for (int k = start; k < last; k = k + subLength) {
                        combinStr = combine(k, k+subLength);
                        if(combinStr.equals(subStr)) {
                            matchCount++;
                        } else {
                            break;
                        }
                    }

                    if (matchCount == 1) {
                        mergeStr += subStr;
                    } else {
                        mergeStr += matchCount+subStr;
                    }
                }

                matchCount = 0;
                beforeKeyword = subStr;
            }
            minLength(mergeStr);
            subLength++;
        }
        return length;
    }

    private String subString(String str, int start, int end) {
        return str.substring(start, end);
    }

    private boolean isPossible(int end) {
        return last >= end ? Boolean.TRUE : Boolean.FALSE;
    }

    private String combine(int start, int end) {
        String combineStr = "";
        for (int i = start; i < end; i++) {
            if (last <= i) {
                return "";
            }
            combineStr += arrSplit[i];
        }
        return combineStr;
    }

    private void minLength(String str) {
        int strLength = str.length();
        if (length > strLength) {
            length = strLength;
        }
    }
}