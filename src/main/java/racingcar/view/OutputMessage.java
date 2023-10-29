package racingcar.view;

import racingcar.domain.Car;

public class OutputMessage {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printRandomPlayResultPositionMessage(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getPosition()));
    }

    public static void printLn() {
        System.out.println();
    }
}