package racingcar.global.util;

import static racingcar.global.enums.GuideMessage.FINAL_VICTORY;
import static racingcar.global.enums.GuideMessage.GAME_RESULT;

import java.util.List;
import java.util.Map;

public class GameOutput {

    /**
     * 라운드의 결과 출력을 담당하는 메서드
     * @param result
     */
    public static void printResult(List<Map<String, String>> result) {
        System.out.println("\n" + GAME_RESULT);
        result.forEach(stringStringMap -> {
            stringStringMap.forEach((s, k) -> System.out.println(s + " : " + k));
            System.out.println();
        });
    }

    /**
     * 최종 우승 차량의 출력을 담당하는 메서드
     * @param victoryList
     */
    public static void printVictory(List<String> victoryList) {
        System.out.print(FINAL_VICTORY);
        System.out.println(String.join(", ", victoryList));
    }
}
