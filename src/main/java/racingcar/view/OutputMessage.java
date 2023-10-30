package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputMessage {
    static final String BAR = "-";
    public static void printPlayOutputMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRacingProgressOutputMessage(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.println(BAR);
        }
        System.out.println();
    }

    public static void printResultOutputMessage(List<Car> resultList) {
        StringBuilder resultBuilder = new StringBuilder("최종 우승자 : ");
        for (Car car : resultList) {
            resultBuilder.append(car.getName() + ", ");
        }
        resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());
        System.out.println(resultBuilder.toString());
    }
}
