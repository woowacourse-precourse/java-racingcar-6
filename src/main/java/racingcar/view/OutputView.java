package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.utils.Constant;

public class OutputView {

    public static void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRoundResult(Map<String, Integer> roundInfo) {
        for (Map.Entry<String, Integer> entry : roundInfo.entrySet()) {
            String carName = entry.getKey();
            Integer position = entry.getValue();
            System.out.println(carName + " : " + "-".repeat(position));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnersName) {
        String winnerNames = String.join(Constant.DELIMITER, winnersName);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
