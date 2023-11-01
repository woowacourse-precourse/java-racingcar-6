package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    private static final String PLAY_RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String DISTANCE_MARK = "-";

    public OutputView() {
    }

    public static void printResultMessage() {
        printNewLine();
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public static void showCarsByRound(Car car) {
        System.out.print(car.getName() + COLON);
        for (int distance = 0; distance < car.getPosition(); distance++) {
            System.out.print(DISTANCE_MARK);
        }
        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }
}
