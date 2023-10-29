package racingcar.domain;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String MOVE_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String LOCATION = "-";

    public static void printCarNamesMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
    }

    public static void printMoveCountMessage() {
        System.out.println(MOVE_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarsLocation(Cars cars) {
        Map<String,Integer> moveCountMap = cars.getMoveCountMap();
        moveCountMap.forEach(OutputView::printCarLocation);
        System.out.println();
    }

    public static void printCarLocation(String name, Integer moveCount) {
        String location = LOCATION.repeat(moveCount);
        System.out.println(name + " : " + location);
    }

    public static void printWinner(List<String> winnerList) {
        System.out.print(WINNER_MESSAGE);
        for (int index = 0; index < winnerList.size(); index++) {
            System.out.print(winnerList.get(index));
            if (index != winnerList.size() - 1) {
                System.out.print(WINNER_DELIMITER);
            }
        }
    }
}
