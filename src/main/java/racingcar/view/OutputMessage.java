package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputMessage {
    static final String BAR = "-";
    public static final String COLON = ":";
    public static final String WINNER_RESULT = "최종 우승자 " + COLON + " ";
    public static final String COMMA = ",";
    public static final String PLAY_RESULT = "\n실행 결과";

    public static void printPlayOutputMessage() {
        System.out.println(PLAY_RESULT);
    }

    public static void printRacingProgressOutputMessage(List<Car> list) {
        for (Car car : list) {
            System.out.println(car.getName() + " " + COLON + " " + BAR.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printResultOutputMessage(List<Car> resultList) {
        StringBuilder resultBuilder = new StringBuilder(WINNER_RESULT);
        for (Car car : resultList) {
            resultBuilder.append(car.getName() + COMMA + " ");
        }
        resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());
        System.out.println(resultBuilder);
    }
}
