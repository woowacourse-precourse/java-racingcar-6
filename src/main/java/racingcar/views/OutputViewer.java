package racingcar.views;


import static racingcar.utils.Constants.NOTATION_OF_DISTANCE;
import static racingcar.utils.Constants.SPLITTER_BETWEEN_NAME_AND_DISTANCE;
import static racingcar.utils.Constants.SPLITTER_OF_WINNERS;

import java.util.List;
import racingcar.utils.StringChanger;

public class OutputViewer {

    private OutputViewer() {
    }

    public static void printRequestingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestingNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printNoticeResultWillBePrinted() {
        System.out.println("실행 결과");
    }

    public static void printMovedDistanceOfCar(String carName, int movedDistance) {
        String roadPassed = NOTATION_OF_DISTANCE.repeat(movedDistance);

        System.out.println(carName + SPLITTER_BETWEEN_NAME_AND_DISTANCE + roadPassed);
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");

        for (String winner : winners) {
            stringBuilder.append(winner).append(SPLITTER_OF_WINNERS);
        }

        System.out.println(StringChanger.cutLastRegex(stringBuilder, SPLITTER_OF_WINNERS));
    }
}
