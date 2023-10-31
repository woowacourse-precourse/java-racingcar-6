package racingcar.global.util;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class GameOutput {

    public static void printResult(List<Map<String, String>> result) {
        System.out.println("실행 결과");
        result.forEach(stringStringMap -> {
            stringStringMap.forEach((s, k) -> System.out.println(s + " : " + k));
            System.out.println();
        });
    }

    public static void printVictory(List<String> victoryList) {
        System.out.print("최종우승자 : ");
        System.out.println(String.join(", ", victoryList));
    }
}
