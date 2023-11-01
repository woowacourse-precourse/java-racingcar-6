package racingcar;

import java.util.List;

public class MessagePrinter {

    public static final String INPUT_FOR_CAR_NAME_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_FOR_REPETITIONS_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String POSITION_INDICATOR = "-";

    public static void askCarNameList() {
        System.out.println(INPUT_FOR_CAR_NAME_LIST_MESSAGE);
    }

    public static void askRepetitions() {
        System.out.println(INPUT_FOR_REPETITIONS_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public static void printCurrentPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + POSITION_INDICATOR.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinnerMessage(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }
}
