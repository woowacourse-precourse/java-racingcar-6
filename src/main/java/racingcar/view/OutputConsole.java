package racingcar.view;

import java.util.List;

public class OutputConsole {

    private static final String REQUEST_RACER_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_RACE_NUMBER_OF_TIME = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printRequestRacerNames() {
        System.out.println(REQUEST_RACER_NAMES);
    }

    public static void printRequestRaceNumberOfTime() {
        System.out.println(REQUEST_RACE_NUMBER_OF_TIME);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarStatus(String name, int movementDistance) {
        String carStatus = name + " : " + "-".repeat(movementDistance);
        System.out.println(carStatus);
    }

    public static void printWinner(List<String> winner) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winner));
    }
}
