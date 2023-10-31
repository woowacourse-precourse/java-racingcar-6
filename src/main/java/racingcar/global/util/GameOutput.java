package racingcar.global.util;

import static racingcar.global.enums.GuideMessage.FINAL_VICTORY;
import static racingcar.global.enums.GuideMessage.GAME_RESULT;

import java.util.List;
import java.util.Map;

public class GameOutput {

    public static void printResult(List<Map<String, String>> result) {
        System.out.println("\n" + GAME_RESULT);
        result.forEach(stringStringMap -> {
            stringStringMap.forEach((s, k) -> System.out.println(s + " : " + k));
            System.out.println();
        });
    }

    public static void printVictory(List<String> victoryList) {
        System.out.print(FINAL_VICTORY);
        System.out.println(String.join(", ", victoryList));
    }
}
