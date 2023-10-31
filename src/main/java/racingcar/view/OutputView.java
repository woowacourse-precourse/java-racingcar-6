package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.constant.SystemMessage;

public class OutputView {

    public static void printCarNameAndPosition(LinkedHashMap<String, Integer> carNamePositionMap) {
        for (Map.Entry<String, Integer> entry : carNamePositionMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(SystemMessage.GAME_RESULT);
    }

    public static void printCarNamesInputMessage() {
        System.out.println(SystemMessage.CAR_NAMES_INPUT);
    }

    public static void printTryCountInputMessage() {
        System.out.println(SystemMessage.TRY_COUNT_INPUT);
    }

    public static void printVictoryCarNames(List<String> victoryCarName) {
        System.out.print(SystemMessage.LABEL_WINNER + String.join(", ", victoryCarName));
        System.out.println();
    }
}
