package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printCarNameAndPosition(LinkedHashMap<String, Integer> carNamePositionMap) {
        for (Map.Entry<String, Integer> entry : carNamePositionMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printVictoryCarNames(List<String> victoryCarName) {
        System.out.print("최종 우승자 : " + String.join(", ", victoryCarName));
        System.out.println();
    }
}
