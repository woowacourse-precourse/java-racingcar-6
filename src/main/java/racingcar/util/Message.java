package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class Message {
    private static final String DASH = "-";
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_COUNT_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCreateCarListMessage(String car) {
        System.out.println(car);
    }

    public static void printAskCountMessage(String num) {
        System.out.println(ASK_COUNT_MESSAGE + num);
    }

    public static void printRacingResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRacingWinnerMessage(String winner) {
        System.out.println(WINNER_MESSAGE + winner + "\n\n");
    }

    public static void printMoveResultMessage(List<Car> carList) {
        carList.forEach(x ->
                System.out.println(x.getName() + " : " + DASH.repeat(x.getPosition()))
        );
        System.out.println();
    }
}
