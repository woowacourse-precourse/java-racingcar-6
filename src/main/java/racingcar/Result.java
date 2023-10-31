package racingcar;

import java.util.List;
import java.util.Map;

// 결과 판정하고 출력하는 클래스
public class Result {
    public static void showMiddle(Map<String, Integer> status) {
        for(Map.Entry<String, Integer> entry: status.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + "-".repeat(value));
        }
        System.out.println();
    }

    public static void showFinal(Map<String, Integer> status) {
        int max = status.values().stream().max(Integer::compare).orElse(-1);
        List<String> winners = status.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
