package algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-09-05 23:01
 */
public class Kakao_blind_2018_2 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int N = 4;
//        int[] stages = {4,4,4,4,4};
        sol.solution(N, stages);
    }
}

class Solution2 {

    // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    private static Map<Integer, Integer> stageCount = new HashMap<>();
    private static Map<Integer, Integer> stageFailRate = new HashMap<>();
    private static Map<Integer, Float> stageConvert = new HashMap<>();
    private int lastClearStage = 0;

    public int[] solution(int N, int[] stages) {
        if (N < 1 || N > 500) {
            return null;
        }

        if (stages.length < 1 || stages.length > 200000) {
            return null;
        }

        lastClearStage = N + 1;
        int[] answer = new int[N];

        Arrays.stream(stages)
                .forEach(stage -> stageCount.put(stage, getCount(stage)));

        stageCount.keySet().stream()
                .forEach(key -> stageFailRate.put(key, clearStageCount(key)));

        Arrays.stream(stages)
                .forEach(key -> calculate(key));

        putEmptyStage(N);

        stageConvert.remove(lastClearStage);

        int index = 0;
        while(stageConvert.size() > 0) {
            float max =  stageConvert.values().stream()
                    .max(Float::compare).orElse(Float.valueOf(-1));

            int stageNumber =  stageConvert.keySet().stream()
                    .filter(key -> stageConvert.get(key) == max)
                    .findFirst()
                    .get();

            answer[index] = stageNumber;
            index++;
            stageConvert.remove(stageNumber);
        }

        return answer;
    }

    public int getCount(int stage) {
        if (stageCount.containsKey(stage)) {
            return stageCount.get(stage) + 1;
        }
        return 1;
    }

    public void putEmptyStage(int lastStage) {
        for (int i = 1; i <= lastStage ; i++) {
            if (!stageCount.containsKey(i)) {
                stageCount.put(i, 0);
            }
            if (!stageConvert.containsKey(i)) {
                stageConvert.put(i, Float.valueOf(0));
            }
        }
    }

    public int clearStageCount(int stage) {
        return stageCount.keySet().stream()
                .filter(key -> key >= stage)
                .mapToInt(key -> stageCount.get(key))
                .sum();
    }

    public void calculate(int stage) {
        float stayStage = stageCount.get(stage);
        float clearStage = stageFailRate.get(stage);

        if (clearStage == 0) {
            stageConvert.put(stage, Float.valueOf(0));
        } else {
            stageConvert.put(stage, (stayStage / clearStage));
        }
    }

    public void print(Object stage) {
        System.out.println(stage);
    }
}
