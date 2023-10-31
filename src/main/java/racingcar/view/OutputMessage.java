package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputMessage {
    static final String BAR = "-";
    public static final String COLON = ":";
    public static final String COMMA = ",";

    public static void printPlayOutputMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRacingProgressOutputMessage(List<Car> list) {
        for (Car car : list) {
            System.out.println(car.getName() + " " + COLON + " " + BAR.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printResultOutputMessage(List<Car> resultList) {
        StringBuilder resultBuilder = new StringBuilder("최종 우승자 " + COLON + " ");
        for (Car car : resultList) {
            resultBuilder.append(car.getName() + COMMA + " ");
        }
        resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());
        System.out.println(resultBuilder.toString());
    }
}
