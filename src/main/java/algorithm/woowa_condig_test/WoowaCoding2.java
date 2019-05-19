package algorithm.woowa_condig_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-05-19 20:40
 */
public class WoowaCoding2 {

    static Map<String, List<String[]>> map = new HashMap<>();

    public static void main(String[] args) {

        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";

        String[] line = s.split("\n");
        List<String> cityIndex = new ArrayList<>();

        int indexNum = 0;
        // setting
        for(String temp : line) {

            indexNum++;
            String[] data = temp.split(", ");
            cityIndex.add(data[1]);
            inputData(data[0], data[1], data[2]);
        }

        String[] rtnArray = new String[indexNum];
        indexNum = 0;
        // compare
        for(String temp : line) {
            String[] data = temp.split(", ");
            String index = compare(data[1], data[2]);
            String[] extend = data[0].split("\\.");
            rtnArray[indexNum] = data[1] + index + "." + extend[1];
            indexNum++;
        }


        String rtn = "";
        for(String tem : rtnArray) {
            rtn += tem + "\n";
            System.out.println(rtn);
        }

    }

    public static String compare(String city, String date) {
        List<String[]> cityData = map.get(city);
        int cnt = 1;
        for (int i = 0; i < cityData.size(); i++) {
            String[] info = cityData.get(i);
            if(compareDate(date, info[2]) == 0) {
                cnt++;
            }
        }

        int prefix = cityData.size() / 10;
        String rtnCnt = "";
        if(prefix > 0) {
            if(cnt < (prefix * 10)) {
                for (int i = 0; i < prefix; i++) {
                    rtnCnt += "0";
                }
            }
        }
        return rtnCnt + cnt;
    }

    public static void inputData(String title, String city, String date) {

        if(map.containsKey(city)) {
            List<String[]> temp = map.get(city);
            String[] info = new String[3];
            info[0] = title;
            info[1] = city;
            info[2] = date;
            temp.add(info);
            map.put(city, temp);
        } else {
            List<String[]> temp = new ArrayList<>();
            String[] info = new String[3];
            info[0] = title;
            info[1] = city;
            info[2] = date;
            temp.add(info);
            map.put(city, temp);
        }
    }

    // date
    public static int compareDate(String target, String source) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date targetDate = null;
        Date sourceDate = null;
        try {
            targetDate = form.parse(target);
            sourceDate = form.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int compare = targetDate.compareTo(sourceDate);
        // >
        if(compare > 0) {
//            System.out.println(targetDate + " > " + sourceDate);
            return 0;
        }
        // <
        else {
            System.out.println(targetDate + " <= " + sourceDate);
            return 1;
        }
    }
}
